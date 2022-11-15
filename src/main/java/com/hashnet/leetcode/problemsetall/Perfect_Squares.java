package com.hashnet.leetcode.problemsetall;

import java.util.Arrays;

public class Perfect_Squares {
    public int numSquares(int n) {
        int[] count = new int[n+1];
        for(int i=1; i<=n; i++) {
            count[i] = count[i-1] + 1;
        }

        for(int i=2; i*i<=n; i++) {
            int square = i*i;
            for(int j=square; j<=n; j++) {
                count[j] = Math.min(count[j], count[j-square]+1);
            }
        }

        return count[n];
    }

    public static void main(String[] args) {
        Perfect_Squares solution = new Perfect_Squares();

        System.out.println(solution.numSquares(12));
        System.out.println(solution.numSquares(13));
        System.out.println(solution.numSquares((int)10e4));
    }
}
