package leetcode.LeetCode;

public class SimplifyPath {

	public String simplifyPath(String path) {
        
		StringBuilder result = new StringBuilder();
		result.append('/');
		int startIndex = 0;
		int whereToStartInPath = 0;
		boolean slash = false;
		boolean end = false;
		
		while(whereToStartInPath < path.length() && 
				path.charAt(whereToStartInPath) == '/') {
			whereToStartInPath++;
			startIndex++;
		}
		
		for(int i = whereToStartInPath; i < path.length(); i++) {
			slash = path.charAt(i) == '/';
			end = i == path.length()-1;
			if(slash || end) {
				if(end && !slash) i++;
				if(startIndex == i) {
					startIndex = i+1;
					continue;
				}
				else if(path.substring(startIndex,i).equals("..")) {
					int currentResultIndex = result.length()-1;
					if(currentResultIndex != 0) {
						result.deleteCharAt(currentResultIndex); // delete last slash
						currentResultIndex--;
					}
					while(result.charAt(currentResultIndex) != '/') {
						result.deleteCharAt(currentResultIndex);
						currentResultIndex--;
					}
					startIndex = i+1;
				}
				else if(path.substring(startIndex,i).equals(".")) {
					startIndex = i+1;
					continue;
				}
				else {
					result.append(path.substring(startIndex,i));
					result.append('/');
					startIndex = i+1;
				}
			}
		}
		if(result.length() > 1 && result.charAt(result.length()-1) == '/') {
			result.deleteCharAt(result.length()-1);
		}
		return result.toString();
    }
}
