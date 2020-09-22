package leetcode.LeetCode;

public class MergeTwoSortedLists {
	
	public static class ListNode {
		      int val;
		      ListNode next;
		      ListNode() {}
		      ListNode(int val) { this.val = val; }
		      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
		      
		    @Override
			public String toString() {
				return "ListNode [val=" + val + ", next=" + next + "]";
			}
		  }

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
		if(l1 == null && l2 == null) {
			return null;
		}
		else if(l1 == null) {
			return l2;
		}
		else if(l2 == null) {
			return l1;
		}
		
		ListNode resultFront = new ListNode();
		ListNode resultCurrent = new ListNode();
		ListNode resultNext = new ListNode();
		boolean isFirst = true;
		
		boolean complete = false;
		boolean runUntil = true;
		
		while(!complete) {
			if(isFirst) {
				resultFront = resultCurrent;
				isFirst = false;
			}
			else if(l1.val <= l2.val) {
				resultCurrent.val = l1.val;
				resultCurrent.next = resultNext;
				resultCurrent = resultNext;
				resultNext = new ListNode();
				
				if(l1.next != null) {
					l1 = l1.next;
				}
				else if(l1.next == null) {
					while(runUntil) {
						resultCurrent.val = l2.val;
						if(l2.next == null) {
							runUntil = false;
						}
						else {
							l2 = l2.next;
							resultCurrent.next = resultNext;
							resultCurrent = resultNext;
							resultNext = new ListNode();
						}
					}
					complete = true;
				}
			}
			else if(l1.val > l2.val) {
				resultCurrent.val = l2.val;
				resultCurrent.next = resultNext;
				resultCurrent = resultNext;
				resultNext = new ListNode();
				
				if(l2.next != null) {
					l2 = l2.next;
				}
				else if(l2.next == null) {
					while(runUntil) {
						resultCurrent.val = l1.val;
						if(l1.next == null) {
							runUntil = false;
						}
						else {
							l1 = l1.next;
							resultCurrent.next = resultNext;
							resultCurrent = resultNext;
							resultNext = new ListNode();
						}
					}
					complete = true;
				}
			}
		}
		return resultFront;
    }
}
