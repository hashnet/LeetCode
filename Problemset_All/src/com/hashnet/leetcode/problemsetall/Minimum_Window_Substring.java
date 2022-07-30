package com.hashnet.leetcode.problemsetall;

import java.util.HashMap;
import java.util.Map;

public class Minimum_Window_Substring {
	public String minWindow(String s, String t) {
		Map<Character, Integer> tMap = new HashMap<>();
		for(int i=0; i<t.length(); i++) {
			tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
		}
		
		int resultMin = Integer.MAX_VALUE;
		int resultStart = -1;
		int resultEnd = -1;
        
        int required = tMap.size();
        Map<Character, Integer> rMap = new HashMap<>();
        int left = 0;
        int right = 0;
        int count = 0;
        
        while(right < s.length()) {
            char c = s.charAt(right);
            rMap.put(c, rMap.getOrDefault(c, 0) + 1);
            
            if(tMap.containsKey(c) && rMap.get(c) == tMap.get(c)) {
                ++count;
            }
            
            while(count == required) {
                int rMin = right - left + 1;
                if(rMin < resultMin) {
                    resultMin = rMin;
                    resultStart = left;
                    resultEnd = right;
                }
                
                c = s.charAt(left);
                rMap.put(c, rMap.get(c) - 1);
                if(tMap.containsKey(c) && rMap.get(c) < tMap.get(c)) {
                    --count;
                }
                
                ++left;
            }
            
            ++right;
        }
		
        if(resultMin == Integer.MAX_VALUE) {
            return "";
        } else {
            return s.substring(resultStart, resultEnd+1);
        }
    }
	
	public static void main(String[] args) {
		Minimum_Window_Substring solution = new Minimum_Window_Substring();
		
		System.out.println(solution.minWindow("ADOBECODEBANC", "ABC"));
	}
}
