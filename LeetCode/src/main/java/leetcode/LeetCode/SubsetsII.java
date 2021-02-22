package leetcode.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubsetsII {

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		
		Arrays.sort(nums);
		List<List<Integer>> subsetsWithDupResult = new ArrayList<List<Integer>>();
		List<Integer> subsetToAdd = new ArrayList<>();
		subsetsWithDupResult.add(subsetToAdd); // add blank list to results
		int numsLength = nums.length;
		if(numsLength < 1) return subsetsWithDupResult;
		
		
		Set<String> uniqueAnswers = new HashSet<>();	
		StringBuilder answerString;
		for(int i = 0 ; i < numsLength; i++) {
			answerString = new StringBuilder();
			answerString.append(String.valueOf(nums[i]));
			uniqueAnswers.add(answerString.toString());
			calculateUniqueSubsets(nums,uniqueAnswers,answerString,i+1,numsLength);
		}
		
		// iterate through uniqueAnswers set, format as list and return
		for(String s : uniqueAnswers) {
			String[] tokenizedString = s.split(",");
			subsetToAdd = new ArrayList<>();
			for(String numAsString : tokenizedString) {
				subsetToAdd.add(Integer.parseInt(numAsString));
			}
			subsetsWithDupResult.add(subsetToAdd);
		}
		return subsetsWithDupResult;
	}
	
	public void calculateUniqueSubsets(int[] nums, Set<String> uniqueAnswers,
			StringBuilder answerString, int start, int end) {
			
		int temp;
		for(int i = start ; i < end; i++) {
			temp = nums[i];
			answerString.append("," + String.valueOf(temp));
			calculateUniqueSubsets(nums,uniqueAnswers,answerString,i+1,end);
			
			if(uniqueAnswers.contains(answerString.toString())) ; // memoization
			else uniqueAnswers.add(answerString.toString()); // only add if unique
			
			if(temp == -10) answerString.setLength(answerString.length()-4);
			else if(temp == 10) answerString.setLength(answerString.length()-3);
			else answerString.setLength(answerString.length()-2);
		}
	}
}
