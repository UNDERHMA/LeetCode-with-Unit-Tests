package leetcode.LeetCode;

public class LengthOfLastWord {
	
	public int lengthOfLastWord(String s) {
		int counter = 0;
		for(int i = s.length()-1; i >= 0; i--) {
			if(s.charAt(i) == ' ' && counter == 0) continue;
			else if(s.charAt(i) == ' ') return counter;
			else counter++;
		}
		return counter;
    }

}
