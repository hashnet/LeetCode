package com.hashnet.leetcode.problemsetall;

import com.hashnet.leetcode.utility.ArrayUtility;

public class Missing_Number {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        int tot = (len * (len + 1)) / 2;

        int sum = 0;
        for (int i = 0; i < len; i++) sum += nums[i];

        return tot - sum;
    }

    public static void main(String[] args) {
        Missing_Number solution = new Missing_Number();

        System.out.println(solution.missingNumber(ArrayUtility.toIntArray(9, 6, 4, 2, 3, 5, 7, 0, 1)));
    }
}
