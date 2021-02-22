package leetcode.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations {
	
	// code inspired by https://www.baeldung.com/java-array-permutations
	static List<List<Integer>> result = new ArrayList<>();
	
	public static List<List<Integer>> permute(int[] nums) {
		result = new ArrayList<>();
        int n = nums.length;
        permute(n,nums);
        return result;
    }
	
	public static List<List<Integer>> permute(int n, int[] nums) {
        if(n==1) {
        	List<Integer> newResult = Arrays.stream(nums)
        									.boxed()
        									.collect(Collectors.toList());
        	result.add(newResult);
        }
        else {
        	for(int i = 0; i < n-1; i++) {
        		permute(n-1,nums);
        		if(n % 2 == 0) {
        			swap(nums,i,n-1);
        		}
        		else{
        			swap(nums,0,n-1);
        		}
        	}
        	permute(n-1,nums);
        }
        return result;
    }
	
	public static void swap(int[] nums, int index1, int index2) {
		int temp = nums[index1];
		nums[index1] = nums[index2];
		nums[index2] = temp;
	}
}
