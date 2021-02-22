package leetcode.LeetCode;

public class JumpGame {
	
	public boolean canJump(int[] nums) {		
		int currentIndex = 0;
		boolean[] visited = new boolean[nums.length];
		return canJump(currentIndex,nums, visited);
    }
	
	public boolean canJump(int currentIndex, int[] nums, boolean[] visited) {
		if(currentIndex == nums.length-1) return true; // can reach last index
		if(currentIndex >= nums.length) return false;
		visited[currentIndex] = true; // memoization
		int jumpValue = nums[currentIndex];
		boolean success = false;
		while(jumpValue > 0 && success == false) {
			if(jumpValue + currentIndex < nums.length &&
					visited[jumpValue+currentIndex] == false) {
			success = canJump(jumpValue+currentIndex, nums, visited);
			}
			jumpValue--;
		}
		return success;
	}

}
