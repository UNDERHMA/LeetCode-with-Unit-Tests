package leetcode.LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidSudoku {
	public static boolean isValidSudoku(char[][] board) {
		
		//storing used values
		Set<Character> values = new HashSet<>();
		Character[] chars = new Character[] {'1','2','3','4','5','6','7','8','9'};
		List<Character> validChars = Arrays.asList(chars);
		
        //ensure valid rows
		for(int y = 0; y < 9; y++) {
			int dotCount = 0;
			for(int x = 0 ; x < 9; x++) {
				if(board[y][x] != '.' && validChars.contains(board[y][x])) {
					values.add(board[y][x]);
				}
				if(board[y][x] == '.') {
					dotCount++;
				}
			}
			if(dotCount + values.size() != 9) {
				return false;
			}
			values = new HashSet<>();
		}
		
		//ensure valid columns
		for(int x = 0; x < 9; x++) {
			int dotCount = 0;
			for(int y = 0 ; y < 9; y++) {
				if(board[y][x] != '.' && validChars.contains(board[y][x])) {
					values.add(board[y][x]);
				}
				if(board[y][x] == '.') {
					dotCount++;
				}
			}
			if(dotCount + values.size() != 9) {
				return false;
			}
			values = new HashSet<>();
		}
		
		//ensure valid 3 x 3s
		for(int y = 0; y < 9; y+=3) {
			for(int x = 0; x < 9; x+=3) {
				int dotCount = 0;
				for(int yOffset = 0; yOffset < 3; yOffset++) {
						for(int xOffset = 0; xOffset < 3; xOffset++) {
							if(board[yOffset + y][x + xOffset] != '.' && validChars.contains(board[yOffset + y][x + xOffset])) {
								values.add(board[yOffset + y][x + xOffset]);
							}
							if(board[yOffset + y][x + xOffset] == '.') {
								dotCount++;
							}
						}
				}
				if(dotCount + values.size() != 9) {
					return false;
				}
				values = new HashSet<>();
			}
		}
		return true;
	}
}
