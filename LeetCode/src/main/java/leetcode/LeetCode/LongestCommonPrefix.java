package leetcode.LeetCode;

public class LongestCommonPrefix {

	public static String longestCommonPrefix(String[] strs) {
		
		if(strs.length == 0) {
            return "";
        }

		char[] shortest = strs[0].toCharArray();
		if(shortest.length == 0) {
    		return "";
    	}
		
        for(int i = 1; i < strs.length; i++) {
        	char[] currentString = strs[i].toCharArray();
        	if(currentString.length == 0) {
        		return "";
        	}
        	else if (currentString.length > shortest.length)
	        	for(int j = 0; j < shortest.length; j++) {
	        		if(shortest[j] != currentString[j]) {
	        			if(j==0) {
	        				return "";
	        			}
	        			else {
		        			StringBuilder sb = new StringBuilder(String.valueOf(shortest));
		        			shortest = sb.substring(0, j).toCharArray();
		        			break;
	        			}
	        		}
	        	}
        	else {
        		for(int j = 0; j < currentString.length; j++) {
	        		if(shortest[j] != currentString[j]) {
	        			if(j==0) {
	        				return "";
	        			}
	        			else {
	        			StringBuilder sb = new StringBuilder(strs[i]);
	        			shortest = sb.substring(0, j).toCharArray();
	        			break;
	        			}
	        		}
	        		else if(j == currentString.length-1) {
	        			StringBuilder sb = new StringBuilder(strs[i]);
	        			shortest = sb.substring(0, j+1).toCharArray();
	        		}
	        	}
        	}
        }
        return String.valueOf(shortest);
    }
}
