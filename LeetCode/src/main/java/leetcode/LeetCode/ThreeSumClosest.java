package leetcode.LeetCode;

import java.util.Arrays;

public class ThreeSumClosest {

	public static int threeSumClosest(int[] nums, int target) {
        
		int[] sortedArray = nums.clone();
		Arrays.sort(sortedArray);
		int closestSum = Integer.MAX_VALUE - Math.abs(2*target);
		
		for(int i = 0; i < sortedArray.length-1; i++) {
			int j = i+1;
			int k = sortedArray.length-1;
			while(j < k) {
				int sum = sortedArray[i] + sortedArray[j] + sortedArray[k];
				if(Math.abs(sum - target)
						< Math.abs(closestSum - target)) {
					closestSum = sortedArray[i] + sortedArray[j] + sortedArray[k];
				}
				if(closestSum == target) {
					return closestSum;
				}
				else if(sum > target) {
					k--;
				}
				else {
					j++;
				}
			}
		}
		return closestSum;	
    }
}
