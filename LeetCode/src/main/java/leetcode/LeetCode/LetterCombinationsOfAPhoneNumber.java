package leetcode.LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LetterCombinationsOfAPhoneNumber {

	public static List<String> letterCombinations(String digits) {
        
		List<String> letters = new ArrayList<>();
		for(int i = 0; i < digits.length(); i++) {
			if(digits.charAt(i) == '2') {
				letters.add("abc");
			}
			else if(digits.charAt(i) == '3') {
				letters.add("def");
			}
			else if(digits.charAt(i) == '4') {
				letters.add("ghi");
			}
			else if(digits.charAt(i) == '5') {
				letters.add("jkl");
			}
			else if(digits.charAt(i) == '6') {
				letters.add("mno");
			}
			else if(digits.charAt(i) == '7') {
				letters.add("pqrs");
			}
			else if(digits.charAt(i) == '8') {
				letters.add("tuv");
			}
			else if(digits.charAt(i) == '9') {
				letters.add("wxyz");
			}
		}
		if(letters.size() == 0) {
			return new ArrayList<String>();
		}
		if(letters.size() == 1) {
			char[] chars = letters.get(0).toCharArray();
			List<String> result = new ArrayList<>();
			for(char c: chars) {
				String s = Character.toString(c);
				result.add(s);
			}
			return result;
		}
		return findCombinations(letters);
    }
	
	public static List<String> findCombinations(List<String> letters) {
		
		List<List<StringBuilder>> resultStore = new ArrayList<>();
		
		for(int i = 0; i < letters.size()-1; i+=2) {
			List<StringBuilder> result = new ArrayList<>();
			for(int j = 0; j < letters.get(i).length(); j++) {
				for(int k = 0; k < letters.get(i+1).length(); k++) {
					char c = letters.get(i).charAt(j);
					char d = letters.get(i+1).charAt(k);
					StringBuilder sb1 = new StringBuilder();
					sb1.append(c);
					sb1.append(d);
					result.add(sb1);
				}
			}
			resultStore.add(result);
		}
		
		if(letters.size()%2 == 1) {
			List<StringBuilder> result = new ArrayList<>();
			for(int j = 0; j < resultStore.get(resultStore.size()-1).size(); j++) {
				for(int k = 0; k < letters.get(letters.size()-1).length(); k++) {
					char c = letters.get(letters.size()-1).charAt(k);
					StringBuilder sb1 = new StringBuilder(resultStore.get(resultStore.size()-1).get(j));
					sb1.append(c);
					result.add(sb1);
				}	
			}
			resultStore.remove(resultStore.size()-1);
			resultStore.add(result);
		} 
		return mergeGroups(resultStore);
	}
	
	public static List<String> mergeGroups(List<List<StringBuilder>> groups) {
		//base case
		if(groups.size() == 1) {
			return groups.get(0).stream().map(StringBuilder::toString)
										.collect(Collectors.toList()); 
		}
		
		List<List<StringBuilder>> resultStore = new ArrayList<>();
		for(int i = 0; i < groups.size(); i+=2) {
			List<StringBuilder> result = new ArrayList<>();
			for(int j = 0; j < groups.get(i).size(); j++) {
				for(int k = 0; k < groups.get(i+1).size(); k++) {
					StringBuilder sb1 = new StringBuilder(groups.get(i).get(j));
					StringBuilder sb2 = new StringBuilder(groups.get(i+1).get(k));
					result.add(sb1.append(sb2));
				}	
			}
			resultStore.add(result);
		}
		List<String> result = mergeGroups(resultStore);
		return result;
	}
}
