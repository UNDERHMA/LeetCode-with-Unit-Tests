package leetcode.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

	public TreeNode buildTree(int[] preorder, int[] inorder) {
       
		if(preorder.length == 0) return null;
		Map<Integer,Integer> inorderCache = new HashMap<>();
		
		for(int i = 0; i < inorder.length; i++) {
			inorderCache.put(inorder[i],i);
		}
		
		return buildTree(preorder,inorder,0,preorder.length,inorderCache);
    }
	
	public TreeNode buildTree(int[] preorder, int[] inorder, int preorderStart,
			int preOrderLength, Map<Integer,Integer> inorderCache) {
		
		int inorderIndex = inorderCache.get(preorder[preorderStart]);
		inorderCache.replace(preorder[preorderStart], -1);
		TreeNode currentHead = new TreeNode(inorder[inorderIndex]);		
		
		for(int i = preorderStart+1; i < preorder.length; i++) {
			if(inorderCache.get(preorder[i]) != -1 && 
					inorderCache.get(preorder[i]) > inorderIndex) {
				currentHead.right = buildTree(preorder,inorder,i,preOrderLength,inorderCache);
				break;
			}
		}
		for(int i = preorderStart+1; i < preorder.length; i++) {
			if(inorderCache.get(preorder[i]) != -1 && 
					inorderCache.get(preorder[i]) < inorderIndex) {
				currentHead.left = buildTree(preorder,inorder,i,preOrderLength,inorderCache);
				break;
			}
		}
		return currentHead;
	}
}
