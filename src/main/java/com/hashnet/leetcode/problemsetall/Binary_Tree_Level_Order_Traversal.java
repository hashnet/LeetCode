package com.hashnet.leetcode.problemsetall;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.hashnet.leetcode.utility.TreeNode;

public class Binary_Tree_Level_Order_Traversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
		Queue<TreeNode> treeQ = new LinkedList<>();
		Queue<Integer> indexQ = new LinkedList<>();

		List<List<Integer>> result = new ArrayList<>();
		if (root == null) {
			return result;
		}

		treeQ.add(root);
		indexQ.add(1);
		int prevIdx = 0;
		List<Integer> row = null;
		while (!treeQ.isEmpty()) {
			TreeNode node = treeQ.remove();
			int idx = indexQ.remove();

			if (idx != prevIdx) {
                if(prevIdx != 0) {
                    result.add(row);    
                }
                
				row = new ArrayList<>();
			}
			row.add(node.val);
            
            if(node.left != null) {
                treeQ.add(node.left);
                indexQ.add(idx+1);
            }
            if(node.right != null) {
                treeQ.add(node.right);
                indexQ.add(idx+1);
            }

			prevIdx = idx;
		}
        
        result.add(row);
		
		return result;        
    }

	public static void main(String[] args) {

	}
}
