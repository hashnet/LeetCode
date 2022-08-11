package com.hashnet.leetcode.utility;

import java.util.*;
import java.util.stream.Collectors;

public class TreeUtility {
    public static TreeNode createTree(String str) {
        str = str.replaceAll("[\\s(){}\\[\\]]", "");

        String[] values = str.split(",");
        TreeNode[] nodes = new TreeNode[values.length];

        TreeNode root = null;
        for (int i = 0; i < values.length; i++) {

            TreeNode node;
            if (values[i].equals("null")) node = null;
            else {
                int value = Integer.parseInt(values[i]);
                node = new TreeNode(value);
            }
            nodes[i] = node;

            if (i == 0) {
                root = node;
            } else {
                if (i % 2 == 1) {
                    nodes[(i - 1) / 2].left = node;
                } else {
                    nodes[(i - 2) / 2].right = node;
                }
            }
        }

        return root;
    }

    public static String treeToString(TreeNode root) {
        if (root == null) {
            return "[null]";
        }

        List<Object> list = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode node = q.remove();


            if (node == null) {
                list.add(null);
            } else {
                list.add(node.val);
                q.add(node.left);
                q.add(node.right);
            }
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) == null) {
                list.remove(i);
            } else {
                break;
            }
        }

        return list.stream()
                .map(o -> o == null ? "null" : o.toString())
                .collect(Collectors.joining(",", "[", "]"));
    }

    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new ArrayDeque<>();
        nodeQueue.add(root);

        int index = 1;
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    public static String prettyPrint(TreeNode root) {
        return prettyPrint(root, new StringBuilder(), true, new StringBuilder()).toString();
    }

    private static StringBuilder prettyPrint(TreeNode node, StringBuilder prefix, boolean isTail, StringBuilder sb) {
        if (node.right != null) {
            prettyPrint(node.right, new StringBuilder().append(prefix).append(isTail ? "│   " : "    "), false, sb);
        }
        sb.append(prefix).append(isTail ? "└── " : "┌── ").append(node.val).append("\n");
        if (node.left != null) {
            prettyPrint(node.left, new StringBuilder().append(prefix).append(isTail ? "    " : "│   "), true, sb);
        }
        return sb;
    }

    public static void main(String[] args) {
        TreeNode root = createTree("3,5,1,6,2,0,8,null,null,7,4");
        System.out.println(treeToString(root));

        System.out.print(prettyPrint(root));

        System.out.println(treeToString(createTree("[3,5,1,6,2,0,8,null,null,7,4]")));
    }
}
