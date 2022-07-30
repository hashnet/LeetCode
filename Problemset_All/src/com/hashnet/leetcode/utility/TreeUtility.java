package com.hashnet.leetcode.utility;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class TreeUtility {
	public static TreeNode createTree(String str) {
		str = str.replaceAll("[\\s(){}\\[\\]]", "");

		String[] values = str.split(",");
		TreeNode[] nodes = new TreeNode[values.length];
		
		TreeNode root = null;
		for (int i = 0; i < values.length; i++) {
			
			TreeNode node;
			if(values[i].equals("null")) node = null;
			else {
				Integer value = Integer.parseInt(values[i]);
				node = new TreeNode(value);
			}
			nodes[i] = node;
			
			if(i == 0) {
				root = node;
			} else {
				if(i % 2 == 1) {
					nodes[(i-1) / 2].left = node;
				} else {
					nodes[(i-2) / 2].right = node;
				}
			}
		}

		return root;
	}
	
	public static String treeToString(TreeNode root) {
		if (root == null) {
			return "[null]";
		}

		StringBuilder sb = new StringBuilder("[");
		
		Queue<TreeNode> q = new ArrayDeque<>();		
		q.add(root);
		boolean firstItem = true;
		while(!q.isEmpty()) {
			TreeNode node = q.remove();
			
			if(!firstItem) sb.append(",");
			else firstItem = false;

			if(node == null) {
				sb.append("null");
			} else {
				sb.append(node.val);
				if(node.left != null) q.add(node.left);
				if(node.right != null) q.add(node.right);
			}
		}
		
		sb.append("]");
		return sb.toString();
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
		Queue<TreeNode> nodeQueue = new LinkedList<>();
		nodeQueue.add(root);

		int index = 1;
		while(!nodeQueue.isEmpty()) {
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
	
	public static void main(String[] args) {
		TreeNode root = createTree("3,5,1,6,2,0,8,null,null,7,4");
		System.out.println(treeToString(root));

		System.out.println(treeToString(createTree("[3,5,1,6,2,0,8,null,null,7,4]")));
	}
}
