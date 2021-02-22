package leetcode.LeetCode;

import java.util.Arrays;

public class FormArrayByConcatenatingSubarraysOfAnotherArray {
	public boolean canChoose(int[][] groups, int[] nums) {
        
		int groupsLength = groups.length;
		int[] groupsLastValue = new int[groupsLength];
		Arrays.fill(groupsLastValue,-1);
		int numsLength = nums.length;
		int[] groupsCurrent;
		int groupsCurrentIndex;
		
		for(int i = 0 ; i < groupsLength; i++) {
			groupsCurrent = groups[i];
			for(int j = 0; j < numsLength; j++) {
				groupsCurrentIndex = 0;
				if(groupsCurrent[groupsCurrentIndex] == nums[j]) {
					groupsCurrentIndex++;
					j++;
					for(int k = 1; k < groupsCurrent.length; k++) {
						if(groupsCurrent[groupsCurrentIndex++] != nums[j]) {
							groupsCurrentIndex = 0;
							break;
						}
						j++;
					}
					if(groupsCurrentIndex == groupsCurrent.length) {
						groupsLastValue[i] = --j;
						while(groupsCurrentIndex > 0) {
							nums[j] = Integer.MAX_VALUE;
							groupsCurrentIndex--;
							j--;
						}
					}
				}
			}
		}
		
		int lastValue = 0;
		int groupsLastValueLength = groupsLastValue.length;
		for(int i = 0; i < groupsLastValueLength; i++) {
			if(lastValue > groupsLastValue[i]) return false;
			lastValue = groupsLastValue[i];
		}
		return true;		
    }
}
