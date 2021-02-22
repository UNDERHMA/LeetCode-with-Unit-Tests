package leetcode.LeetCode;

import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleInHistogram {
	
	public int largestRectangleArea(int[] heights) {
        
		int heightsLength = heights.length;
		if(heightsLength == 1) return heights[0];
		int[] leftExpansions = new int[heightsLength];
		Arrays.fill(leftExpansions, 10001); //helpful for when we reach index 0 and need to backtrack
		int[] rightExpansions = new int[heightsLength];
		rightExpansions[heightsLength-1] = heightsLength;
		leftExpansions[0] = -1;
		Stack<Integer> boundaryCalculator = new Stack<>();
		
		// Calculating right Expansions
		boundaryCalculator.push(heights[0]);
		for(int i = 1; i < heightsLength; i++) {
			if(heights[i] < boundaryCalculator.peek()
					&& heights[i] < boundaryCalculator.peek()) {
				int index = i-1;
				while(!boundaryCalculator.isEmpty()
						&& heights[i] < boundaryCalculator.peek()) {
					if(rightExpansions[index] == 0) {
						boundaryCalculator.pop();
						rightExpansions[index--] = i;
					} else index--;
				}
			} 
			// reached end with stack not empty
			if(i == heights.length -1) {
				int index = i-1;
				while(!boundaryCalculator.isEmpty()) {
					if(rightExpansions[index] == 0) {
						boundaryCalculator.pop();
						rightExpansions[index--] = i+1;
					} else index--;
				}
			}
			boundaryCalculator.push(heights[i]);
		}	
		
		// Calculating left Expansions
		boundaryCalculator.clear();
		boundaryCalculator.push(heights[heightsLength-1]);
		for(int i = heightsLength-2; i > -1; i--) {
			if(heights[i] < boundaryCalculator.peek()) {
				int index = i+1;
				while(!boundaryCalculator.isEmpty() 
						&& heights[i] < boundaryCalculator.peek()) {
					if(leftExpansions[index] == 10001) {
						boundaryCalculator.pop();
						leftExpansions[index++] = i;
					} else index++;
				}
			} 
			// reached end with stack not empty
			if(i == 0) {
				int index = i+1;
				while(!boundaryCalculator.isEmpty()) {
					if(leftExpansions[index] == 10001) {
						boundaryCalculator.pop();
						leftExpansions[index++] = i-1;
					} else index++;
				}
			}
			boundaryCalculator.push(heights[i]);
		}	
		
		//Calculating Max
		int max = 0;
		int currentMaxValue = 0;
		for(int i = 0; i < heightsLength; i++) {
			currentMaxValue = heights[i] * 
					((rightExpansions[i] - leftExpansions[i]) - 1);
			max = Math.max(max, currentMaxValue);
		}
		return max;
	}
}
