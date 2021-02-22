package leetcode.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {

	public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
		List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        List<Integer> currentResult = new ArrayList<Integer>();
        currentResult.add(root.val);
		calculatePathSums(result,currentResult,root.val,targetSum,root);
		return result;
    }

	public void calculatePathSums(List<List<Integer>> result, List<Integer> currentResult,
			int currentSum, int targetSum, TreeNode root) {
		
		if(root.left == null && root.right == null) {
			if(currentSum == targetSum) result.add(new ArrayList(currentResult));
			return;
		}
		
		if(root.left != null) {
			currentResult.add(root.left.val);
			calculatePathSums(result,currentResult,
					currentSum+root.left.val,targetSum, root.left);
			currentResult.remove(currentResult.size()-1);
		}
		if(root.right != null) {
			currentResult.add(root.right.val);
			calculatePathSums(result,currentResult,
					currentSum+root.right.val,targetSum, root.right);
			currentResult.remove(currentResult.size()-1);
		}
	}
	
}
