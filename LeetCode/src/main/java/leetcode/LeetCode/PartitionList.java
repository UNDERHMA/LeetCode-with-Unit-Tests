package leetcode.LeetCode;

public class PartitionList {
	public ListNode partition(ListNode head, int x) {
        
		ListNode current = head;
		ListNode firstNodeGreaterOrEqual;
		ListNode cutOutNodesHead = null;
		ListNode cutOutNodesCurrent = null;
		
		// iterate until we find value >= x
		while(current != null && current.val < x) {
			current = current.next;
		}
		// set 1st node with value >= x to firstNodeGreaterOrEqual or return if no node exists
		if(current != null) firstNodeGreaterOrEqual = current;
		else return head;
		
		/* iterate through half of list after firstNodeGreaterOrEqual, adding
		 * all nodes < x to a new chain and cutting them out of the right half
		 * of the list.
		 */
		ListNode previous = current;
		while(current != null) {
			if(current.val < x) {
				if(cutOutNodesHead == null) {
					cutOutNodesHead = current;
					cutOutNodesCurrent = current;
				}
				else {
					cutOutNodesCurrent.next = current;
					cutOutNodesCurrent = cutOutNodesCurrent.next;
				}
				current = current.next;
				previous.next = current; // cut moved node out right side of the chain
				continue;
			}
			previous = current;
			current = current.next;
		}
		
		/* set the next value on the last node of the cut out nodes equal to the
			firstNodeGreaterOrEqual, preserving order in right and left halves */
		if(cutOutNodesCurrent != null)
			cutOutNodesCurrent.next = firstNodeGreaterOrEqual;
	        else return head;
		
		/* Then, either just return the head if the cut out nodes represent 
		 * all values before firstNodeGreaterOrEqual. If there were already nodes
		 * before firstNodeGreaterOrEqual (aka firstNodeGreaterOrEqual != head),
		 * then iterate from the original head until current.next = firstNodeGreaterOrEqual.
		 * Once at that node, set the next value to the head of the cut out chain,
		 * which will complete the chain, and you can return the orignal head.  */
		if(head == firstNodeGreaterOrEqual) {
			head = cutOutNodesHead;
		} else {
			current = head;
			while(current.next != firstNodeGreaterOrEqual) {
				current = current.next;
			}
			current.next = cutOutNodesHead;
		}
		return head;
    }
}
