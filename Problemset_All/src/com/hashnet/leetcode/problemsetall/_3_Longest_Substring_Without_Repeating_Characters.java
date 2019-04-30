package com.hashnet.leetcode.problemsetall;

import java.util.HashMap;
import java.util.Map;

public class _3_Longest_Substring_Without_Repeating_Characters {
	public int lengthOfLongestSubstring(String s) {
		Map<Character, Integer> map = new HashMap<>();
		
		if(s == null) return 0;
		if(s.length() == 0) return 0;
		if(s.length() == 1) return 1;
		
		map.put(s.charAt(0), 0);
		int maxLen = 0;
		int index = 0;
		for(int i=1; i<s.length(); i++) {
			Integer foundAt = map.get(s.charAt(i));
			if(foundAt != null && foundAt >= index) {
				int len = i - index;
				if(len > maxLen) maxLen = len;
				
				index = foundAt + 1;
			}
			
			map.put(s.charAt(i), i);
		}
		
		int len = s.length() - index;
		if(len > maxLen) maxLen = len;
		
		return maxLen;
	}
	
	public static void main(String[] args) {
		_3_Longest_Substring_Without_Repeating_Characters solution = new _3_Longest_Substring_Without_Repeating_Characters();
		
		System.out.println(solution.lengthOfLongestSubstring("ohvhjdml"));
		System.out.println(solution.lengthOfLongestSubstring("abba"));
		System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
		System.out.println(solution.lengthOfLongestSubstring("bbbbb"));
		System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
		System.out.println(solution.lengthOfLongestSubstring("abcde"));
		System.out.println(solution.lengthOfLongestSubstring("a"));
		System.out.println(solution.lengthOfLongestSubstring(""));
	}
}
