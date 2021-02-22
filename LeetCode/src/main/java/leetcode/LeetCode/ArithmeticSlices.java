package leetcode.LeetCode;

public class ArithmeticSlices {

	public int numberOfArithmeticSlices(int[] A) {
		
		int aLength = A.length;
		int end;
		int validSlices = 0;
		int difference;
		for(int i = 0; i < aLength-2; i++) {
			end = i + 2;
			difference = A[i+1] - A[i];
			while(end < aLength && A[end] - A[end-1] == difference) {
				validSlices += end-i-1;
				end++;
			}
			i = end-2;
		}
		return validSlices;
	}
}
