package leetcode.LeetCode;

import java.math.BigInteger;

public class AddTwoNumbers {
	
	public static class ListNode {
		      int val;
		      ListNode next;
		      ListNode() {}
		      ListNode(int val) { this.val = val; }
		      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
		  }
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
     
		BigInteger sum = new BigInteger("0");
		BigInteger firstNumber = new BigInteger("0");
		BigInteger secondNumber = new BigInteger("0");
		BigInteger multiplier = new BigInteger("1");
		boolean run = true;
		
		while(run) {
			firstNumber = firstNumber.add(multiplier.multiply(BigInteger.valueOf(l1.val)));
			multiplier = multiplier.multiply(BigInteger.valueOf(10));
			if(l1.next == null) {
				run = false;
			}
			l1 = l1.next;
		}
		run = true;
		multiplier = new BigInteger("1");
		while(run) {
			secondNumber = secondNumber.add(multiplier.multiply(BigInteger.valueOf(l2.val)));
			multiplier = multiplier.multiply(BigInteger.valueOf(10));
			if(l2.next == null) {
				run = false;
			}
			l2 = l2.next;
		}
		
		sum = firstNumber.add(secondNumber);
		String asString = String.valueOf(sum);
		ListNode result = new ListNode();
		ListNode temp = new ListNode();
		ListNode current = new ListNode();
		
		for(int i = asString.length()-1; i >= 0; i--) {
			if(i == asString.length()-1 && asString.length()-1 != 0) {
			    result.val = Character.getNumericValue(asString.charAt(i));
			    result.next = current;
			}
			else if(i == asString.length()-1 && asString.length()-1 == 0) {
			    result.val = Character.getNumericValue(asString.charAt(i));
			}
			else if(i != 0) {
				current.val = Character.getNumericValue(asString.charAt(i));
				temp = current;
				current = new ListNode();
				temp.next = current;
			}
			else {
				current.val = Character.getNumericValue(asString.charAt(i));
			}
		}
		return result;
    }
	
}
