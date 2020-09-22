package leetcode.LeetCode;

public class SearchInsertPosition {
	
	public static int searchInsert(int[] nums, int target) {
        
		if(nums.length == 0) {
			return 0;
		}
		
		int start = 0;
		int end = nums.length - 1;
		
		
		while(start < end) {
			if(nums[(end+start)/2] > target) {
				end = (end+start)/2;
			}
			else if (nums[(end+start)/2] < target) {
				if((end+start)/2 == start && (end+start) % 2 == 0) {
					start = (end+start)/2;
				}
				else if((end+start)/2 == start) {
					start = (end+start)/2 + 1;
				}
				else {
					start = (end+start)/2;
				}
			}
			else if(nums[(end+start)/2] == target) {
				return (end+start)/2;
			}
		}
		
		if(nums[start] >= target) {
			return start;
		}
		else {
			return start+1;
		}
    }
	
	
}
