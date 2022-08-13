package com.hashnet.leetcode.problemsetall;

public class Palindrome_Number {
    public boolean isPalindrome(int x) {
        int orig = x;
        if (x < 0) return false;

        int reverted = 0;
        while (x > 0) {
            reverted = (reverted * 10) + (x % 10);
            x /= 10;
        }

        return (orig == reverted) ? true : false;
    }

    public static void main(String[] args) {
        Palindrome_Number solution = new Palindrome_Number();

        System.out.println(solution.isPalindrome(121));
        System.out.println(solution.isPalindrome(-121));
        System.out.println(solution.isPalindrome(10));
    }
}
