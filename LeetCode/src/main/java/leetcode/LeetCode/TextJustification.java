package leetcode.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {


	public List<String> fullJustify(String[] words, int maxWidth) {
		
		List<String> result = new ArrayList<>();
		int lastWord = words.length;
		StringBuilder sb = new StringBuilder();
		int currentLength;
		
		for(int i = 0; i < lastWord; i++) {
			currentLength = words[i].length();
			if(sb.length() + currentLength > maxWidth) {
				// remove any whitespace from the end
				while(sb.charAt(sb.length()-1) == ' ') {
					sb.deleteCharAt(sb.length()-1);
				}
				while(sb.length() < maxWidth) {
					int spaceCount = 0;
					for(int j = 0; j < sb.length(); j++) {
						if(sb.length() == maxWidth) break;
						if(sb.charAt(j) == ' ') {
							spaceCount++;
							sb.insert(j, ' ');
							while(j < sb.length() && sb.charAt(j) == ' ') {
								j++;
							}
						}
						if(spaceCount == 0 && j == sb.length()-1) {
							while(maxWidth-sb.length() > 0) {
								sb.append(' ');
							}
						}
					}
				}
				result.add(sb.toString());
				sb = new StringBuilder();
			}
			sb.append(words[i]);
			if(sb.length() < maxWidth) sb.append(" ");
		}
		
		if(sb.length() > 0) {
			int spacesToAdd = maxWidth - sb.length();
			while(spacesToAdd > 0) {
				sb.append(' ');
				spacesToAdd--;
			}
			result.add(sb.toString());
		}
        return result;
    }
	
}
