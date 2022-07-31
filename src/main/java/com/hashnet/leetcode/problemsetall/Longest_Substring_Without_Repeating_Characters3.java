package com.hashnet.leetcode.problemsetall;

import java.util.HashMap;
import java.util.Map;

public class Longest_Substring_Without_Repeating_Characters3 {
	public static void main(String[] args) {
		Longest_Substring_Without_Repeating_Characters3 s = new Longest_Substring_Without_Repeating_Characters3();
		
		String[] strs = {"abba", "abcabcbb", "bbbbb", "pwwkew"};
		for(String str : strs) {
			System.out.println(s.lengthOfLongestSubstring(str));
		}
	}
	
	public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        
        Map<Character, Integer> map = new HashMap<>();
        
        int maxLength = 0;
        int start = 0;
        for(int i=0; i<s.length(); i++) {
        	Character c = s.charAt(i);
        	
        	if(map.containsKey(c)) {
        		int newStart = map.get(c)+1;
        		
        		for(int j=start; j<newStart; j++) {
        			map.remove(s.charAt(j));
        		}
        		
        		start = newStart;
        	} else {
        		int length = i-start+1;
        		if(length > maxLength) maxLength = length;
        	}
        	
        	map.put(c, i);
        }
        
        return maxLength;
    }
}
