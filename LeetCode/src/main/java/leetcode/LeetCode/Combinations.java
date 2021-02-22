package leetcode.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

	public List<List<Integer>> combine(int n, int k) {
		
		if(n == 0 || k == 0) return null;
		List<List<Integer>> resultList = new ArrayList<>();
		List<Integer> resultToAdd = new ArrayList<>();
		
		for(int i = 1 ; i <= n-k+1; i++) {
			resultToAdd.add(i);
			generateCombinations(resultList,i+1,k-1,n,resultToAdd);
			resultToAdd.remove(0);
		}
		return resultList;
    }
	
	public void generateCombinations(List<List<Integer>> resultList, int start,
			int numbersLeft, int end, List<Integer> resultToAdd) {
		
		if(numbersLeft == 0) {
			resultList.add(new ArrayList<>(resultToAdd));
			return;
		}
		
		for(int i = start ; i <= (end -(numbersLeft-1)); i++) {
			resultToAdd.add(i);
			generateCombinations(resultList,i+1,numbersLeft-1,end,resultToAdd);
			resultToAdd.remove(resultToAdd.size()-1);
		}
	}
}
