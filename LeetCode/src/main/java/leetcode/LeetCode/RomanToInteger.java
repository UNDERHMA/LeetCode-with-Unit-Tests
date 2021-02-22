package leetcode.LeetCode;

public class RomanToInteger {
	public int romanToInt(String s) {
        
		char[] sAsCharArray = s.toCharArray();
		int sLength = s.length();
		char current;
		int answer = 0;
		for(int i = 0; i < sLength; i++) {
			current = sAsCharArray[i];
			switch (current) {
			case 'M' : answer += 1000;
						break;
			case 'D' : answer += 500;
						break;
			case 'C' : if(i+1 < sLength && sAsCharArray[i+1] == 'M') {
				answer += 900;
				i++;
				break;
			} else if(i+1 < sLength && sAsCharArray[i+1] == 'D') {
				answer += 400;
				i++;
				break;
			}
			else answer += 100;
						break;
			case 'L' : answer += 50;
						break;
			case 'X' : if(i+1 < sLength && sAsCharArray[i+1] == 'C') {
				answer += 90;
				i++;
				break;
			} else if(i+1 < sLength && sAsCharArray[i+1] == 'L') {
				answer += 40;
				i++;
				break;
			}
			else answer += 10;
					break;
			case 'V' : answer += 5;
					break;
			case 'I' : if(i+1 < sLength && sAsCharArray[i+1] == 'X') {
				answer += 9;
				i++;
				break;
			} else if(i+1 < sLength && sAsCharArray[i+1] == 'V') {
				answer += 4;
				i++;
				break;
			}
			else answer += 1;
					break;
			}
		}
		return answer;
    }
}
