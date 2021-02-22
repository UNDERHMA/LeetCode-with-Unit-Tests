package leetcode.LeetCode;

public class SudokuSolver {

	public void solveSudoku(char[][] board) {
		
		int squaresToSolve = 0;
		int boardWidth = board[0].length;
		int boardLength = board.length;
		for(int i = 0; i < boardLength; i++) {
			for(int j = 0; j < boardWidth; j++) {
				if(board[i][j] == '.') squaresToSolve++;
			}
		}
		solveSudoku(board,squaresToSolve,0,0,0,boardLength,boardWidth);
		for(int i = 0; i < boardLength; i++) {
			for(int j = 0; j < boardWidth; j++) {
				System.out.print(board[i][j] + ",");
			}
			System.out.println();
		}
    }
	
	public boolean solveSudoku(char[][] board, int squaresToSolve, int solved, int y, int x,
			int boardLength, int boardWidth) {
		
		if(solved == squaresToSolve) {
			return true;
		}
		
		for(int i = y; i < boardLength; i++) {
			for(int j = x < 9 && y == i ? x : 0; j < boardWidth; j++) {
				if(board[i][j] == '.') {
					for(int k = 1; k <= boardLength; k++) {
						if(potentialSolution(Character.forDigit(k,10),i,j,board)) {
							board[i][j] = Character.forDigit(k,10);
							boolean validSolution = solveSudoku(board,squaresToSolve,solved+1,i,j+1,
									boardLength,boardWidth);
							if(validSolution) return true;
							else board[i][j] = '.';
						}
					}
					if(board[i][j] == '.') return false;
				}
			}
		}
		return false;
	}
	
	public boolean potentialSolution(char number, int y, int x, char[][] board) {
		
		if(rowContains(number,y,board) || columnContains(number,x,board) 
				|| threeByThreeGridContains(number,y,x,board)) {
			return false;
		}
		return true;	
	}
	
	
	
	public boolean rowContains(char number, int rowNumber, char[][] board) {	
		for(int i = 0; i < board[rowNumber].length; i++) {
			if(board[rowNumber][i] == number) return true;
		}
		return false;
	}
	
	public boolean columnContains(char number, int columnNumber, char[][] board) {	
		for(int i = 0; i < board.length; i++) {
			if(board[i][columnNumber] == number) return true;
		}
		return false;
	}
	
	public boolean threeByThreeGridContains(char number, int y, int x, char[][] board) {	

		int yOffset;
		if(y < 3) yOffset = 0;
		else if(y < 6) yOffset = 3;
		else yOffset = 6;
		
		int xOffset;
		if(x < 3) xOffset = 0;
		else if(x < 6) xOffset = 3;
		else xOffset = 6;
		
		for(int i = yOffset; i < yOffset+3; i++) {
			for(int j = xOffset; j < xOffset + 3; j++) {
				if(board[i][j] == number) return true;
			}
		}
		return false;
	}
	
}
