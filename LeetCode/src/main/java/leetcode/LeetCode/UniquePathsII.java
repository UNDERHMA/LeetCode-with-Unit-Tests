package leetcode.LeetCode;

public class UniquePathsII {
	
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if(obstacleGrid.length <= 0 || obstacleGrid[0].length <= 0) return 0;
		if(obstacleGrid[0][0] == 1 || 
				obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1] == 1) {
			return 0;
		}
        int y = 0;
        int x = 0;
        int[][] memo = new int[obstacleGrid.length][obstacleGrid[0].length];
        return uniquePathsWithObstacles(obstacleGrid,y,x,memo);
    }
	
	public int uniquePathsWithObstacles(int[][] obstacleGrid, int y, int x,
			int[][] memo) {
		if(memo[y][x] != 0) return memo[y][x];
        if(y == obstacleGrid.length-1 && x == obstacleGrid[0].length-1) return 1;
        int paths = 0;
        if(y < obstacleGrid.length-1 && obstacleGrid[y+1][x] != 1) {
        	paths += uniquePathsWithObstacles(obstacleGrid,y+1,x,memo);
        }
        if(x < obstacleGrid[0].length-1 && obstacleGrid[y][x+1] != 1) {
        	paths += uniquePathsWithObstacles(obstacleGrid,y,x+1,memo);
        }
        memo[y][x] += paths;
        return memo[y][x];
    }

}
