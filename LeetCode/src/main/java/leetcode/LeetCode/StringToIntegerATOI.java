package leetcode.LeetCode;

public class StringToIntegerATOI {

	public int myAtoi(String s) {
		
		int start = -1;
		int end = -1;
		int signMultiplier = 1; // determines if number is negative or positive
		char currentChar;
		boolean plusOrMinusUsed = false;
		for(int i = 0; i < s.length(); i++) {
			currentChar = s.charAt(i);
			if(start == -1) {
				if(plusOrMinusUsed && 
						(!Character.isDigit(currentChar))) return 0;
				if(!Character.isDigit(currentChar) && !(currentChar == '-') &&
						!(currentChar == '+') && !(currentChar == ' ')) {
					return 0;
				}
				if(Character.isDigit(currentChar)) {start = i; end = start+1;}
				if(currentChar == '-') {signMultiplier = -1; plusOrMinusUsed = true;}
				if(currentChar == '+') plusOrMinusUsed = true;
				continue;
			}
			if(start != -1) {
				if(Character.isDigit(currentChar)) end = i+1;
				else break;
			}
		}
		// Trim leading 0s
		while(start != -1 && start != end 
	              && s.charAt(start) == '0') {
			start++;
		}
		// Determine if result has too many digit
		if(end-start > 10) {
			if(signMultiplier == 1) return 2147483647;
			if(signMultiplier == -1) return -2147483648;
		}
		if(end-start == 10) {
			String max;
			String number = s.substring(start,end);
			if(signMultiplier == 1) {
				max = "2147483647";
				for(int j = 0; j < number.length(); j++) {
					if(number.charAt(j) < max.charAt(j)) break; // number is valid
					if(number.charAt(j) > max.charAt(j)) return 2147483647;
				}
			}
			if(signMultiplier == -1) {
				max = "2147483648";
				for(int j = 0; j < number.length(); j++) {
					if(number.charAt(j) < max.charAt(j)) break; // number is valid
					if(number.charAt(j) > max.charAt(j)) return -2147483648;
				}
				// deal with 2147483648, a number we cannot perform parseInt on
				if(s.substring(start,end).equals("2147483648")) return -2147483648;
			}
		}
		
		if(start == -1 || start == end) return 0; 
		return signMultiplier * Integer.parseInt(s.substring(start,end));
    }
	
}
