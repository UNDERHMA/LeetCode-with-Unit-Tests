package leetcode.LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TheKWeakestRowsInAMatrix {
	public int[] kWeakestRows(int[][] mat, int k) {
		
		List<List<Integer>> orderedResultList = new ArrayList<>();
		List<Integer> newResult;
		int soldierCountPerRow;
		
		for(int i = 0; i < mat.length; i++) {
			soldierCountPerRow = 0;
			for(int j = 0; j < mat[i].length; j++) {
				if(mat[i][j] == 1) soldierCountPerRow++;
			}
			newResult = new ArrayList<>();
			newResult.add(i);
			newResult.add(soldierCountPerRow);
			orderedResultList.add(newResult);
		}
        
		Collections.sort(orderedResultList,(a,b) -> a.get(1) - b.get(1));
		int[] result = new int[k];
		for(int i = 0; i < k; i++) {
			result[i] = orderedResultList.get(i).get(0);
		}
		return result;
    }
}
