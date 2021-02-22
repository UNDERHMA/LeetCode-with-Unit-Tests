package leetcode.LeetCode;

public class UniquePaths {

	public int uniquePaths(int m, int n) {
		int y = 0;
		int x = 0;
		int[][] memo = new int[m][n];
		return uniquePaths(y,x,memo);
    }
	
	public int uniquePaths(int y, int x, int[][] memo) {
		if(memo[y][x] != 0) return memo[y][x];
		int paths = 0;
		if(y == memo.length-1 && x == memo[0].length-1) return 1;
		if(y+1 <= memo.length-1) paths += uniquePaths(y+1,x,memo);
		if(x+1 <= memo[0].length-1) paths += uniquePaths(y,x+1,memo);
		memo[y][x] = paths;
		return memo[y][x];
    }
}
