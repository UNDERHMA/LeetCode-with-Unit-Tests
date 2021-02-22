package leetcode.LeetCode;

public class DivideTwoIntegers {

	public int divide(int dividend, int divisor) {
		
		// add values when dividend and divisor differ in sign
		boolean oppositeSigns = (dividend < 0 && divisor > 0 
				|| dividend > 0 && divisor < 0);
		
		// base cases for 0 and 1
		if(divisor == 0 || dividend == 0) return 0;
		if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
		if(divisor == -1) return 0-dividend;
		if(divisor == 1) return dividend;
		if(divisor == Integer.MIN_VALUE) {
			if (dividend != Integer.MIN_VALUE) return 0;
			else return 1;
		}
	
		// variables for quotient calculation
		int currentDividend = (dividend == Integer.MIN_VALUE) ? dividend+1 : dividend;
		int absDividend = Math.abs(currentDividend);
		int absDivisorRaisedToExponent =  Math.abs(divisor);
		int originalAbsDivisor = absDivisorRaisedToExponent;
		if(absDividend == absDivisorRaisedToExponent) {
			if(oppositeSigns) {return -1;} else {return 1;}
		}
		if(absDividend < originalAbsDivisor) return 0;

		// more variables for quotient calculation
		int maxDivisorValue = (int) Math.sqrt(Integer.MAX_VALUE);
		int exponent = 1;
		int divisorSum = 0;
		int result = 0;
		
		/* quotient calculation, find closest divisor raised to exponent less 
			than dividend. The idea is best seen in 27 / 3. Since 3^3 = 27, we know
			that 3^(3-1) would be the quotient. We can use this on larger numbers.
			Example: 100 / 9
		 	9^2 = 81 -> add 9^1 to the result.
		 	remaining quotient = 100 - 81 = 19
		 	9^1 = 9 -> add 9^0 to the result
		 	19-9 = 10. 
		 	9^1 = 9 -> add 9^0 to the result
		 	10-9 = 1
		 	Once we are trying divisor ^ 0 (in this case 9^0, we stop)
		 	so result is 9+1+1 = 11. So 100/9 = 11.
	 	*/
		while(absDividend >= absDivisorRaisedToExponent) {
			if(absDivisorRaisedToExponent < maxDivisorValue) {
				exponent++;
				absDivisorRaisedToExponent = (int) Math.pow(originalAbsDivisor, exponent);
			}
			else {exponent++; break;}
		}
		divisorSum += Math.pow(originalAbsDivisor, --exponent);
		/* quotient calculation, keep subtracting closest divisor raised to exponent
		 *  until closest divisor raised to exponent is greater than dividend */
		while(absDividend > divisorSum) {
			absDividend -= divisorSum;
			result += Math.pow(originalAbsDivisor, exponent-1);
			/* diminish closest square once it is > dividend, diminishing to next
			smallest order of magnitude (exponent--) */
			if(absDividend < divisorSum) {
				while(absDividend  < divisorSum && exponent > 0) {
					divisorSum = (int) Math.pow(originalAbsDivisor, --exponent);
				}
			}
		}
		
		// if dividend = Integer.MIN_VALUE, add 1 to absDividend and try dividing by originalAbsDivisor
		if(Integer.MIN_VALUE == dividend && (absDividend+1) == originalAbsDivisor) result++;
		// return result 
		if(oppositeSigns) return 0 - result;
		else return result;
    }
}
