package com.hashnet.leetcode.problemsetall;

public class Reverse_Integer {
    public int reverse(int x) {
        int result = 0;
        int max = Integer.MAX_VALUE / 10;
        int min = Integer.MIN_VALUE / 10;
        while (x != 0) {

            if (result < min || result > max)
                return 0;
            result = (result * 10) + (x % 10);

            x = x / 10;
        }

        return result;
    }

    public static void main(String[] args) {
        Reverse_Integer solution = new Reverse_Integer();

        System.out.println(solution.reverse(123));
        System.out.println(solution.reverse(-123));
        System.out.println(solution.reverse(120));
        System.out.println(solution.reverse(1534236469));
    }
}
