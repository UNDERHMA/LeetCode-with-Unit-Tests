package leetcode.LeetCode;

public class ContainerWithMostWaterII {
	
	public int maxArea(int[] height) {
		
		if(height.length < 2) return 0;
		int containerStartIndex = 0;
		int containerEndIndex = height.length-1;
		int max = 0;
		
		while(containerStartIndex < containerEndIndex) {
			if(height[containerStartIndex] < height[containerEndIndex]) {
				max = Math.max(max, height[containerStartIndex] 
						* (containerEndIndex - containerStartIndex));
				containerStartIndex++;
			}
			else {
				max = Math.max(max, height[containerEndIndex] 
						* (containerEndIndex - containerStartIndex));
				containerEndIndex--;
			}
		}
		return max;
	}
}
