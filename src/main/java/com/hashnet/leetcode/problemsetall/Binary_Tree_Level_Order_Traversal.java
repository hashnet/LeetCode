package com.hashnet.leetcode.problemsetall;

import com.hashnet.leetcode.utility.ListUtility;
import com.hashnet.leetcode.utility.TreeNode;
import com.hashnet.leetcode.utility.TreeUtility;

import java.util.ArrayList;
import java.util.List;

public class Binary_Tree_Level_Order_Traversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        visit(root, 0, result);

        return result;
    }

    private void visit(TreeNode node, int level, List<List<Integer>> result) {
        // visit left
        if (node.left != null) {
            visit(node.left, level + 1, result);
        }

        // process current node
        if (result.size() <= level) {
            for (int i = result.size(); i <= level; i++) {
                result.add(new ArrayList<>());
            }
        }
        result.get(level).add(node.val);

        // visit right
        if (node.right != null) {
            visit(node.right, level + 1, result);
        }
    }

    public static void main(String[] args) {
        Binary_Tree_Level_Order_Traversal solution = new Binary_Tree_Level_Order_Traversal();

        System.out.println(ListUtility.prettyPrint(solution.levelOrder(TreeUtility.createTree("[3,9,20,null,null,15,7]"))));
        System.out.println(ListUtility.prettyPrint(solution.levelOrder(TreeUtility.createTree("[1]"))));
        System.out.println(ListUtility.prettyPrint(solution.levelOrder(TreeUtility.createTree("[]"))));
    }
}
