package leetcode.LeetCode;

public class MedianOfTwoSortedArrays {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
		int nums1Length = nums1.length;
		int nums2Length = nums2.length;
		if(nums1Length == 0 && nums2Length == 0) return 0.0;
		int originalMedianIndex = ((nums1Length + nums2Length) 
				+ (nums1Length + nums2Length) % 2 ) / 2;
		boolean trueMedian = (nums1Length + nums2Length) % 2 == 1;
		
		if(nums1Length == 0) {
			if(trueMedian) return (double) nums2[nums2Length / 2];
			return ((double) (nums2[originalMedianIndex-1] +  
					nums2[originalMedianIndex])) / 2.0;
		}
		
		if(nums2Length == 0) {
			if(trueMedian) return (double) nums1[nums1Length / 2];
			return ((double) (nums1[originalMedianIndex-1] +  
					nums1[originalMedianIndex])) / 2.0;
		}
		
		
		int indexNums1 = -1;
		int indexNums2 = -1;
		int potentialNextIndexValueNums1 = ((nums1Length-1 + indexNums1)) / 2;
		int potentialNextIndexValueNums2 = ((nums2Length-1 + indexNums2)) / 2;
		int currentNums1Value;
		int currentNums2Value;
		while(originalMedianIndex != 0) {
			if(potentialNextIndexValueNums1 < nums1Length) {
				currentNums1Value = nums1[potentialNextIndexValueNums1];
			} else currentNums1Value = Integer.MAX_VALUE;
			if(potentialNextIndexValueNums2 < nums2Length) {
				currentNums2Value = nums2[potentialNextIndexValueNums2];
			} else currentNums2Value = Integer.MAX_VALUE;
			if(currentNums1Value <= currentNums2Value) {
				originalMedianIndex -= (potentialNextIndexValueNums1 - indexNums1);
					indexNums1 = potentialNextIndexValueNums1;
			} else {
				originalMedianIndex -= (potentialNextIndexValueNums2 - indexNums2);
					indexNums2 = potentialNextIndexValueNums2;
			}
			if(originalMedianIndex >= nums1Length && indexNums1 < nums1Length-1) {
				potentialNextIndexValueNums1 = nums1Length-1;
			} else potentialNextIndexValueNums1 = indexNums1 + originalMedianIndex/2 + originalMedianIndex % 2;
			if(originalMedianIndex >= nums2Length&& indexNums2 < nums2Length-1) {
				potentialNextIndexValueNums2 = nums2Length-1;
			} else potentialNextIndexValueNums2 = indexNums2 + originalMedianIndex/2 + originalMedianIndex % 2;
		}
		
		
		if(trueMedian) {
			if(indexNums1 == -1) return nums2[indexNums2];
			else if(indexNums2 == -1) return nums1[indexNums1];
			else return (double) Math.max(nums1[indexNums1],nums2[indexNums2]);
		}
		else {
			int nextMedianValue;
			if(indexNums1 == nums1Length-1) nextMedianValue = nums2[indexNums2+1];
			else if(indexNums2 == nums2Length-1) nextMedianValue = nums1[indexNums1+1];
			else nextMedianValue = Math.min(nums1[indexNums1+1],nums2[indexNums2+1]);
			
			int currentMedianValue;
			if(indexNums1 == -1) currentMedianValue = nums2[indexNums2];
			else if(indexNums2 == -1) currentMedianValue = nums1[indexNums1];
			else currentMedianValue = Math.max(nums1[indexNums1],nums2[indexNums2]);
			
			return ((double) (currentMedianValue + nextMedianValue)) / 2.0; 
		}
    }
}
