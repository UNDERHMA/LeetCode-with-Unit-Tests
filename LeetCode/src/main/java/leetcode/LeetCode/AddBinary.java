package leetcode.LeetCode;

public class AddBinary {
	public String addBinary(String a, String b) {
        
		StringBuilder result = new StringBuilder();
		int smallerIndex = Math.min(a.length()-1, b.length()-1);
		int largerIndex = Math.max(a.length()-1, b.length()-1);
		int abDifference = largerIndex - smallerIndex;
		int carry = 0;
		int toAdd = 0;
		
		// swap a and b, just so we can consistently refer to b as the larger
		if(a.length() > b.length()) {
			String temp = a;
			a = b;
			b = temp;
		}
		
		while(smallerIndex >= 0) {
			if(a.charAt(smallerIndex) == '0' && b.charAt(smallerIndex+abDifference) == '0') {
				toAdd = 0 + carry;
				result.append(toAdd);
				carry = 0;
			}
			else if(a.charAt(smallerIndex) == '1' && b.charAt(smallerIndex+abDifference) == '1') {
				toAdd = 0 + carry;
				result.append(toAdd);
				carry = 1;
			}
			else {
				toAdd = 1 + carry;
				if(toAdd == 2) {
					result.append("0");
					carry = 1;
				}
				else {
					result.append("1");
					carry = 0;
				}
				
			}
			smallerIndex--;
		}
		
		if(abDifference == 0) {
			if(carry > 0) result.append("1");
		}
		else {
			while(abDifference > 0) {
				toAdd = Character.getNumericValue(b.charAt(abDifference-1)) + carry;
				if(toAdd == 0) {
					result.append("0");
					carry = 0;
				}
				else if (toAdd == 1) {
					result.append("1");
					carry = 0;
				}
				else {
					result.append("0");
					carry = 1;
				}
				abDifference--;
			}
			if(carry > 0) result.append("1");
		}
		return result.reverse().toString();
    }
}
