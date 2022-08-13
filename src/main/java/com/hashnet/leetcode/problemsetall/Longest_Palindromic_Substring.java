package com.hashnet.leetcode.problemsetall;

public class Longest_Palindromic_Substring {
    public String longestPalindrome(String s) {
        if (s == null) return null;
        int len = s.length();
        if (len == 0) return "";
        if (len == 1) return s;

        boolean[][] table = new boolean[len][len];

        for (int i = 0; i < len; i++) table[i][i] = true;
        for (int i = 1; i < len; i++) table[i][i - 1] = true;

        int maxLen = 1;
        int maxIdx = 0;
        for (int step = 2; step <= len; step++) {
            for (int i = 0; i <= len - step; i++) {
                int j = i + step - 1;

                if (table[i + 1][j - 1] == true && s.charAt(i) == s.charAt(j)) {
                    table[i][j] = true;

                    if (step > maxLen) {
                        maxLen = step;
                        maxIdx = i;
                    }
                }
            }
        }

        return s.substring(maxIdx, maxIdx + maxLen);
    }

    public static void main(String[] args) {
        Longest_Palindromic_Substring solution = new Longest_Palindromic_Substring();

        System.out.println(solution.longestPalindrome("babad"));
        System.out.println(solution.longestPalindrome("cbbd"));
    }
}
