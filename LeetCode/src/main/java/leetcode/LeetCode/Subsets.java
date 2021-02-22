package leetcode.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
	public List<List<Integer>> subsets(int[] nums) {
		
		List<List<Integer>> result = new ArrayList<>();
        List<Integer> resultToAdd = new ArrayList<>();
        
        result.add(new ArrayList<>(resultToAdd));
		
        for(int i = 0; i < nums.length; i++) {
        	resultToAdd.add(nums[i]);
        	result.add(new ArrayList<>(resultToAdd));
        	generateSubsets(result,resultToAdd,nums,i+1,nums.length-1);
        	resultToAdd.remove(0);
        }
		return result;
    }
	
	public void generateSubsets(List<List<Integer>> result, List<Integer> 
	resultToAdd, int[] nums, int start, int end) {
		for(int i = start; i <= end; i++) {
			resultToAdd.add(nums[i]);
			result.add(new ArrayList<>(resultToAdd));
			generateSubsets(result,resultToAdd,nums,i+1,end);
        	resultToAdd.remove(resultToAdd.size()-1);
		}
	}
}
