package com.hashnet.leetcode.problemsetall;

import com.hashnet.leetcode.utility.ArrayUtility;

public class Longest_Increasing_Subsequence {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] lengths = new int[len];
        int globalMaxLen = 0;

        for (int i=0; i<len; i++) {
            int maxLen = 1;
            for (int j=0; j<i; j++) {
                if (nums[j] < nums[i]) {
                    maxLen = Math.max(maxLen, lengths[j] + 1);
                }
            }
            lengths[i] = maxLen;
            if(maxLen > globalMaxLen) {
                globalMaxLen = maxLen;
            }
        }

        return globalMaxLen;
    }

    public static void main(String[] args) {
        Longest_Increasing_Subsequence solution = new Longest_Increasing_Subsequence();

        System.out.println(solution.lengthOfLIS(ArrayUtility.toIntArray(10,9,2,5,3,7,101,18)));
        System.out.println(solution.lengthOfLIS(ArrayUtility.toIntArray(0,1,0,3,2,3)));
        System.out.println(solution.lengthOfLIS(ArrayUtility.toIntArray(7,7,7,7,7,7,7)));
    }
}
