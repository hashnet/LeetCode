package com.hashnet.leetcode.problemsetall;

import com.hashnet.leetcode.utility.ArrayUtility;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Two_Sum2 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int complement = target - num;

            Integer index = map.get(complement);
            if (index != null) {
                int[] result = new int[2];
                result[0] = index;
                result[1] = i;

                return result;
            }

            map.put(num, i);
        }

        throw new IllegalArgumentException("No solution exists.");
    }

    public static void main(String[] args) {
        Two_Sum2 solution = new Two_Sum2();

        System.out.println(
                Arrays.toString(
                        solution.twoSum(ArrayUtility.toIntArray(2, 7, 11, 15), 9)));
    }
}
