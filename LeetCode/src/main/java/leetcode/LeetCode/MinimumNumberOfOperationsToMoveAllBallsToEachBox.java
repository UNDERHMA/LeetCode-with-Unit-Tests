package leetcode.LeetCode;

public class MinimumNumberOfOperationsToMoveAllBallsToEachBox {

	public int[] minOperations(String boxes) {
		
		int boxesLength = boxes.length();
		char[] boxesAsArray = boxes.toCharArray();
		
		int[] result = new int[boxesLength];
		int currentMoves;
		
		for(int i = 0; i < boxesLength; i++) {
			currentMoves = 0;
			for(int j = 0;  j < boxesLength; j++) {
				if(i == j) continue;
				if(boxesAsArray[j] == '1') {
					currentMoves += Math.abs(i - j);
				}
			}
			result[i] = currentMoves;
		}
        return result;
    }

}
