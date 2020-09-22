package leetcode.LeetCode;

import java.util.Arrays;

public class ContainerWithMostWater {
	public static int maxArea(int[] height) {
		
        int[] sortedArray = height.clone();
        Arrays.sort(sortedArray);
        
        int maxPossible = sortedArray[sortedArray.length-1];
        int left;
        int right;
        int maxArea = 0;
        
        for(int i = 0; i < height.length; i++) {
        	left = i;
        	right = height.length-1;
        	
        	while(left < right) {
	        	if(maxPossible*(right-left) < maxArea) {
	        		break;
	        	}
	        	if(((right-left) * Math.min(height[left], height[right])) > maxArea) {
	        		maxArea = (right-left) * Math.min(height[left], height[right]);
	        	}
	        	right--;
        	}	
        }
        return maxArea;
    }
}
