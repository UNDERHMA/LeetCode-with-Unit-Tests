package leetcode.LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationsII {

	public List<List<Integer>> permuteUnique(int[] nums) {
        
		List<List<Integer>> result = new ArrayList<>();
		Set<String> usedCombinations = new HashSet<>();
		permuteUnique(nums,0,usedCombinations,result);
		return result;
    }
	
	public List<List<Integer>> permuteUnique(int[] nums, int start, Set<String> usedCombinations,
			List<List<Integer>> result) {
        
		if(start == nums.length) {
			StringBuilder unique = new StringBuilder();
			for(int i : nums) {
				unique.append(i);
			}
			if(!usedCombinations.contains(unique.toString())) {
				usedCombinations.add(unique.toString());
				List<Integer> newResult = new ArrayList<>();
				for(int i : nums) {
					newResult.add(i);
				}
				result.add(newResult);
			}
		}
		else {
			for(int i = start; i < nums.length; i++) {
				swap(nums,i,start);
				permuteUnique(nums,i+1,usedCombinations,result);
				swap(nums,i,start);
			}
		}
		return result;
    }
	
	public static void swap(int[] array, int index1, int index2) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
}
