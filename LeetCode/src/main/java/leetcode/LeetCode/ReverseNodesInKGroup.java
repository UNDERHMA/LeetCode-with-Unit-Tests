package leetcode.LeetCode;

public class ReverseNodesInKGroup {

	public ListNode reverseKGroup(ListNode head, int k) {
        
		int numberOfReversals = 0;
		int kCount = 0;
		ListNode current = head;
		while(current != null) {
			kCount++;
			if(kCount == k) {numberOfReversals++; kCount = 0;}
			current = current.next;
		}
		
		ListNode temp = null;
		ListNode prev = head;
		ListNode newHead = null;
		ListNode oldTail = null;
		while(numberOfReversals > 0) {
			ListNode newTail = prev;
			current = prev.next;
			kCount = 0;
			while(kCount < k-1) {	// need to make k-1 reversals
				temp = current.next;
				current.next = prev;
				prev = current;
				current = temp;
				kCount++;
			}
			if(newHead == null) newHead = prev;
			else oldTail.next = prev;
			newTail.next = temp;
			oldTail = newTail;
			numberOfReversals--;
			prev = current;
		}
		return newHead;	
    }   
}
