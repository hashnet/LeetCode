package com.hashnet.leetcode.problemsetall;

import com.hashnet.leetcode.utility.ArrayUtility;

public class Kth_Largest_Element_in_an_Array {
    public int findKthLargest(int[] nums, int k) {
        --k;
        int lo = 0;
        int hi = nums.length - 1;
        while (true) {
            int p = partition(nums, lo, hi);

            if (p == k) return nums[p];
            else if (p > k) {
                hi = p - 1;
            } else {
                lo = p + 1;
                k = k - lo;
            }
        }
    }

    private int partition(int[] nums, int lo, int hi) {
        if (hi <= lo) return lo;

        int x = nums[lo];
        int i = lo;
        int j = hi + 1;
        while (true) {
            do {
                ++i;
                if (i > hi) break;
            } while (nums[i] > x);

            do {
                --j;
                if (j <= lo) break;
            } while (nums[j] <= x);

            if (i >= j) break;

            swap(nums, i, j);
        }

        swap(nums, lo, j);

        return j;
    }

    private void swap(int[] nums, int i, int j) {
        if (i == j) return;

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Kth_Largest_Element_in_an_Array solution = new Kth_Largest_Element_in_an_Array();

        System.out.println(solution.findKthLargest(ArrayUtility.toIntArray(3, 2, 1, 5, 6, 4), 2));
        System.out.println(solution.findKthLargest(ArrayUtility.toIntArray(3, 2, 3, 1, 2, 4, 5, 5, 6), 4));
    }
}
