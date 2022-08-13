package com.hashnet.leetcode.problemsetall;

public class Paint_Fence {
    class Solution {
        public int numWays(int n, int k) {
            if (n == 0 || k == 0) return 0;

            int combinations = k;
            int pairs = 0;
            for (int i = 2; i <= n; i++) {
                int prev = pairs;
                pairs = combinations - pairs;
                combinations = (pairs * k) + (prev * (k - 1));
            }

            return combinations;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Paint_Fence().new Solution();

        System.out.println(solution.numWays(3, 2));
        System.out.println(solution.numWays(3, 1));
        System.out.println(solution.numWays(2, 1));
        System.out.println(solution.numWays(5, 2));
        System.out.println(solution.numWays(3, 3));
    }
}
