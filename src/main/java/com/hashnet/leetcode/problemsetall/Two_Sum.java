package com.hashnet.leetcode.problemsetall;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Two_Sum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];

            Integer index = map.get(diff);
            if (index != null) {
                return new int[]{index, i};
            }

            map.put(nums[i], i);
        }

        return null;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 5};
        int target = 9;

        Two_Sum solution = new Two_Sum();
        System.out.println(Arrays.toString(solution.twoSum(nums, target)));
    }
}
