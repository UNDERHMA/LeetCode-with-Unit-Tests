package leetcode.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {

	public List<String> restoreIpAddresses(String s) {
        
		List<String> results = new ArrayList<>();
		int sLength = s.length();
		if(sLength < 4 || sLength > 12) return results; // no results possible
		
		calculate(s,0,sLength,new StringBuilder(),results,3);
		return results;
    }
	
	public void calculate(String s, int startIndex, int sLength,
			StringBuilder currentString, List<String> results, int dotsLeft) {
		
		if(currentString.length() == sLength + 4) {
			results.add(currentString.substring(0,sLength+3)); //substring to exclude end dot
			return;
			}
		if(dotsLeft == 0 && sLength-startIndex > 3) return;
		if(dotsLeft < 0) return;

		
		for(int i = startIndex; i < startIndex+3; i++) {
			if(i == sLength) return;
			if(currentString.length() >= 3 && 
					currentString.charAt(currentString.length()-2) == '.'
					&& currentString.charAt(currentString.length()-1) == '0') {
				currentString.append('.');
				calculate(s,i+1,sLength,
						new StringBuilder(currentString),results,dotsLeft-1);
				return;
			}
			else if(currentString.length() == 1 && currentString.charAt(0) == '0') {
				currentString.append('.');
				calculate(s,i+1,sLength,
						new StringBuilder(currentString),results,dotsLeft-1);
				return;
			}
			else {
				if(i == startIndex+2 && 
						Integer.parseInt(s.substring(startIndex,startIndex+3)) > 255) {
					return;
				}
				currentString.append(s.charAt(i));
				currentString.append('.');
				calculate(s,i+1,sLength,
						new StringBuilder(currentString),results,dotsLeft-1);
				currentString.deleteCharAt(currentString.length()-1); // remove dot
			}
		}
	}
	
}
