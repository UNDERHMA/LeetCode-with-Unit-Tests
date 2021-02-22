package leetcode.LeetCode;

public class RotateList {
	
		public ListNode rotateRight(ListNode head, int k) {
        
		if(head == null) return null;
		
		// count number of list items
		int count = 0;
		ListNode current = head;
		while(current != null) {
			current = current.next;
			count++;
		}
		
		
		// iterate to new head index and restructure list
		int indexOfNewHead = count - (k % count);
		if(indexOfNewHead == count) return head;
		current = head;
		for(int i = 0; i < indexOfNewHead; i++) {
			if(i+1 == indexOfNewHead) {
				ListNode temp = current;
				current = current.next;
				temp.next = null;
				ListNode tempHead = head;
				head = current;
				i++;
				while(i < count-1) {
					current = current.next;
					i++;
				}
				current.next = tempHead;
			} else {current = current.next;};
		}
		return head;
    }

}
