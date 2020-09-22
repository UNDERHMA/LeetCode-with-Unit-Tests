package leetcode.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LongestSubstringWithoutRepeatingCharacters {

	public static int lengthOfLongestSubstring(String s) {
        
		List<Character> lettersUsed = new ArrayList<Character>();
		
		if(s.length() == 1) {
			return 1;
		}
		
		int longestRun = 0;
		int currentRun = 0;
		
		for(int i = 0; i < s.length()-1; i++) {
			if(currentRun != 0) {
				if(currentRun > longestRun) {
					longestRun = currentRun;
				}
				currentRun = 0;
				lettersUsed.clear();
				currentRun++;
				lettersUsed.add(s.charAt(i));
			}
			else {
				currentRun++;
				lettersUsed.add(s.charAt(i));
			}
			for(int j = i+1; j < s.length(); j++) {
				if(lettersUsed.contains(s.charAt(j))) {
					if(currentRun > longestRun) {
						longestRun = currentRun;
					}
					currentRun = 0;
					lettersUsed.clear();
					i = j-1;
					break;
				}
				currentRun++;
				lettersUsed.add(s.charAt(j));
			}
		}
		
		if(currentRun > longestRun) {
			longestRun = currentRun;
		}	
		return longestRun;
	}
}
