package leetcode.LeetCode;

public class ImplementStrStr {

	public static int strStr(String haystack, String needle) {
        
		if(needle.isEmpty()) {
			return 0;
		}
		
		if(haystack.isEmpty()) {
			return -1;
		}
		
		int hayPointer = 0;
		int needlePointer = 0;
		
		while(hayPointer <= ((haystack.length()-1) - (needle.length()-1))) {
			int next = hayPointer+1;
			while(haystack.charAt(hayPointer) == needle.charAt(needlePointer)) {
				hayPointer++;
				needlePointer++;
				if(needlePointer == needle.length()) {
					return next-1;
				}
			}
			needlePointer = 0;
			hayPointer = next;
		}
		
		return -1;
    }
	
}
