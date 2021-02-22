package leetcode.LeetCode;

public class WordSearch {
	public boolean exist(char[][] board, String word) {
        
		char[] wordArray = word.toCharArray();
		boolean[][] used = new boolean[board.length][board[0].length];
		int wordLength = wordArray.length;
		int charCount = 0;
		
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				if(board[i][j] == wordArray[0]) {
					charCount++;				
					used[i][j] = true;
					if(DFSSearch(i,j,board,used,charCount,wordLength,wordArray)) {
						return true;
					}
					charCount = 0;
					used[i][j] = false;
				}
			}
		}
		return false;
    }
	
	public boolean DFSSearch(int y, int x, char[][] board, boolean[][] used, 
			int charCount, int wordLength, char[] wordArray) {
		
		if(charCount == wordLength) return true;
		
		if(x-1 > -1 && used[y][x-1] == false) {
			if(board[y][x-1] == wordArray[charCount]) {
				used[y][x-1] = true;
				charCount++;
				if(DFSSearch(y,x-1,board,used,charCount,wordLength,wordArray)) return true;
				charCount--;
				used[y][x-1] = false;
			}
		}
		if(y-1 > -1 && used[y-1][x] == false) {
			if(board[y-1][x] == wordArray[charCount]) {
				used[y-1][x]  = true;
				charCount++;
				if(DFSSearch(y-1,x,board,used,charCount,wordLength,wordArray)) return true;
				charCount--;
				used[y-1][x] = false;
			}
		}
		if(x+1 < board[0].length && used[y][x+1] == false) {
			if(board[y][x+1] == wordArray[charCount]) {
				used[y][x+1] = true;
				charCount++;
				if(DFSSearch(y,x+1,board,used,charCount,wordLength,wordArray)) return true;
				charCount--;
				used[y][x+1] = false;
			}
		}
		if(y+1 < board.length && used[y+1][x] == false)  {
			if(board[y+1][x] == wordArray[charCount]) {
				used[y+1][x] = true;
				charCount++;
				if(DFSSearch(y+1,x,board,used,charCount,wordLength,wordArray)) return true;
				charCount--;
				used[y+1][x] = false;
			}
		}
		return false;
	}
}
