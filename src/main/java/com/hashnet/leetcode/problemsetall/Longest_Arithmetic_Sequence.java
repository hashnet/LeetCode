package com.hashnet.leetcode.problemsetall;

import com.hashnet.leetcode.utility.ArrayUtility;

public class Longest_Arithmetic_Sequence {
    class Solution {
        private static final int MAX = 10000;

        public int longestArithSeqLength(int[] A) {
            int total = 1;
            if (A.length == 0) return 0;

            int[][] posArray = new int[A.length][MAX + 1];
            int[][] negArray = new int[A.length][MAX + 1];

            for (int i = 1; i < A.length; i++) {
                for (int j = 0; j < i; j++) {
                    int d = A[i] - A[j];

                    if (d >= 0) {
                        posArray[i][d] = Math.max(posArray[i][d], posArray[j][d] + 1);

                        if (posArray[i][d] + 1 > total) total = posArray[i][d] + 1;
                    } else {
                        d = -d;
                        negArray[i][d] = Math.max(negArray[i][d], negArray[j][d] + 1);

                        if (negArray[i][d] + 1 > total) total = negArray[i][d] + 1;
                    }
                }
            }

            return total;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Longest_Arithmetic_Sequence().new Solution();

        System.out.println(solution.longestArithSeqLength(ArrayUtility.toIntArray(3, 6, 9, 12)));
        System.out.println(solution.longestArithSeqLength(ArrayUtility.toIntArray(9, 4, 7, 2, 10)));
        System.out.println(solution.longestArithSeqLength(ArrayUtility.toIntArray(20, 1, 15, 3, 10, 5, 8)));
    }
}
