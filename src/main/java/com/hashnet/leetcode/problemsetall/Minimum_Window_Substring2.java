package com.hashnet.leetcode.problemsetall;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Minimum_Window_Substring2 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        Set<Character> tSet = tMap.keySet();

        int min = Integer.MAX_VALUE;
        int start = -1;
        int end = -1;

        Map<Character, Integer> rMap = new HashMap<>();
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            if (!tSet.contains(s.charAt(j))) {
                continue;
            }

            rMap.put(s.charAt(j), rMap.getOrDefault(s.charAt(j), 0) + 1);

            while (i < s.length()) {
                if (!tSet.contains(s.charAt(i))) {
                    ++i;
                    continue;
                }

                if (rMap.get(s.charAt(i)) > tMap.get(s.charAt(i))) {
                    rMap.put(s.charAt(i), rMap.get(s.charAt(i)) - 1);
                    ++i;
                } else {
                    break;
                }
            }

            if (matchFound(rMap, tMap)) {
                int rMin = j - i + 1;
                if (rMin < min) {
                    min = rMin;
                    start = i;
                    end = j;
                }
            }
        }

        if (min == Integer.MAX_VALUE) return "";
        else return s.substring(start, end + 1);
    }

    private boolean matchFound(Map<Character, Integer> orig, Map<Character, Integer> goal) {
        for (char c : goal.keySet()) {
            Integer count = orig.get(c);

            if (count == null) return false;
            else if (count < goal.get(c)) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Minimum_Window_Substring2 solution = new Minimum_Window_Substring2();

        System.out.println(solution.minWindow("BBA", "AB"));
        System.out.println(solution.minWindow("A", "AA"));
        System.out.println(solution.minWindow("ADOBECODEBANC", "CBA"));
    }
}
