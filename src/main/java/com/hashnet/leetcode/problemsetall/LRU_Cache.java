package com.hashnet.leetcode.problemsetall;

import java.util.HashMap;
import java.util.Map;

public class LRU_Cache {
    private class Node {
    	private int key;
        private int val;
        
        public Node(int key, int val) {
        	this.key = key;
        	this.val = val;
        }
        
        private Node prev;
        private Node next;
    }
    
    private class DLL {
        int size;
    	Node head;
        Node tail;
        
        public DLL() {
        	this.size = 0;
        	
        	this.head = new Node(-1, -1);
        	this.tail = new Node(-1, -1);
        	head.prev = null;
        	head.next = tail;
        	tail.prev = head;
        	tail.next = null;
        }
        
        public void addLast(Node node) {
        	
    		Node prev = tail.prev;
    		Node next = tail;
    		
    		prev.next = node;
    		node.prev = prev;
    		node.next = next;
    		next.prev = node;
        	
        	++size;
        }
        
        public Node removeFirst() {
        	if(head.next == tail) return null;
        	
        	Node node = head.next;
        	removeNode(node);
        	
        	return node;
        }
        
        public void removeNode(Node node) {
        	node.prev.next = node.next;
        	node.next.prev = node.prev;
        	
        	--size;
        }
    }
    
    private int capacity;
    private Map<Integer, Node> map;
    private DLL dll;
    public LRU_Cache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        dll = new DLL();
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
        	Node n = map.get(key);
        	dll.removeNode(n);
        	dll.addLast(n);
        	
        	return n.val;
        } else {
        	return -1;
        }
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
        	Node n = map.get(key);
        	dll.removeNode(n);
        	n.val = value;
        	dll.addLast(n);
        } else {
        	if(dll.size >= capacity) {
        		Node n = dll.removeFirst();
        		map.remove(n.key);
        	}
        	
        	Node n = new Node(key, value);
        	dll.addLast(n);
        	map.put(key, n);
        }
    }
    
    public static void main(String[] args) {
    	LRU_Cache cache = new LRU_Cache( 1 /* capacity */ );

    	cache.put(2, 1);
    	cache.get(2);       // returns 1
    	cache.put(3, 2);    // evicts key 2
    	cache.get(2);       // returns -1 (not found)
    	cache.get(3);       // returns 4
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */