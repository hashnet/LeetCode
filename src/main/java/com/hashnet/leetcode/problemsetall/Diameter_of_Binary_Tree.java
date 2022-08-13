package com.hashnet.leetcode.problemsetall;

import com.hashnet.leetcode.utility.TreeNode;
import com.hashnet.leetcode.utility.TreeUtility;

public class Diameter_of_Binary_Tree {
    private int max;

    public int diameterOfBinaryTree(TreeNode root) {
        max = 0;
        getMaxLen(root);
        return max;
    }

    private int getMaxLen(TreeNode node) {
        if (node == null) return 0;

        int left = getMaxLen(node.left);
        int right = getMaxLen(node.right);

        int most = left + right;
        if (most > max) max = most;

        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        Diameter_of_Binary_Tree solution = new Diameter_of_Binary_Tree();

        System.out.println(solution.diameterOfBinaryTree(TreeUtility.createTree("1, 2, 3, 4, 5")));
        System.out.println(solution.diameterOfBinaryTree(TreeUtility.createTree("1")));
    }
}
