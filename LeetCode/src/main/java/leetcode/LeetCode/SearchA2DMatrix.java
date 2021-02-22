package leetcode.LeetCode;

public class SearchA2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		
		if(matrix.length < 1 || matrix[0].length < 1) return false;
		int height = matrix.length;
		int width = matrix[0].length;
		int startY = 0;
		int endY = height-1;
		int startX = 0;
		int endX = width-1;
		int mid;
		
		if(height == 1) {
			for(int i = 0; i < width; i++) {
				if(matrix[0][i] == target) return true;
			}
			return false;
		}
		
		if(width == 1) {
			for(int i = 0; i < height; i++) {
				if(matrix[i][0] == target) return true;
			}
			return false;
		}
		
		
		while(startY+1 < endY) {
			mid = (startY + endY) >>> 1;
			if(target < matrix[mid][0]) {endY = mid-1;}
			else if(target == matrix[mid][0]) {startY = mid; endY = mid;}
			else {startY = mid;}
		}
		
		if(matrix[endY][0] > target) endY = startY;
		if(endY < 0) endY = 0;
		while(startX <= endX) {
			mid = (startX + endX) >>> 1;
			if(target > matrix[endY][mid]) {startX = mid+1;}
			else if(target == matrix[endY][mid]) return true;
			else {endX = mid-1;}
		}
		return false;        
    }
}
