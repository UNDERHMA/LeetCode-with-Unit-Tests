package leetcode.LeetCode;

public class SwapNodesInPairs {

	public static ListNode swapPairs(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode current = head;
		while(current.next != null) {
			int temp = current.val;
			current.val = current.next.val;
			current.next.val = temp;
			//set current to current.next.next
			if(current.next.next != null) {
				current = current.next.next;
			}
			else {
				break;
			}
		}
		return head;
    }
	
	public static class ListNode {
		 int val;
		 ListNode next;
		 ListNode() {}
		 ListNode(int val) { this.val = val; }
		 ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
}
