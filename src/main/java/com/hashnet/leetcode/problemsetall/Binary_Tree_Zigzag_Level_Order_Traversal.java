package com.hashnet.leetcode.problemsetall;

import com.hashnet.leetcode.utility.TreeNode;

import java.util.*;

public class Binary_Tree_Zigzag_Level_Order_Traversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> treeQ = new LinkedList<>();
        Queue<Integer> idxQ = new LinkedList<>();

        treeQ.add(root);
        idxQ.add(1);
        int prevIdx = 0;
        List<Integer> row = null;
        while (!treeQ.isEmpty()) {
            TreeNode node = treeQ.remove();
            int idx = idxQ.remove();

            if (idx != prevIdx) {
                if (prevIdx != 0) {
                    result.add(row);
                }
                row = new ArrayList<>();
            }

            row.add(node.val);
            if (node.left != null) {
                treeQ.add(node.left);
                idxQ.add(idx + 1);
            }
            if (node.right != null) {
                treeQ.add(node.right);
                idxQ.add(idx + 1);
            }

            prevIdx = idx;
        }
        result.add(row);

        for (int i = 0; i < result.size(); i++) {
            if (i % 2 == 1) {
                Collections.reverse(result.get(i));
            }
        }

        return result;
    }
}
