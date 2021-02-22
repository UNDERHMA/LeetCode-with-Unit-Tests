package leetcode.LeetCode;

public class RemoveDuplicatesFromSortedListII {
	public ListNode deleteDuplicates(ListNode head) {
			
			ListNode dummy = new ListNode(-1,head);
			ListNode first = dummy;
			ListNode second = head;
			
			while(second != null && second.next != null) {
				if(second.val == second.next.val) {
					while(second.next != null &&
							second.val == second.next.val) {
						second = second.next;
					}
					if(second.next == null) first.next = null;
					else {
						second = second.next;
						if(second.next == null) first.next = second;
					}
				}
				else {
					first.next = second;
                    first = second;
					second = second.next;
				}
			}
			return dummy.next;
	}		
}
