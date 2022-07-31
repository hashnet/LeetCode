package com.hashnet.leetcode.problemsetall;

public class Reverse_String_II {
    public String reverseStr(String s, int k) {
        char[] ca = s.toCharArray();
        for(int i=0; i<s.length(); i+=(2*k)) {
            if(i+k-1 >= s.length()) {
                reverse(ca, i, s.length()-1);
            } else {
                reverse(ca, i, i+k-1);
            }
        }

        return String.valueOf(ca);
    }

    private void reverse(char[] ca, int i, int j) {
        while(i<j) {
            char temp = ca[i];
            ca[i] = ca[j];
            ca[j] = temp;

            ++i;
            --j;
        }
    }

    public static void main(String[] args) {
        Reverse_String_II solution = new Reverse_String_II();
        System.out.println(solution.reverseStr("abcdefg", 2));
    }
}
