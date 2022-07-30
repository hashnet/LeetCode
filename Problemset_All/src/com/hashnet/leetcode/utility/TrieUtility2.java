package com.hashnet.leetcode.utility;

import java.util.HashMap;
import java.util.Map;

public class TrieUtility2 {
	private TrieNode root;
	
	private class TrieNode {
		Map<Character, TrieNode> children;
		boolean isEnd;
		
		public TrieNode() {
			children = new HashMap<>();
			isEnd = false;
		}
	}
	
	public TrieUtility2() {
		root = new TrieNode();
	}
	
	public void add(String word) {
		add(root, word, 0);
	}
	
	private void add(TrieNode node, String word, int index) {
		if(index >= word.length()) {
			node.isEnd = true;
			return;
		}
		
		char key = word.charAt(index);
		if(node.children.containsKey(key)) {
			add(node.children.get(key), word, index+1);
		} else {
			TrieNode newNode = new TrieNode();
			node.children.put(key, newNode);
			add(newNode, word, index+1);
		}
	}
	
	public boolean search(String word) {
		return search(root, word, 0);
	}
	
	private boolean search(TrieNode node, String word, int index) {
		if(index >= word.length()) return node.isEnd;
		
		char key = word.charAt(index);
		if(node.children.containsKey(key)) {
			return search(node.children.get(key), word, index+1);
		} else {
			return false;
		}
	}
	
	public void delete(String word) {
		delete(root, word, 0);
	}
	
	private boolean delete(TrieNode node, String word, int index) {
		if(index >= word.length()) {
			if(!node.isEnd) return false;
			else {
				node.isEnd = false;
				return node.children.isEmpty();
			}
		}
		
		char key = word.charAt(index);
		if(!node.children.containsKey(key)) return false;
		boolean shouldDelKey = delete(node.children.get(key), word, index+1);
		if(shouldDelKey) {
			node.children.remove(key);
		}
		
		if(node.children.isEmpty()) return true;
		else return false;
	}
	
	public static void main(String[] args) {
		TrieUtility2 t = new TrieUtility2();
		t.add("abc");
		t.add("abd");
		t.add("cd");
		t.add("ab");
		System.out.println();
		System.out.println(t.search("abc"));
		System.out.println(t.search("a"));
		System.out.println(t.search("abd"));
		System.out.println(t.search("cd"));
		System.out.println(t.search("abcd"));
		
		t.delete("ab");
		t.delete("abd");
		t.delete("abce");
		
		System.out.println();
		System.out.println(t.search("abc"));
		System.out.println(t.search("ab"));
		System.out.println(t.search("abd"));
		System.out.println(t.search("cd"));
		System.out.println(t.search("abcd"));
		
	}
}
