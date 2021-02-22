package leetcode.LeetCode;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArrayII {
	public int removeDuplicates(int[] nums) {
		
		if(nums.length < 1) return 0;
		if(nums.length <= 2) return nums.length;
		
        int numLength = nums.length-1;
        int startPointer = numLength;
		int nextPointer = numLength-1;
		int duplicateCount = 0;
        int removed = 0;
        int max = nums[numLength];
        
        while(nextPointer >= 0) {
        	if(nums[startPointer] == nums[nextPointer]) {
        		duplicateCount++;
        	} else {
        		startPointer = nextPointer;
        		duplicateCount = 0;
        	}
        	if(duplicateCount > 1) {
        		nums[nextPointer] = max+1;
        		removed++;
        	}
        	nextPointer--;
        }
        
        Arrays.sort(nums);
        return numLength+1-removed;
    }
}
