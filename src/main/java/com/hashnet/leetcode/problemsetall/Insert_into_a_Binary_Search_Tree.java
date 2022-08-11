package com.hashnet.leetcode.problemsetall;

import com.hashnet.leetcode.utility.TreeNode;
import com.hashnet.leetcode.utility.TreeUtility;

public class Insert_into_a_Binary_Search_Tree {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if(val < root.val) {
            if(root.left == null) {
                root.left = new TreeNode(val);
            } else {
                insertIntoBST(root.left, val);
            }
        } else {
            if(root.right == null) {
                root.right = new TreeNode(val);
            } else {
                insertIntoBST(root.right, val);
            }
        }

        return root;
    }

    public static void main(String[] args) {
        Insert_into_a_Binary_Search_Tree solution = new Insert_into_a_Binary_Search_Tree();

        System.out.println(TreeUtility.prettyPrint(solution.insertIntoBST(TreeUtility.createTree("[]"), 5)));
        System.out.println(TreeUtility.prettyPrint(solution.insertIntoBST(TreeUtility.createTree("[4,2,7,1,3]"), 5)));
        System.out.println(TreeUtility.prettyPrint(solution.insertIntoBST(TreeUtility.createTree("[40,20,60,10,30,50,70]"), 25)));
        System.out.println(TreeUtility.prettyPrint(solution.insertIntoBST(TreeUtility.createTree("[4,2,7,1,3,null,null,null,null,null,null]"), 5)));
    }
}
