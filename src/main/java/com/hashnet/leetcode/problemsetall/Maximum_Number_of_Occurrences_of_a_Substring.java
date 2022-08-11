package com.hashnet.leetcode.problemsetall;

import java.util.HashMap;
import java.util.Map;

public class Maximum_Number_of_Occurrences_of_a_Substring {

    private static class LetterLedger {
        private Map<Character, Integer> charMap;

        public LetterLedger() {
            charMap = new HashMap<>();
        }

        public void addChar(char c) {
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }

        public void delChar(char c) {
            charMap.computeIfPresent(c, (k, v) -> v == 1 ? null : v - 1);
        }

        public int getLetterCount() {
            return charMap.keySet().size();
        }
    }

    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        if (s == null || s.length() == 0 || maxLetters == 0) return 0;

        int result = 0;
        Map<String, Integer> strMap = new HashMap<>();

        LetterLedger letterLedger = new LetterLedger();
        for (int i = 0; i < minSize - 1; i++) {
            letterLedger.addChar(s.charAt(i));
        }

        for (int i = 0; i <= s.length() - minSize; i++) {
            int j = i + minSize - 1;
            letterLedger.addChar(s.charAt(j));

            if (letterLedger.getLetterCount() <= maxLetters) {
                String subStr = s.substring(i, j + 1);
                int count = strMap.getOrDefault(subStr, 0) + 1;
                result = Math.max(result, count);
                strMap.put(subStr, count);
            }

            letterLedger.delChar(s.charAt(i));
        }

        return result;
    }

    public static void main(String[] args) {
        Maximum_Number_of_Occurrences_of_a_Substring solution = new Maximum_Number_of_Occurrences_of_a_Substring();

        System.out.println(solution.maxFreq("aababcaab", 2, 3, 4));
        System.out.println(solution.maxFreq("aaaa", 1, 3, 3));
    }
}
