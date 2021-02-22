package leetcode.LeetCode;

import java.util.List;

public class LongestWordInDictionaryThroughDeleting {
	
	public String findLongestWord(String s, List<String> d) {
		
		int stringLength = s.length();
		int dictionaryLength = d.size();
		String result = "";
		if(stringLength == 0 || dictionaryLength == 0) return result;
		char[] current;
		char[] sAsCharArray = s.toCharArray();
		int currentLength;
		int currentIndex;
		
		for(int i = 0; i < dictionaryLength; i++) {
			current = d.get(i).toCharArray();
			currentLength = current.length;
			currentIndex = 0;
			for(int j = 0; j < stringLength; j++) {
				if(sAsCharArray[j] == current[currentIndex]) {
					currentIndex++;
					if(currentIndex == currentLength) {
						if(currentLength > result.length()) result = d.get(i);
						else if(currentLength < result.length()) break;
						else {
							result = result.compareTo(d.get(i)) < 0 ? result : d.get(i);
						}
						break;
					}
				}
			}
		}
		return result;
    }
}
