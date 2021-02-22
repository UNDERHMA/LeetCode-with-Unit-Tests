package leetcode.LeetCode;

public class ReverseLinkedListII {

	public ListNode reverseBetween(ListNode head, int m, int n) {
        
		if(m == n || head == null || head.next == null) return head;
		ListNode dummy = new ListNode(0,head);
		ListNode current;
		ListNode prev;
		int toFlip = n - m;
		int index = 1;
		
		while(index < m) {
			index++;
			dummy = dummy.next;
		}
		
		prev = dummy.next;
		current = prev.next;
		while(toFlip > 0) {
			toFlip--;
			ListNode temp = current.next;
			if(toFlip == 0) {
				dummy.next.next = temp;
				dummy.next = current;
			}
			// reverse current to point to prev
			current.next = prev;
			// move current and prev forward 1
			prev = current;
			current = temp;
		}
		if(m == 1) return dummy.next;
		else return head;
    }

}
