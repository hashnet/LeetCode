package com.hashnet.leetcode.problemsetall;

import java.util.HashMap;
import java.util.Map;

public class Contiguous_Array {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        int max = 0;
        int count = 0;
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) --count;
            else ++count;

            if (map.containsKey(count)) {
                max = Math.max(max, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Contiguous_Array solution = new Contiguous_Array();

        System.out.println(solution.findMaxLength(new int[]{0, 0, 1, 0, 0, 0, 1, 1}));
    }
}
