package leetcode.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindFirstAndLastPositionOfElementInSortedArray {
	public static int[] searchRange(int[] nums, int target) {
		
		if(nums.length == 0) {
			return new int[] {-1, -1};
		}
		
		int end = nums.length;
		int start = 0;
		int[] result = binarySearch(nums,start,end,target);
		return result;
    }
	
	public static int[] binarySearch(int[] array, int start, int end, int target) {
		
		List<Integer> result = new ArrayList<>();
		int[] resultArray = new int[] {-1, -1};
		
		while(start < end) {
			int mid = (end + start) / 2;
			if(array[mid] > target) {
				end = mid;
			}
			else if(array[mid] < target) {
				start = mid+1;
			}
			else if(array[mid] == target) {
				result.add(mid);
				int temp = mid;
				if(mid > 0) {
					mid--;
					while (mid >= 0 && array[mid] == target) {
						result.add(mid);
						mid--;
					}
				}
				mid = temp;
				if(mid < array.length - 1) {
					mid++;
					while (mid < array.length && array[mid] == target) {
						result.add(mid);
						mid++;
					}
				}
			}
			
			if(result.size() > 0) {
				Collections.sort(result);
				resultArray[0] = result.get(0);
				resultArray[1] = result.get(result.size()-1);
				return resultArray;
			}
		}
		return resultArray;
	}
}
