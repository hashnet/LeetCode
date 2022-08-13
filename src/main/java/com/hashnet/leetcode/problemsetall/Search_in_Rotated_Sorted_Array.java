package com.hashnet.leetcode.problemsetall;

public class Search_in_Rotated_Sorted_Array {
    public static void main(String[] args) {
        Search_in_Rotated_Sorted_Array s = new Search_in_Rotated_Sorted_Array();

        System.out.println(s.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(s.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
    }

    public int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) return mid;

            if (nums[lo] <= nums[mid]) {
                if (nums[lo] <= target && target < nums[mid]) {
                    hi = mid - 1;
                } else lo = mid + 1;
            } else {
                if (nums[mid] < target && target <= nums[hi]) {
                    lo = mid + 1;
                } else hi = mid - 1;
            }
        }

        return -1;
    }
}
