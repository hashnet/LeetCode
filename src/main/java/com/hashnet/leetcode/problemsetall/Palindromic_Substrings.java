package com.hashnet.leetcode.problemsetall;

public class Palindromic_Substrings {
    public int countSubstrings(String s) {
        int len = s.length();
        boolean[][] table = new boolean[len][len];

        for (int i = 0; i < len; i++)
            table[i][i] = true;

        for (int i = 1; i < len; i++)
            table[i][i - 1] = true;

        int count = len;
        for (int span = 1; span < len; span++) {
            for (int i = 0; i < (len - span); i++) {
                int j = i + span;
                if (table[i + 1][j - 1] == true) {
                    if (s.charAt(i) == s.charAt(j)) {
                        ++count;
                        table[i][j] = true;
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Palindromic_Substrings solution = new Palindromic_Substrings();

        System.out.println(solution.countSubstrings("aaaaa"));
        System.out.println(solution.countSubstrings("abc"));
    }
}
