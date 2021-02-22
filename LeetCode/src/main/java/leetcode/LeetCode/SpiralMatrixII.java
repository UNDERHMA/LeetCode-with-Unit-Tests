package leetcode.LeetCode;

public class SpiralMatrixII {
	public int[][] generateMatrix(int n) {
		
		if(n <= 0 || n > 20) return new int[][] {{}};
		int[][] result = new int[n][n];
		if(n == 1) return new int[][] {{1}};
		int y = 0;
		int x = -1;
		int xLengthCurrent = result[0].length-1;
		int yLengthCurrent = result.length-1;
		int orderNumber = 1;
		
		while(xLengthCurrent > 0) {
			while(x < xLengthCurrent) {
				x++;
				result[y][x] = orderNumber++;
			}
			
			while(y < yLengthCurrent) {
				y++;
				result[y][x] = orderNumber++;
			}
			
			while(x >= result[0].length - xLengthCurrent) {
				x--;
				result[y][x] = orderNumber++;
			}
			
			while(y > result.length - yLengthCurrent) {
				y--;
				result[y][x] = orderNumber++;
			}

			xLengthCurrent -= 1;
			yLengthCurrent -= 1;
		}
		return result;
    }
}
