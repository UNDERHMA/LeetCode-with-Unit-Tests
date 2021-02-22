package leetcode.LeetCode;

import java.util.PriorityQueue;

public class MergeKSortedLists {

	public ListNode mergeKLists(ListNode[] lists) {
       
		PriorityQueue<ListNode>	queue = new PriorityQueue<>((a,b) -> (a.val-b.val));
		for(ListNode l : lists) {
			while(l != null) {
				queue.add(l);
				l = l.next;
			}
		}
		ListNode newHead = queue.poll();
		ListNode current = newHead;
		while(!queue.isEmpty()) {
			current.next = queue.poll();
			current = current.next;
		}
		if(current != null) current.next = null; // stops any inaccurate next values on last element
		return newHead;
    }
	
}
