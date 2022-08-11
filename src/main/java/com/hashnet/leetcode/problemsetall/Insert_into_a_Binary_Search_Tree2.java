package com.hashnet.leetcode.problemsetall;

import com.hashnet.leetcode.utility.TreeNode;
import com.hashnet.leetcode.utility.TreeUtility;

public class Insert_into_a_Binary_Search_Tree2 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if(val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }

        return root;
    }

    public static void main(String[] args) {
        Insert_into_a_Binary_Search_Tree2 solution = new Insert_into_a_Binary_Search_Tree2();

        System.out.println(TreeUtility.prettyPrint(solution.insertIntoBST(TreeUtility.createTree("[]"), 5)));
        System.out.println(TreeUtility.prettyPrint(solution.insertIntoBST(TreeUtility.createTree("[4,2,7,1,3]"), 5)));
        System.out.println(TreeUtility.prettyPrint(solution.insertIntoBST(TreeUtility.createTree("[40,20,60,10,30,50,70]"), 25)));
        System.out.println(TreeUtility.prettyPrint(solution.insertIntoBST(TreeUtility.createTree("[4,2,7,1,3,null,null,null,null,null,null]"), 5)));
    }
}
