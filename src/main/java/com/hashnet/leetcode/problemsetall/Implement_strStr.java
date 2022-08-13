package com.hashnet.leetcode.problemsetall;

public class Implement_strStr {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) throw new IllegalArgumentException();

        if (needle.equals("")) return 0;

        for (int i = 0; i <= (haystack.length() - needle.length()); i++) {
            boolean found = true;
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    found = false;
                    break;
                }
            }

            if (found) return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        Implement_strStr solution = new Implement_strStr();

        System.out.println(solution.strStr("hello", "ll"));
        System.out.println(solution.strStr("mississippi", "mississippi"));
        System.out.println(solution.strStr("aaaa", "ab"));
        System.out.println(solution.strStr("a", "a"));
    }
}
