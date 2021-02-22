package leetcode.LeetCode;

public class RotateImage {
	public static void rotate(int[][] matrix) {
		
		int layers = matrix.length-2;
		
		for(int j = 0; j <= layers; j++) {
			for(int i = 0; i < matrix.length-1-(2*j); i++) {
				int temp = matrix[j][i+j];
				matrix[j][i+j] = matrix[matrix[0].length-1 - i - j][j];
				matrix[matrix[0].length-1 - i - j][j] = matrix[matrix[0].length-1 - j][matrix.length-1 - i - j];
				matrix[matrix[0].length-1 - j][matrix[0].length-1 - i - j] = matrix[i+j][matrix.length-1 - j];
				matrix[i+j][matrix[0].length-1 -j] = temp;
			}
		}
    }
}
