package leetcode.LeetCode;

public class MergeStringsAlternately {

	public String mergeAlternately(String word1, String word2) {
        
		int word1Length = word1.length();
		int word2Length = word2.length();
		
		StringBuilder result = new StringBuilder();
		
		int i = 0;
		while(i < word1Length && i < word2Length) {
			result.append(word1.charAt(i));
			result.append(word2.charAt(i));
            i++;
		}
		
		if(word1Length < word2Length) result.append(word2.substring(i,word2Length));
		else if(word1Length > word2Length) result.append(word1.substring(i,word1Length));
		return result.toString();
    }
	
}
