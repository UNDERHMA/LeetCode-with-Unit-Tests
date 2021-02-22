package leetcode.LeetCode;

public class PlusOne {
	public int[] plusOne(int[] digits) {
        
		int index = digits.length-1;
		digits[index] += 1;
		
		while(digits[index] == 10 && index > 0) {
			digits[index] = 0;
			index--;
			digits[index] += 1;
		}
		if(index == 0 && digits[index] == 10) {
			int[] newDigits = new int[digits.length+1];
			newDigits[0] = 1;
			newDigits[1] = 0;
			for(int i = 1; i < digits.length; i++) {
				newDigits[i+1] = digits[i];
			}
			digits = newDigits;
		}
		return digits;
    }
}
