package leetcode.LeetCode;

public class MinimumWindowSubstring {
	
		public String minWindow(String s, String t) {
			
			if(t.length() > s.length() || s.length() == 0 ||
					t.length() == 0) return "";
			
			char[] sAsArray = s.toCharArray();
			int[] charsToUse = new int[256];
			for(char c : t.toCharArray()) {
				charsToUse[c]++;
			}
			
			int start = 0;
			int charsLeftToUse = t.length();
			int length = s.length();
			int min = Integer.MAX_VALUE;
			String minLengthString = "";
			
			for(int end = 0; end < length; end++) {
				
				if(charsToUse[sAsArray[end]] > 0) {
					charsLeftToUse--;
				}
				charsToUse[sAsArray[end]]--;
				
				while(charsLeftToUse == 0) {
					if(end-start < min) {
						min = end-start;
						minLengthString = s.substring(start,end+1);
					}
					charsToUse[sAsArray[start]]++;					
					if(charsToUse[sAsArray[start]] > 0) {
						charsLeftToUse++;
					}
					start++;
				}
			}
			return minLengthString;
		}
}
