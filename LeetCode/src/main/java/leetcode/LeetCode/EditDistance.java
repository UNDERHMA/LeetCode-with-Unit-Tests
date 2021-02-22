package leetcode.LeetCode;

public class EditDistance {
	public int minDistance(String word1, String word2) {
		
		int length1 = word1.length();
		int length2 = word2.length();
		
		int [][] dpGrid = new int[length1+1][length2+1];
		
		for(int x = 0; x < length2+1; x++) {
			dpGrid[0][x] = x;
		}
		for(int y = 0; y < length1+1; y++) {
			dpGrid[y][0] = y;
		}
        
		for(int x = 1; x < length2+1; x++) {
			for(int y = 1; y < length1+1; y++) {
				if(word2.charAt(x-1) == word1.charAt(y-1)) dpGrid[y][x] = dpGrid[y-1][x-1];
				else dpGrid[y][x] = 1 +Math.min(
						Math.min(dpGrid[y][x-1],dpGrid[y-1][x]),
						dpGrid[y-1][x-1]);
			}
		}
		return dpGrid[length1][length2];
    }
}
