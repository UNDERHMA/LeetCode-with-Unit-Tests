package leetcode.LeetCode;

public class LongestPalindromicSubstring {

	public static String longestPalindrome(String s) {
		
		if(s == null) {return null;}
		if(s.isEmpty()) {return "";}
		if(s.length() == 1) {return s;}
		
		String longestPalindrome = "";
		
		for(int i = 0; i < s.length()-1; i++) {
			int firstChar = i;
			int lastChar = s.length()-1;
			int tempFirstChar = firstChar;
			int tempLastChar = lastChar;
			while(firstChar <= lastChar) {
				if(s.charAt(firstChar) == s.charAt(lastChar)) {
					if(firstChar == lastChar || firstChar == lastChar-1) {
						if(s.substring(tempFirstChar, tempLastChar+1).length() > 
						longestPalindrome.length()) {
							longestPalindrome = s.substring(tempFirstChar, tempLastChar+1);
						}
						break;
					}
					firstChar++;
					lastChar--;
				}
				else {
					firstChar = tempFirstChar;
					tempLastChar--;
					lastChar = tempLastChar;
				}
			}
		}
        return longestPalindrome;
    }

}
