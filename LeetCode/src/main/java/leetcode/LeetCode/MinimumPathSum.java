package leetcode.LeetCode;

public class MinimumPathSum {
	public int minPathSum(int[][] grid) {
		
		if(grid.length == 0 || grid[0].length == 0) return 0;
		int[][] tabulationGrid = new int[grid.length][grid[0].length];
		int currentValue = 0;
		tabulationGrid[0][0] = grid[0][0];
		
		for(int j = 1; j < grid[0].length; j++) {
			tabulationGrid[0][j] = grid[0][j] + tabulationGrid[0][j-1];
		}

		for(int i = 1; i < grid.length; i++) {
			tabulationGrid[i][0] = grid[i][0] + tabulationGrid[i-1][0];
		}
		
		for(int i = 1; i < grid.length; i++) {
			for(int j = 1; j < grid[0].length; j++) {
				tabulationGrid[i][j] = grid[i][j] +
						Math.min(tabulationGrid[i][j-1],tabulationGrid[i-1][j]);
				}
		}
		return tabulationGrid[grid.length-1][grid[0].length-1];
    }
}
