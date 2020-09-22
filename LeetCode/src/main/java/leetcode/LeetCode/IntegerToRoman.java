package leetcode.LeetCode;

public class IntegerToRoman {
	
	public static String intToRoman(int num) {
		
		if(num == 0) {return "";}
		StringBuilder result = new StringBuilder();
		int cycles;
		
		if(num >= 1000) {
			cycles = num/1000;
			num = num % ((num/1000)*1000);
			while(cycles > 0) {
				result.append("M");
				cycles--;
			}
		}
		if(num >= 900) {
			num = num % 900;
			result.append("CM");
		}
		if(num >= 500) {
			num = num % 500;
			result.append("D");
		}
		if(num >= 400) {
			num = num % 400;
			result.append("CD");
		}
		if(num >= 100) {
			cycles = num/100;
			num = num % 100;
			while(cycles > 0) {
				result.append("C");
				cycles--;
			}
		}
		if(num >= 90) {
			num = num % 90;
			result.append("XC");
		}
		if(num >= 50) {
			num = num % 50;
			result.append("L");
		}
		if(num >= 40) {
			num = num % 40;
			result.append("XL");
		}
		if(num >= 10) {
			cycles = num/10;
			num = num % 10;
			while(cycles > 0) {
				result.append("X");
				cycles--;
			}
		}
		if(num >= 9) {
			num = num % 9;
			result.append("IX");
		}
		if(num >= 5) {
			num = num % 5;
			result.append("V");
		}
		if(num >= 4) {
			num = num % 4;
			result.append("IV");
		}
		if(num > 0) {
			cycles = num;
			while(cycles > 0) {
				result.append("I");
				cycles--;
			}
		}
		return result.toString();
    }
}
