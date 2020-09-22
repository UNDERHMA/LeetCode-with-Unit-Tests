package leetcode.LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenerateParentheses {
	
	private static List<String> resultList = new ArrayList<>();
	
	public static List<String> generateParenthesis(int n) {
		
		resultList.clear();
		
		if(n == 0) {
			return resultList;
		}
		else if (n == 1) {
			resultList.add("()");
			return resultList;
		}
        
        List<Character> leftParentheses = new ArrayList<>();
        List<Character> rightParentheses = new ArrayList<>();
        
        int count = 0;
        while(count < n) {
        	leftParentheses.add('(');
        	rightParentheses.add(')');
        	count++;
        }
     
        StringBuilder possibleSolution = new StringBuilder();
        
        permute(possibleSolution, leftParentheses, rightParentheses);
        return resultList;
    }
	
	public static void permute(StringBuilder solutionString, List<Character> left, List<Character> right) {
		
		List<Character> rightParentheses = new ArrayList<>();
        List<Character> leftParentheses = new ArrayList<>();
		
		if(left.size() < right.size() && !left.isEmpty()) {
			populate(rightParentheses,leftParentheses,right,left);
	        Collections.copy(rightParentheses, right);
	        Collections.copy(leftParentheses, left);
			StringBuilder newPossibleSolution = new StringBuilder(solutionString);
			newPossibleSolution.append(right.get(0));
			rightParentheses.remove(0);
			permute(newPossibleSolution, leftParentheses, rightParentheses);
			leftParentheses.clear();
			rightParentheses.clear();
		}
		if(left.size() == right.size() && !left.isEmpty()) {
			populate(rightParentheses,leftParentheses,right,left);
	        Collections.copy(rightParentheses, right);
	        Collections.copy(leftParentheses, left);
			StringBuilder newPossibleSolution = new StringBuilder(solutionString);
			newPossibleSolution.append(left.get(0));
			leftParentheses.remove(0);
			permute(newPossibleSolution, leftParentheses, rightParentheses);
			leftParentheses.clear();
			rightParentheses.clear();
		}
		if(left.size() < right.size() && !left.isEmpty()) {
			populate(rightParentheses,leftParentheses,right,left);
	        Collections.copy(rightParentheses, right);
	        Collections.copy(leftParentheses, left);
			StringBuilder newPossibleSolution = new StringBuilder(solutionString);
			newPossibleSolution.append(left.get(0));
			leftParentheses.remove(0);
			permute(newPossibleSolution, leftParentheses, rightParentheses);
			leftParentheses.clear();
			rightParentheses.clear();
		}
		if(left.isEmpty() && !right.isEmpty()) {
			populate(rightParentheses,leftParentheses,right,left);
	        Collections.copy(rightParentheses, right);
	        Collections.copy(leftParentheses, left);
			StringBuilder newPossibleSolution = new StringBuilder(solutionString);
			newPossibleSolution.append(right.get(0));
			rightParentheses.remove(0);
			permute(newPossibleSolution, leftParentheses, rightParentheses);
		}
		if(left.isEmpty() && right.isEmpty()) {
			StringBuilder newPossibleSolution = new StringBuilder(solutionString);
			resultList.add(newPossibleSolution.toString());
		}
	}
	
	public static void populate(List<Character> listOne, List<Character> listTwo, List<Character> right, List<Character> left) {
		int x = 0;
        // initialize ArrayLists so contents can be copied
		if(!right.isEmpty()) {
	        while(x < right.size()) {
	        	listOne.add('1');
	        	x++;
	        }
		}
        x = 0;
        if(!left.isEmpty()) {
	        while(x < left.size()) {
	        	listTwo.add('1');
	        	x++;
	        }
        }
	}
	
}
