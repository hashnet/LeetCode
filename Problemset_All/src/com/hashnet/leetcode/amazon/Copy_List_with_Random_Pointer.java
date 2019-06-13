package com.hashnet.leetcode.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Copy_List_with_Random_Pointer {
	private class Node {
	    public int val;
	    public Node next;
	    public Node random;

	    public Node() {}

	    public Node(int _val,Node _next,Node _random) {
	        val = _val;
	        next = _next;
	        random = _random;
	    }
	}
	
    public Node copyRandomList(Node head) {
    	if(head == null) return null;
    	
    	Map<Node, Integer> table = new HashMap<>();
        
        List<Node> newNodeList = new ArrayList<>();
        Node curr = head;
        int index = 0;
        while(curr != null) {
        	table.put(curr, index);
        	
        	Node newNode = new Node();
        	newNode.val = curr.val;
        	newNodeList.add(newNode);
        	
        	curr = curr.next;
        	++index;
        }
        
        for(int i=0; i<newNodeList.size()-1; i++) {
        	newNodeList.get(0).next = newNodeList.get(i+1);
        }
        newNodeList.get(newNodeList.size()-1).next = null;
        
        curr = head;
        index = 0;
        while(curr != null) {
        	if(curr.random == null) {
        		newNodeList.get(index).random = null;
        	} else {
	        	int randIndex = table.get(curr.random);
	        	newNodeList.get(index).random = newNodeList.get(randIndex);
        	}
        	
        	curr = curr.next;
        	++index;
        }
        
        return newNodeList.get(0);
    }
    
    public static void main(String[] args) {
    	
	}
}
