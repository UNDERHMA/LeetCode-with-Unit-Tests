package leetcode.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSum {
	
	public static List<List<Integer>> fourSum(int[] nums, int target) {
		
		Arrays.sort(nums);
		Set<List<Integer>> noDuplicates = new HashSet<>();
		List<List<Integer>> result = new ArrayList<>();
		
		for(int i = 0; i < nums.length-3; i++) {
			for(int j = i+1; j < nums.length-2; j++) {
				Boolean isGreater = false;
				int k = j+1;
				int l = nums.length-1;
				if(nums[i]+nums[j]+nums[k]+nums[l] > target) {
					isGreater = true;
				}
				while(k < l) {
					if(nums[i]+nums[j]+nums[k]+nums[l] == target) {
						if(!noDuplicates.contains(Arrays.asList(nums[i],nums[j],nums[k],nums[l]))) {
							noDuplicates.add(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));
							List<Integer> newInts = new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));
							result.add(newInts);
						}
						if(isGreater) {
							l--;
						}
						else {
							k++;
						}
					}
					else if(nums[i]+nums[j]+nums[k]+nums[l] > target) {
						l--;
					}
					else if(nums[i]+nums[j]+nums[k]+nums[l] < target) {
						k++;
					}
					// terminate loop after we know we won't return anymore results
					if(isGreater && nums[i]+nums[j]+nums[k]+nums[l] < target
							&& l-k == 1) {
						if(l < nums.length-1 && nums[l+1] < 0) {
							isGreater = false;
							k++;
						}
						break;
					}
					else if(!isGreater && nums[i]+nums[j]+nums[k]+nums[l] > target
							&& l-k == 1) {
						if(nums[k-1] > 0 && k-1 > j) {
							isGreater = true;
							k--;
						}
						else {
							break;
						}
					}
				}
			}
		}
		return result;
    }

}
