package leetcode.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
	
	private static List<List<Integer>> results = new ArrayList<>();
	
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		
		results.clear();
		Arrays.sort(candidates);
		
		for(int i = 0; i < candidates.length; i++) {
			if(candidates[i] <= target) {
				List<Integer> newPossible = new ArrayList<>();
				newPossible.add(candidates[i]);
				calculate(candidates,target,i,newPossible);
			}
		}
		return results;	
    }
	
	public static void calculate(int[] array, int target, int startIndex, List<Integer> possibleSolution) {
		
		int sum = 0;
		for(int i : possibleSolution) {
			sum += i;
		}
		
		if(sum == target) {
			List<Integer> newSolution = new ArrayList<>();
			for(int i : possibleSolution) {
				newSolution.add(i);
			}
			results.add(newSolution);
			return;
		}
		else if(sum > target) {
			return;
		}
		else if(sum < target) {
			for(int i = startIndex; i <= array.length-1; i++) {
				possibleSolution.add(array[i]);
				calculate(array,target,i,possibleSolution);
				possibleSolution.remove(possibleSolution.size()-1);
			}
		}
	}
}
