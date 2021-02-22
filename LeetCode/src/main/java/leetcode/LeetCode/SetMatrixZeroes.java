package leetcode.LeetCode;

import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeroes {
	public void setZeroes(int[][] matrix) {
		
		int height = matrix.length;
		int width = matrix[0].length;
		Set<Integer> zeroRows = new HashSet<>();
		Set<Integer> zeroColumns = new HashSet<>();
		
		for(int y = 0 ; y < height ; y++) {
			for(int x = 0; x < width ; x++) {
				if(matrix[y][x] == 0) {
					zeroColumns.add(x);
					zeroRows.add(y);
				}
			}
		}
		for(Integer i : zeroColumns) {
			int x = i;
			for(int j = 0 ; j < height ; j++) {
				matrix[j][x] = 0;
			}
		}
		for(Integer i : zeroRows) {
			int y = i;
			for(int j = 0 ; j < width ; j++) {
				matrix[y][j] = 0;
			}
		}
    }
}
