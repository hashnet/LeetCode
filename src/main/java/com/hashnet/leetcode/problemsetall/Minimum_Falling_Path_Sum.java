package com.hashnet.leetcode.problemsetall;

public class Minimum_Falling_Path_Sum {
    public int minFallingPathSum(int[][] A) {
        int rCount = A.length;
        int cCount = A[0].length;

        for (int i = rCount - 2; i >= 0; i--) {
            for (int j = 0; j < cCount; j++) {
                int minVal = A[i + 1][j];
                if (j > 0) minVal = Math.min(minVal, A[i + 1][j - 1]);
                if (j < rCount - 1) minVal = Math.min(minVal, A[i + 1][j + 1]);

                A[i][j] += minVal;
            }
        }

        int min = Integer.MAX_VALUE;
        for (int j = 0; j < cCount; j++) {
            if (A[0][j] < min) min = A[0][j];
        }

        return min;
    }

    public static void main(String[] args) {

    }
}
