package com.hashnet.leetcode.problemsetall;

import com.hashnet.leetcode.utility.TreeNode;

public class Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {
    public static void main(String[] arg) {
        Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal s = new Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal();

        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        TreeNode root = s.buildTree(preorder, inorder);

        System.out.println(root.val);
    }

    private int index = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int left = 0;
        int right = inorder.length - 1;

        return makeTree(inorder, left, right, preorder);
    }

    private TreeNode makeTree(int[] inorder, int left, int right, int[] preorder) {
        if (right < left) return null;

        int x = preorder[index++];
        TreeNode tree = new TreeNode(x);

        int pos = find(inorder, left, right, x);
        tree.left = makeTree(inorder, left, pos - 1, preorder);
        tree.right = makeTree(inorder, pos + 1, right, preorder);

        return tree;
    }

    private int find(int[] inorder, int left, int right, int x) {
        for (int i = left; i <= right; i++) {
            if (inorder[i] == x) return i;
        }

        return -1;
    }
}
