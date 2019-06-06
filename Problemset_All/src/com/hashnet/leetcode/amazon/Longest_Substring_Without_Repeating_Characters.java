package com.hashnet.leetcode.amazon;

import java.util.HashMap;
import java.util.Map;

public class Longest_Substring_Without_Repeating_Characters {
	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0)
			return 0;

		Map<Character, Integer> map = new HashMap<>();

		int maxLen = Integer.MIN_VALUE;
		int start = 0;
		for (int i = 0; i < s.length(); i++) {
			Integer prevPos = map.get(s.charAt(i));

			if (prevPos != null && start < (prevPos + 1)) {
				start = prevPos + 1;
			}

			int len = i - start + 1;
			if (len > maxLen)
				maxLen = len;

			map.put(s.charAt(i), i);
		}

		return maxLen;
	}

	public static void main(String[] args) {
		Longest_Substring_Without_Repeating_Characters solution = new Longest_Substring_Without_Repeating_Characters();

		System.out.println(solution.lengthOfLongestSubstring("tmmzuxt"));
		System.out.println(solution.lengthOfLongestSubstring("abcdedcab"));
		System.out.println(solution.lengthOfLongestSubstring("abba"));
		System.out.println(solution.lengthOfLongestSubstring("aab"));
		System.out.println(solution.lengthOfLongestSubstring("a"));
		System.out.println(solution.lengthOfLongestSubstring("aa"));
		System.out.println(solution.lengthOfLongestSubstring("abca"));
		System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
	}
}
