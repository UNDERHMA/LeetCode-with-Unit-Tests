package leetcode.LeetCode;

public class RemoveDuplicatesFromSortedArray {

	public static int removeDuplicates(int[] nums) {
        
		if(nums.length == 0) {
			return 0;
		}
		
		int length = 1;
		int greatest = nums[0];
		
		for(int i = 0; i < nums.length-1; i++) {
			if(nums[i] == nums[i+1] || nums[i+1] <= greatest) {
				for(int j = i + 2; j < nums.length; j++) {
					if(nums[i] == nums[j] || nums[j] <= greatest) {
					}
					else {
						nums[i+1] = nums[j];
						greatest = nums[i+1];
						length++;
						i += 1;
					}
				}
			}
			else if(nums[i+1] > greatest) {
				length++;
				greatest = nums[i+1];
			}
		}
		return length;
    }
}
