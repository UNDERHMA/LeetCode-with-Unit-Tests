package leetcode.LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestNiceSubstring {
	public String longestNiceSubstring(String s) {
        
		int sLength = s.length();
		int currentLength = 0;
		int maxLength = 0;
		String max = "";
		for(int i = 0; i < sLength; i++) {
			for(int j = i+1; j < sLength; j++) {
				currentLength = validNiceString(s.substring(i,j+1));
				if(currentLength > maxLength) {
					maxLength = currentLength;
					max = s.substring(i,j+1);
				}
			}
		}
		
		return max;
    }
	
	public int validNiceString(String s) {
		
		Set<Character> chars = new HashSet<>();
		int sLength = s.length();
		
		for(int i = 0; i < sLength; i++) {
			chars.add(s.charAt(i));
		}
		
		for(Character c : chars) {
			if(Character.isLowerCase(c)) {
				if(chars.contains(Character.toUpperCase(c))) continue;
				else return 0;
			} else {
				if(chars.contains(Character.toLowerCase(c))) continue;
				else return 0;
			}
		}
		return sLength;
	}
}
