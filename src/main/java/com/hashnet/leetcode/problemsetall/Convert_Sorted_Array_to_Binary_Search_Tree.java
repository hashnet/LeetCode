package com.hashnet.leetcode.problemsetall;

import com.hashnet.leetcode.utility.TreeNode;
import com.hashnet.leetcode.utility.TreeUtility;

public class Convert_Sorted_Array_to_Binary_Search_Tree {
    public TreeNode sortedArrayToBST(int[] nums) {

        return partialArrayToNode(nums, 0, nums.length - 1);
    }

    private TreeNode partialArrayToNode(int[] nums, int i, int j) {
        if (i > j) return null;

        int mid = i + (j / 2) - i / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = partialArrayToNode(nums, i, mid - 1);
        node.right = partialArrayToNode(nums, mid + 1, j);

        return node;
    }

    public static void main(String[] args) {
        Convert_Sorted_Array_to_Binary_Search_Tree solution = new Convert_Sorted_Array_to_Binary_Search_Tree();
        System.out.println(TreeUtility.treeToString(solution.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9})));
    }
}
