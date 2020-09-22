package leetcode.LeetCode;

import java.util.Stack;

public class ValidParentheses {

	public static boolean isValid(String s) {
        
		Stack<Character> bracketStack = new Stack<>();
		
		char[] charArray = s.toCharArray();
		
		for(int i = 0; i < charArray.length; i++) {
			if(charArray[i] == '(' || charArray[i] == '{' || charArray[i] == '[') {
				bracketStack.add(charArray[i]);
			}
			else if(charArray[i] == ')') {
				if(bracketStack.isEmpty()) {
					return false;
				}
				else if(bracketStack.pop() != '(') {
					return false;
				}
			}
			else if(charArray[i] == '}') {
				if(bracketStack.isEmpty()) {
					return false;
				}
				else if(bracketStack.pop() != '{') {
					return false;
				}
			}
			else if(charArray[i] == ']') {
				if(bracketStack.isEmpty()) {
					return false;
				}
				else if(bracketStack.pop() != '[') {
					return false;
				}
			}
		}
		
		if(bracketStack.isEmpty()) {
			return true;
		}
		return false;
    }
}
