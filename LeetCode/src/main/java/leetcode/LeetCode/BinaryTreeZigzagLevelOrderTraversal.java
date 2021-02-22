package leetcode.LeetCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {
	
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
		ArrayDeque<TreeNode> queue = new ArrayDeque<>();
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> currentResult;
		if(root == null) return result;
		
		// Use queue to perform BFS order level traversal
		queue.add(root);
		int nodesInLevel;
		TreeNode currentNode;
		while(!queue.isEmpty()) {
			nodesInLevel = queue.size();
			currentResult = new ArrayList<>();
			while(nodesInLevel > 0) {
				currentNode = queue.poll();
				if(currentNode.left != null) queue.add(currentNode.left);
				if(currentNode.right != null) queue.add(currentNode.right);
				currentResult.add(currentNode.val);
				nodesInLevel--;
			}
			result.add(currentResult);
		}

		// reverse every other row to create zigzag order
		int resultLength = result.size();
		for(int i = 0 ; i < resultLength; i++) {
			if(i % 2 == 1) Collections.reverse(result.get(i));
		}
		return result;
    }
}
