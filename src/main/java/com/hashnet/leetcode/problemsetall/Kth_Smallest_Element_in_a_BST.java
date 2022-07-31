package com.hashnet.leetcode.problemsetall;

import com.hashnet.leetcode.utility.TreeNode;

import static com.hashnet.leetcode.utility.TreeUtility.stringToTreeNode;

class Kth_Smallest_Element_in_a_BST {
    public int kthSmallest(TreeNode root, int k) {
        return inorder(root, k);
    }
    
    private static int counter = 0;
    
    private int inorder(TreeNode node, int k) {
        int num = -1;
        if(node.left != null && counter < k) num = inorder(node.left, k);
        if(node != null && counter < k) {
            num = node.val;
            ++counter;
        }
        if(node.right != null && counter < k) num = inorder(node.right, k);
        
        return num;
    }

    public static void main(String[] args) {
        Kth_Smallest_Element_in_a_BST solution = new Kth_Smallest_Element_in_a_BST();

        System.out.println(solution.kthSmallest(stringToTreeNode("[3,1,4,null,2]"), 1));
        System.out.println(solution.kthSmallest(stringToTreeNode("[5,3,6,2,4,null,null,1]"), 3));
    }
}