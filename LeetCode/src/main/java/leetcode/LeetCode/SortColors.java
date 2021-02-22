package leetcode.LeetCode;

public class SortColors {

	public void sortColors(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        sortColors(nums,start,end);
    }
	
	public void sortColors(int[] nums, int start, int end) {
        if(start >= end) return;
		int mid = (start + end) >>> 1;
        
		sortColors(nums,mid+1,end);
		sortColors(nums,start,mid);
		merge(nums,start,end);
    }
	
	public void merge(int[] nums, int start, int end) {
		int[] temp = new int[(end-start)+1];
		int startPointer = start;
		int midPointer = ((start + end) >>> 1)+1;
		int mid = midPointer;
			
		// fill in temp array with proper ordering
		for(int i = 0; i < temp.length; i++) {
			if(startPointer >= mid) {
				temp[i] = nums[midPointer];
				midPointer++;
			}
			else if(midPointer > end){
				temp[i] = nums[startPointer];
				startPointer++;
			}
			else if(nums[startPointer] <= nums[midPointer]) {
				temp[i] = nums[startPointer];
				startPointer++;
			}
			else {
				temp[i] = nums[midPointer];
				midPointer++;
			}
		}
		
		// copy sorted temp array into nums array
		int tempStart = 0;
		for(int i = start; i <= end; i++) {
			nums[i] = temp[tempStart++];
		}
	}
}
