package leetcode.LeetCode;

public class MultiplyStrings {

public static String multiply(String num1, String num2) {
		
		if(num1.equals("0") || num2.equals("0")) {
			return "0";
		}
		else if (num1.equals("1")) {
			return num2;
		}
		else if (num2.equals("1")) {
			return num1;
		}
		
		int[] num1Array = new int[num1.length()]; 
		int[] num2Array = new int[num2.length()]; 
		int[] resultArray = new int[num1Array.length + num2Array.length];
		
		for(int i = 0; i < num1.length(); i++) {
			num1Array[i] = Character.getNumericValue(num1.charAt(i));
		}
		for(int i = 0; i < num2.length(); i++) {
			num2Array[i] = Character.getNumericValue(num2.charAt(i));
		}
		
		int resultInt = 0;
		int zeros = 0;
		int int1 = 0;
		int int2 = 0;
		int offset = resultArray.length-1;
		
		for (int i = num2Array.length-1; i >= 0; i--) {
			for (int j = num1Array.length-1; j >= 0; j--) {
				int1 = num1Array[j];
				int2 =  num2Array[i];
				resultInt = int1*int2;
				zeros = (num1Array.length-1 - j) + (num2Array.length-1 - i);
				resultArray[offset-zeros] += resultInt % 10;
				if(offset-zeros != 0) {
					resultArray[offset-zeros-1] += resultInt / 10;
				}
			}
		}
		
		// carry elements that are 10 or more
		for(int i = resultArray.length-1; i > 0; i--) {
			if(resultArray[i] > 9) {
				resultArray[i-1] += resultArray[i] / 10;
				resultArray[i] = resultArray[i] % 10;
			}
		}
		
		// retrieve results from int[] and reformat to String with StringBuilder
		boolean front = false;
		StringBuilder resultBuilder = new StringBuilder();
		for(int i = 0; i < resultArray.length; i++) {
			if(resultArray[i] != 0) {
				front = true;
			}
			if(front) {
				resultBuilder.append(String.valueOf(resultArray[i]));
			}
		}
		return resultBuilder.toString();
	}
}
