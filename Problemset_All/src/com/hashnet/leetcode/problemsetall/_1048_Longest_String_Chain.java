package com.hashnet.leetcode.problemsetall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class _1048_Longest_String_Chain {
	class Solution {
		int max = Integer.MIN_VALUE;
		
	    public int longestStrChain(String[] words) {
	    	Arrays.sort(words, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}});
	    	
	    	List<List<Integer>> adjList = new ArrayList<>();
	    	for(int i=0; i<words.length; i++) {
	    		adjList.add(new ArrayList<>());
	    	}
	    	
	    	for(int i=0; i<words.length-1; i++) {
	    		for(int j=i+1; j<words.length; j++) {
	    			String a = words[i];
	    			String b = words[j];
	    			
	    			if(a.length() == b.length()) continue;
	    			if(a.length() < b.length() - 1) break;
	    			
	    			if(isAPredecessorOfB(a, b)) adjList.get(i).add(j);
	    		}
	    	}
	    	
	    	System.out.println(Arrays.toString(words));
	    	System.out.println(adjList);
	    	
	    	int rootLen = words[0].length();
	    	for(int i=0; i<words.length; i++) {
	    		if(words[i].length() == rootLen) recurs(adjList, words, i, 1);
	    		else break;
	    	}
	    	
	    	return max;
	    }
	    
	    private void recurs(List<List<Integer>> adjList, String[] words, int idx, int len) {
	    	if(len > max) max = len;
	    	
	    	for(int i=0; i<adjList.get(idx).size(); i++) {
	    		recurs(adjList, words, adjList.get(idx).get(i), len+1);
	    	}
	    }
	    
	    private boolean isAPredecessorOfB(String a, String b) {
	    	if(b.length() != a.length() + 1) return false;
	    	
	    	char[] achar = a.toCharArray();
	    	Arrays.sort(achar);
	    	char[] bchar = b.toCharArray();
	    	Arrays.sort(bchar);
	    
	    	boolean foundMisMatch = false;
	    	int i=0, j=0;
	    	while(i < achar.length) {
	    		if(achar[i] != bchar[j]) {
	    			if(foundMisMatch) return false;
	    			else {
	    				foundMisMatch = true;
	    				++j;
	    			}
	    		} else {
	    			++i;
	    			++j;
	    		}
	    	}
	    	
	    	return true;
	    }
	}
	
	public static void main(String[] args) {
		Solution solution = new _1048_Longest_String_Chain().new Solution();
		
		System.out.println(solution.longestStrChain(new String[]{"bda","bcap","a","b","bd","bca"}));
		System.out.println(solution.longestStrChain(new String[]{"bda","bdca","a","b","ba","bca"}));
	}
}
