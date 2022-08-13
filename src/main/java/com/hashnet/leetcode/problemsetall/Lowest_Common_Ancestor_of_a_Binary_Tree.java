package com.hashnet.leetcode.problemsetall;

import com.hashnet.leetcode.utility.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Lowest_Common_Ancestor_of_a_Binary_Tree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Deque<TreeNode> pStack = new ArrayDeque<>();
        traverse(root, p, pStack);

        Deque<TreeNode> qStack = new ArrayDeque<>();
        traverse(root, q, qStack);

        TreeNode result = null;
        while (true) {
            if (pStack.isEmpty() || qStack.isEmpty()) return result;

            TreeNode pNode = pStack.pop();
            TreeNode qNode = qStack.pop();

            if (pNode == qNode) {
                result = pNode;
            } else break;
        }

        return result;
    }

    private boolean traverse(TreeNode node, TreeNode needle, Deque<TreeNode> stack) {
        if (needle == node) {
            stack.push(node);
            return true;
        } else if (node.left != null && traverse(node.left, needle, stack)) {
            stack.push(node);
            return true;
        } else if (node.right != null && traverse(node.right, needle, stack)) {
            stack.push(node);
            return true;
        }

        return false;
    }
}
