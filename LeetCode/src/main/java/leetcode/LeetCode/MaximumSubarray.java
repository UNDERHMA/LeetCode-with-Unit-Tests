package leetcode.LeetCode;

public class MaximumSubarray {

	public static int maxSubArray(int[] nums) {
        
		int maximumWholeArray = Integer.MIN_VALUE;
		int maximumCurrent = 0;
		
		for(int i = 0; i < nums.length; i++) {
			maximumCurrent = maximumCurrent + nums[i];
			if(maximumCurrent > maximumWholeArray) {
				maximumWholeArray = maximumCurrent;
			}
			if(maximumCurrent < 0) {
				maximumCurrent = 0;
			}
		}
		return maximumWholeArray;
    }
}
