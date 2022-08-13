package com.hashnet.leetcode.problemsetall;

public class House_Robber {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        else if (nums.length == 1) return nums[0];

        int[] max = new int[nums.length];
        max[0] = nums[0];
        max[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            max[i] = Math.max(nums[i] + max[i - 2], Math.max(max[i - 1], max[i - 2]));
        }

        return Math.max(max[nums.length - 1], max[nums.length - 2]);
    }
}
