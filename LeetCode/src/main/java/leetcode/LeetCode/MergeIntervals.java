package leetcode.LeetCode;

public class MergeIntervals {
	public int[][] merge(int[][] intervals) {
        
		int length = intervals.length;
		int merged = 0;
		merged = calculate(intervals);

		int[][] results = new int[length-merged][2];
		int resultIndex = 0;
		for(int i = 0; i < length; i++) {
			if(intervals[i][0] != -1) {
				results[resultIndex][0] = intervals[i][0];
				results[resultIndex++][1] = intervals[i][1];
			}
		}
		return results;
    }
	
	public int calculate(int[][] intervals) {
		int length = intervals.length;
		int start;
		int end;
		int secondStart;
		int secondEnd;
		int merged = 0;
		
		for(int i = 0; i < length-1; i++) {
			start = intervals[i][0];
			end = intervals[i][1];
			for(int j = i+1; j < length; j++) {
				secondStart = intervals[j][0];
				secondEnd = intervals[j][1];
				if(end < secondStart || start > secondEnd) continue;
				else {
					intervals[j][0] = Math.min(start,secondStart);
					intervals[j][1] = Math.max(end,secondEnd);
					intervals[i][0] = -1; // marking earlier interval no longer valid after merge
					intervals[i][1] = -1; // marking earlier interval no longer valid after merge
					merged++;
					break;
				}
			}
		}
		return merged;
	}
}
