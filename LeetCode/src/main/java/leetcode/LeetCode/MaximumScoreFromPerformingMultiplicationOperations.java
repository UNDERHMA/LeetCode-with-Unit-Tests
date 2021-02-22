package leetcode.LeetCode;

import java.util.Arrays;

public class MaximumScoreFromPerformingMultiplicationOperations {

	public int maximumScore(int[] nums, int[] multipliers) {
        
		int opCount = 0;
		int score = 0;
		int opNumber = multipliers.length;
		int[][] memo = new int[opNumber][nums.length];
		for(int[] m : memo) Arrays.fill(m, Integer.MIN_VALUE);
		return maxScore(nums,multipliers,opCount,score,opNumber,0,nums.length-1,memo);		
    }

	public int maxScore(int[] nums, int[] multipliers, int opCount, int score, 
			int opNumber, int start, int end, int[][] memo) {
		
		if(opCount == opNumber) return score;
		if(memo[start][end] < score) {
			memo[start][end] = score;
		} else if(score < memo[start][end]) return Integer.MIN_VALUE;
		return Math.max(maxScore(nums,multipliers,opCount+1,score 
				+ (multipliers[opCount] * nums[start]),opNumber,start+1,end,memo),
				maxScore(nums,multipliers,opCount+1,score 
						+ (multipliers[opCount] * nums[end]),opNumber,start,end-1,memo));	
	}
}
