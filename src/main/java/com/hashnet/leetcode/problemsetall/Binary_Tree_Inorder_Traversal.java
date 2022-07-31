package com.hashnet.leetcode.problemsetall;

import com.hashnet.leetcode.utility.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Binary_Tree_Inorder_Traversal {
	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        
        inorder(list, root);
        
        return list;        
    }
	
	private void inorder(List<Integer> list, TreeNode root) {
		if(root == null) return;
		
		inorder(list, root.left);
		list.add(root.val);
		inorder(list, root.right);
	}
}
