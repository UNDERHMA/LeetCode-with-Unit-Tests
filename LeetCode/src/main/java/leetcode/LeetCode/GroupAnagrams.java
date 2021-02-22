package leetcode.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

	public static List<List<String>> groupAnagrams(String[] strs) {
		
		// create result holders
        List<List<String>> resultList = new ArrayList<>();
        
		//handle size = 1
		if(strs.length == 1) {
			List<String> resultSubList = new ArrayList<>();
			resultSubList.add(strs[0]);
			resultList.add(resultSubList);
			return resultList;
		}

		// convert each string to a number that is a sum of its chars and store in array
		Map<String,List<String>> strSorted = new HashMap<>();
        for(int i = 0; i < strs.length; i++) { 
        	char[] temp = strs[i].toCharArray();
        	Arrays.sort(temp);
        	String key = String.valueOf(temp);
        	List<String> listOfWords = strSorted.getOrDefault(key, new ArrayList<String>());
        	listOfWords.add(strs[i]);
        	strSorted.put(key,listOfWords);
        	}
        
        // group matching char sums together and return in list
        for(Map.Entry<String,List<String>> entry : strSorted.entrySet()) {
        	resultList.add(entry.getValue());
        }
        return resultList;        
    }
	
}
