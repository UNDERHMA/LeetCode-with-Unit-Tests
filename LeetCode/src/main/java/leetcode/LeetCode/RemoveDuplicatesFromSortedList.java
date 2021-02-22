package leetcode.LeetCode;

public class RemoveDuplicatesFromSortedList {

		    public ListNode deleteDuplicates(ListNode head) {
		        if(head == null) return null;
		    	ListNode current = head;
		    	ListNode next = current.next;
		    	while(next != null) {
		    		if(current.val == next.val) {
		    			next = next.next;
		    			current.next = next;
		    		}
		    		else {
		    			current = next;
		    			next = next.next;
		    		}
		    	}
		    	return head;
		    }
}
