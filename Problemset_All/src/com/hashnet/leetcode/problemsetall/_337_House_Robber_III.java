package com.hashnet.leetcode.problemsetall;

import com.hashnet.leetcode.utility.TreeNode;
import com.hashnet.leetcode.utility.TreeUtility;

import java.util.HashMap;
import java.util.Map;

public class _337_House_Robber_III {
    Map<TreeNode, Integer[]> memo = new HashMap<>();

    public int rob(TreeNode root) {
        Integer[] result  = DP(root);
        return Math.max(result[0], result[1]);
    }

    private Integer[]  DP(TreeNode node) {
        if (node == null) {
            return new Integer[] {0, 0};
        }

        if (memo.containsKey(node)) {
            return memo.get(node);
        }

        Integer[] leftResult = DP(node.left);       //0 for current node included
        Integer[] rightResult = DP(node.right);     //1 for current dnode excluded

        Integer[] result = new Integer[2];
        result[0] = node.val + leftResult[1] + rightResult[1];
        result[1] = Math.max(leftResult[0], leftResult[1]) + Math.max(rightResult[0], rightResult[1]);

        memo.put(node, result);

        return result;
    }

    public static void main(String[] args) {
        _337_House_Robber_III solution = new _337_House_Robber_III();

        System.out.println(solution.rob(TreeUtility.createTree("[3,2,3,null,3,null,1]")));
        System.out.println(solution.rob(TreeUtility.createTree("[3,4,5,1,3,null,1]")));
    }
}
