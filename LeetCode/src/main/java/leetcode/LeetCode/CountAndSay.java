package leetcode.LeetCode;

public class CountAndSay {
	public String countAndSay(int n) {
		
		if(n == 1) return "1";
	
		String current = countAndSay(n-1);
		int numCount;
		char currentDigit;
		StringBuilder resultString = new StringBuilder();
		for(int i = 0; i < current.length(); i++) {
			currentDigit = current.charAt(i);
			numCount = 1;
			i++;
			while(i < current.length() && current.charAt(i) == currentDigit) {
				numCount++;
				i++;
			}
			resultString.append(numCount);
			resultString.append(currentDigit);
			i--; // decrement i so that we check next unique number after currentDigit next
		}
        return resultString.toString();
    }
}
