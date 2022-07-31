package com.hashnet.leetcode.problemsetall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Group_Anagrams2 {
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> res = new ArrayList<>();
		Map<String, List<String>> map = new HashMap<>();
		
		for(int i=0; i<strs.length; i++) {
			char[] chars = strs[i].toCharArray();
			Arrays.sort(chars);
			String str = String.valueOf(chars);
			
			List<String> existingList = map.get(str);
			if(existingList == null) {
				List<String> newList = new ArrayList<>();
				newList.add(strs[i]);
				
				map.put(str, newList);
				res.add(newList);
			} else {
				existingList.add(strs[i]);
			}
		}
		
		return res;
	}

	public static void main(String[] args) {
		String[] strs = {"eat", "tea", "tan", "taan", "ate", "nat", "bat"};
		Group_Anagrams2 solution = new Group_Anagrams2();
		
		System.out.println(solution.groupAnagrams(strs));
	}
}
