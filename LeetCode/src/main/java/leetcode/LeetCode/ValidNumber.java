package leetcode.LeetCode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidNumber {

	public boolean isNumber(String s) {
        
		boolean allDigits = true;
		boolean hasDigits = false;
		int dotCount = 0;
		int eCount = 0;
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(i == 0 && (c == '-' || c == '+')) continue;
			if((c == '-' || c == '+') &&
					!(s.charAt(i-1) == 'e' || s.charAt(i-1) == 'E')) return false;
			if(!Character.isDigit(c)) allDigits = false;
			if(Character.isDigit(c)) hasDigits = true;
			if(c == '.') dotCount++;
			if(c == 'e' || c == 'E') eCount++;
			if(eCount > 0 && c == '.') return false;
			if(Character.isLetter(c) && hasDigits == false) return false;
		}
		if(hasDigits == false || dotCount > 1 || eCount > 1) return false;
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(Character.isLetter(s.charAt(i)) && !(c == 'e' || c == 'E')) return false;
		}
		
		
		Pattern p1 = Pattern.compile("[+,-]?[0-9]*[.]{1}[0-9]*");
		Pattern p2 = Pattern.compile("[e,E]+");
		Pattern p3 = Pattern.compile("[+,-]?[0-9]*.?[0-9]*[e,E]{1}[-,+]*[0-9]+");
		Pattern p4 = Pattern.compile("[+,-]?[0-9]*.?[0-9]+[e,E]{1}[-,+]*[0-9]+[.]+[0-9]+");
		Matcher m1 = p1.matcher(s);
		Matcher m2 = p2.matcher(s);
		Matcher m3 = p3.matcher(s);
		Matcher m4 = p4.matcher(s);
		boolean match1 = m1.find();
		boolean match2 = m2.find();
		boolean match3 = m3.find();
		boolean match4 = m4.find();
		
		return  (match1 && !match2) || (match3 && !match4) || allDigits;
    }
}
