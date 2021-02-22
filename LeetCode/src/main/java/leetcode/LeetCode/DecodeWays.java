package leetcode.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class DecodeWays {
	
	public int numDecodings(String s) {
		// checking for invalid inputs (0 in wrong place)
		if(s.length() == 0) return 0;
        if(s.charAt(0) == '0') return 0;
        if(s.length() == 1) return 1;
        Map<String,Integer> memo = new HashMap<>();
		
		return calculateWays(s,memo);
    }
	
	public int calculateWays(String s, Map<String,Integer> memo) {
		
		if(memo.containsKey(s))  return memo.get(s);
		if(s.length() == 0) return 1; // base case
		int firstChar = Character.getNumericValue(s.charAt(0));
		if(s.length() == 1) {
			if(firstChar != 0) return 1; // base case
			else return 0;
		}
		
		int secondChar = Character.getNumericValue(s.charAt(1));
		int memoResult = 0;
		
		if(secondChar == 0 && firstChar > 2) return 0; // no possible solutions
		else if(firstChar == 0) return 0; // no possible solutions
		else if(secondChar == 0) memoResult += calculateWays(s.substring(2),memo);
		else if(firstChar > 2) memoResult += calculateWays(s.substring(1),memo);
		else if(s.length() > 2 && s.charAt(2) == '0') memoResult += calculateWays(s.substring(1),memo);
		else if(firstChar > 2) memoResult += calculateWays(s.substring(1),memo);
		else if(firstChar == 2 && secondChar > 6) memoResult += calculateWays(s.substring(1),memo);
		else memoResult += calculateWays(s.substring(1),memo) 
				+ calculateWays(s.substring(2),memo);
		
		memo.put(s,memoResult);
		return memoResult;
	}
	
}
