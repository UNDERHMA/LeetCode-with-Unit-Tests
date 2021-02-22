package leetcode.LeetCode;

public class SearchInRotatedSortedArrayII {
	public boolean search(int[] nums, int target) {
		
 		int start = 0;
		int end = nums.length-1;
		int mid = (end-start) >>> 1;
		boolean passedElementGreaterThanStart = false;
        
		if(nums[end] > nums[start]) return binarySearch(start,end,nums,target);
		
		while(start < end) {
			mid = (end+start) >>> 1;
			if(nums[start] > nums[mid]) {
				end = mid;
			} 
			else if(nums[start] == nums[mid]) {
				int tempMid = mid;
				if(tempMid == start) {
					if(nums[start] <= nums[start+1]) end = start; 
					else start = end;
					break;
				}
				while(nums[tempMid] == nums[start] && start!=tempMid) {
					tempMid--;
				}
				if(nums[tempMid] > nums[start]) {
					start = tempMid+1;
					end = start;
				}
				else if(tempMid == start && passedElementGreaterThanStart) {
					end = start;
				}
				else if(tempMid == start) {
					start = mid;
				}
				else {
					start = tempMid;
					end = start;
				}
			}
			else {
				if(passedElementGreaterThanStart && nums[end] >= nums[start]) {
					end = start;
					break;
				}
				passedElementGreaterThanStart = true;
				start = mid+1;
			}
		}
		
		if(start-1 > 0) {
			if(nums[start-1] <= nums[start]) {
				start++;	// start must be incremented 1 to be true pivot (pivot is min value in array)
			}
		}
		//binary search, before and after pivot
		return binarySearch(0,start-1,nums,target) 
				|| binarySearch(start,nums.length-1,nums,target);
    }
	
	public boolean binarySearch(int startIndex, int endIndex, int[] nums,
			int target) {
		
		int mid;
		while(startIndex <= endIndex) {
			mid = (endIndex+startIndex) >>> 1;
			if(nums[mid] == target) {
				return true;
			} 
			else if(nums[mid] > target) {
				endIndex = mid-1;
			}
			else {
				startIndex = mid+1;
			}
		}
		return false;
	}
}
