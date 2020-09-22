package leetcode.LeetCode;

public class RemoveElement {
	public static int removeElement(int[] nums, int val) {
        
		if(nums.length == 0) {
			return 0;
		}
		
		int pointer1 = 0;
        int pointer2 = nums.length-1;
        int removedCount = 0;
        
        while(pointer1 <= pointer2) {
        	if(nums[pointer1] == val) {
        		removedCount++;
        		while(nums[pointer2] == val && pointer1 < pointer2) {
        			removedCount++;
        			pointer2--;
        		}
        		nums[pointer1] = nums[pointer2];
        		pointer2--;
        	}
        	pointer1++;
        }
        
        return nums.length - removedCount;
    }
}
