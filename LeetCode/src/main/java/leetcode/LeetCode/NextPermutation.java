package leetcode.LeetCode;

import java.util.Arrays;

public class NextPermutation {
	public static void nextPermutation(int[] nums) {
	    
		if(nums.length == 0 || nums.length == 1) {
			return;
		}
		
		boolean modified = false;
		for(int i = nums.length-2; i >= 0; i--) {
			if(modified == true) {
				break;
			}
			for(int j = i+1; j <= nums.length-1; j++) {
				if(nums[j] > nums[i]) {
					int min = nums[j];
					int minIndex = j;
					for(int k = j; k <= nums.length-1; k++) {
						if(nums[k] > nums[i]) {
							min = Math.min(min, nums[k]);
							minIndex = k;
						}
					}
					int temp = nums[i];
					nums[i] = nums[minIndex];
					nums[minIndex] = temp;
					mergeSort(nums, j, nums.length-1);
					modified = true;
					break;
				}
				if(i == 0 && j == 1 && nums[i] != nums[j]) {
					mergeSort(nums, 0, nums.length-1);
					modified = true;
					break;
				}
			}
		}
    }
	
	public static void mergeSort(int[] subArray, int startIndex, int endIndex) {
		if(startIndex >= endIndex) {
			return;
		}
		int mid = (startIndex + endIndex) / 2;
		mergeSort(subArray,startIndex,mid);
		mergeSort(subArray,mid+1,endIndex);
		merge(subArray, startIndex, endIndex, mid);
	}
	
	public static void merge(int[] subArray, int startIndex, int endIndex, int mid) {
		int midPlusOne = mid+1;
		while(startIndex <= mid || midPlusOne <= endIndex) {
			if(midPlusOne > endIndex) {
				while(startIndex < endIndex) {
					if(subArray[startIndex] > subArray[startIndex+1]) {
						int temp = subArray[startIndex];
						subArray[startIndex] = subArray[startIndex+1];
						subArray[startIndex+1] = temp;
					}
					startIndex++;
				}
			}
			else if(startIndex > mid) {
				return;
			}
			else if(subArray[startIndex] > subArray[midPlusOne]){
				int temp = subArray[startIndex];
				subArray[startIndex] = subArray[midPlusOne];
				subArray[midPlusOne] = temp;
				midPlusOne++;
			}
			startIndex++;
		}
	}
	
}
