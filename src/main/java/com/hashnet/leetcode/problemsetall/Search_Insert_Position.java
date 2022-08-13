package com.hashnet.leetcode.problemsetall;

import com.hashnet.leetcode.utility.ArrayUtility;

public class Search_Insert_Position {

    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int k = left + (right - left) / 2;
            int curr = nums[k];
            if (target == curr) {
                return k;
            }

            if (target < curr) {
                right = k - 1;
            } else {
                left = k + 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        Search_Insert_Position solution = new Search_Insert_Position();

        System.out.println(solution.searchInsert(ArrayUtility.toIntArray(1, 3, 5, 6), 5));
        System.out.println(solution.searchInsert(ArrayUtility.toIntArray(1, 3, 5, 6), 2));
        System.out.println(solution.searchInsert(ArrayUtility.toIntArray(1, 3, 5, 6), 7));
    }
}
