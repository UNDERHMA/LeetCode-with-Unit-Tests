package leetcode.LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SpiralMatrix {

	public List<Integer> spiralOrder(int[][] matrix) {
        
		List<Integer> result = new ArrayList<>();
		Set<String> usedPositions = new HashSet<>();
		int width = matrix[0].length;
		int height = matrix.length;
		int originalWidth = width;
		int originalHeight = height;
		int x = 0;
		int y = 0;
		
		while(height > 0 && width > 0) {
			if(usedPositions.contains(String.valueOf(x) + "," + String.valueOf(y))){
				return result;
			}
			while(x < width) {
				result.add(matrix[y][x]);
				usedPositions.add(String.valueOf(x) + "," + String.valueOf(y));
				x++;
			}
			x--;
			y++;
			if(usedPositions.contains(String.valueOf(x) + "," + String.valueOf(y))){
				return result;
			}
			while(y < height) {
				result.add(matrix[y][x]);
				usedPositions.add(String.valueOf(x) + "," + String.valueOf(y));
				y++;
			}
			y--;
			x--;
			if(usedPositions.contains(String.valueOf(x) + "," + String.valueOf(y))){
				return result;
			}
			while(x >= originalWidth - width) {
				result.add(matrix[y][x]);
				usedPositions.add(String.valueOf(x) + "," + String.valueOf(y));
				x--;
			}
			x++;
			y--;
			if(usedPositions.contains(String.valueOf(x) + "," + String.valueOf(y))){
				return result;
			}
			while(y > originalHeight - height) {
				result.add(matrix[y][x]);
				usedPositions.add(String.valueOf(x) + "," + String.valueOf(y));
				y--;
			}
			y++;
			x++;
			width--;
			height--;
		}
		return result;
		}
 }
