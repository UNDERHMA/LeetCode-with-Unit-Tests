package leetcode.LeetCode;

public class JumpGameII {
	public int jump(int[] nums) {
		
		int[] tabulation = new int[nums.length];
		int numsLength = nums.length;
		if(numsLength == 0 || numsLength == 1) return 0;
		int currentMinSteps;
		for(int i = numsLength-2; i >= 0; i--) {
			if(nums[i] + i >= numsLength-1) tabulation[i] = 1;
			else {
				currentMinSteps = tabulation[i+1] + 1;
				for(int j = nums[i]; j > 1; j--) {
					currentMinSteps = Math.min(currentMinSteps,tabulation[j+i] + 1);
					if(currentMinSteps == 2) break;
				}
				tabulation[i] = currentMinSteps;
			}
		}
		return tabulation[0];
    }
	
}
