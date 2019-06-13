package com.hashnet.leetcode.amazon;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Most_Common_Word {
	public String mostCommonWord(String paragraph, String[] banned) {
		Set<String> bannedSet = new HashSet<>();
		for(int i=0; i<banned.length; i++) bannedSet.add(banned[i]);
		
		Map<String, Integer> counter = new HashMap<>();
		String[] words = paragraph.split("[ !?',;\\.]");
		for(String word : words) {
			if(word.equals("")) continue;
			if(bannedSet.contains(word)) continue;
			
			word = word.toLowerCase();
			counter.put(word, counter.getOrDefault(word, 0)+1);
		}
		
		int max = Integer.MIN_VALUE;
		String maxString = "";
		for(String word : counter.keySet()) {
			int count = counter.get(word);
			
			if(count > max) {
				max = count;
				maxString = word;
			}
		}
		
		return maxString;
	}

	public static void main(String[] args) {
		Most_Common_Word solution = new Most_Common_Word();
		
		String[] banned = {"banned"};
		System.out.println(solution.mostCommonWord("as Asdf. sdf, asdf? sdf", banned));
	}
}
