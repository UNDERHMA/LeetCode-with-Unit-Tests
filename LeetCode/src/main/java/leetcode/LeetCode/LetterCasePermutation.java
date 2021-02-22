package leetcode.LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LetterCasePermutation {

	public List<String> letterCasePermutation(String S) {
        
		Set<String> duplicates = new HashSet<>();
		List<String> resultList = new ArrayList<>();
		int sLength = S.length();
		if(sLength == 0) return resultList;
		resultList.add(S);
		
		for(int i = 0; i < sLength; i++) {
			char[] sAsArray = S.toCharArray();
			char currentChar = sAsArray[i];
			if(Character.isLetter(currentChar)) {
				letterCasePermutation(sAsArray,i,sLength,resultList,duplicates);
			}
		}
		Collections.sort(resultList);
		Collections.reverse(resultList);
		return resultList;
    }
	
	public void letterCasePermutation(char[] sAsArray, int startIndex,
			int sLength, List<String> resultList, Set duplicates) {
		
		if(sLength == startIndex) return;
		char currentChar = sAsArray[startIndex];
		
		while(!Character.isLetter(currentChar) && startIndex + 1 < sLength) {
			currentChar = sAsArray[++startIndex];
		}
		
		if(Character.isLetter(currentChar)) {
			letterCasePermutation(sAsArray,startIndex+1,sLength,resultList,duplicates);
			if(Character.isUpperCase(currentChar)) {
				sAsArray[startIndex] = Character.toLowerCase(currentChar);
			} else sAsArray[startIndex] = Character.toUpperCase(currentChar);
			if(!duplicates.contains(String.valueOf(sAsArray))) {
				resultList.add(String.valueOf(sAsArray));
				duplicates.add(String.valueOf(sAsArray));
			}
			letterCasePermutation(sAsArray,startIndex+1,sLength,resultList,duplicates);
		}
	}
	
}
