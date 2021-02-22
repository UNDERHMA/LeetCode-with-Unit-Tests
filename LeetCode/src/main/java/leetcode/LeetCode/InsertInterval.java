package leetcode.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {

	public int[][] insert(int[][] intervals, int[] newInterval) {
		
		if(intervals == null || intervals.length == 0) {
			int[][] result = new int[1][2];
			result[0][0] = newInterval[0];
			result[0][1] = newInterval[1];
			return result;
		}
		
		List<List<Integer>> resultList = new ArrayList<>();
		List<Integer> listToAdd = new ArrayList<>();
		boolean placed = false;
		
		for(int index = 0; index < intervals.length; index++) {
						
			if((intervals[index][0] >= newInterval[0] 
					&& intervals[index][0] <= newInterval[1])
				|| (intervals[index][1] >= newInterval[0]
					&& intervals[index][1] <= newInterval[1])
				|| (intervals[index][0] <= newInterval[0]
					&& intervals[index][1] >= newInterval[1])
				) {
				placed = true;
				listToAdd = Arrays.asList
						(new Integer[] {Math.min(intervals[index][0],newInterval[0]),
									Math.max(intervals[index][1],newInterval[1])
						});
				while(index+1 < intervals.length &&
						intervals[index+1][0] <= listToAdd.get(1)) {
					listToAdd.set(1,Math.max(intervals[index+1][1],newInterval[1]));
					index++;
				}
			}
			else if(placed == false && intervals[index][0] > newInterval[1]) {
				listToAdd = Arrays.asList
						(new Integer[] {newInterval[0],newInterval[1]});
				placed = true;
				index--;
			}
			else {
				listToAdd = Arrays.asList
						(new Integer[] {intervals[index][0],intervals[index][1]});
			}
			resultList.add(listToAdd);
		}
		
		// add result if not added 
		if(placed == false) {
			listToAdd = Arrays.asList
					(new Integer[] {newInterval[0],newInterval[1]});
			resultList.add(listToAdd);
		}
		
		// Convert List to array and return results:
		int[][] results = new int[resultList.size()][2];
		for(int index = 0; index < resultList.size(); index++) {
			results[index][0] = resultList.get(index).get(0);
			results[index][1] = resultList.get(index).get(1);		
		}
		return results;
    }

}
