package leetcode.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion {

	 public static String convert(String s, int numRows) {
		 
		 if(s.length() == 0 || numRows == 0) {return "";}
		 if(s.length() == 1 ) {return s;}
		 
		 List<StringBuilder> builderList = new ArrayList<>();
		 
		 for (int i = 1; i <= numRows; i++) {
			 StringBuilder sb = new StringBuilder();
			 builderList.add(sb);
		 }
		 
		 boolean countUp = true;
		 int counter = 0;
		 
		 for(int j = 0; j < s.length(); j++) {
			 if(countUp) {
				 if(counter < numRows) {
					 builderList.get(counter).append(s.charAt(j));
					 counter++;						
				 }
				 else {
					 countUp = false;
					 counter = numRows-2;
				 }
			 }
			 if(!countUp) {
				 if(counter > 0) {
					 builderList.get(counter).append(s.charAt(j));
					 counter--;
				 }
				 else {
					 countUp = true;
					 counter = 0;
					 builderList.get(counter).append(s.charAt(j));
					 counter++;
				 }
			 }
		 }
		 
		 for(int i = 1; i < builderList.size(); i++) {
			 builderList.get(0).append(builderList.get(i));
		 }
		 return builderList.get(0).toString();
	 }
}
