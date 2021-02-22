package leetcode.LeetCode;

public class GuessGame {
	public static int guessNumber(int n) {
        
        double start = 0;
        double end = Integer.MAX_VALUE;
        double temp = 0.0;
        int mid = n;
        
        int currentGuessStatus = guess(mid);
        if(currentGuessStatus == 0) {
            return mid;
        }
        else if(currentGuessStatus == -1) {
            end = mid;
        }
        else {
            start = mid;
        }
        
        while(start < end) {
        	temp =  (start + end) / 2.0;
        	mid = (int) temp;
            currentGuessStatus = guess(mid);
            if(currentGuessStatus == 0) {
                return mid;
            }
            else if(currentGuessStatus == -1) {
                end = mid;
            }
            else {
                start = mid;
            }
        }
        return mid;
    }
	
	public static int guess(int n) {
		int x = 1702766719;
		if(n == x) {
			return 0;
		}
		else if(n > x) {
			return -1;
		}
		else {return 1;}
	}
}
