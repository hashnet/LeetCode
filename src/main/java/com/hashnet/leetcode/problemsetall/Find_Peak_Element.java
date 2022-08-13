package com.hashnet.leetcode.problemsetall;

public class Find_Peak_Element {
    public static void main(String[] args) {
        Find_Peak_Element s = new Find_Peak_Element();

        System.out.println(s.findPeakElement(new int[]{1}));
        System.out.println(s.findPeakElement(new int[]{1, 2, 3, 1}));
        System.out.println(s.findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4}));
    }

    public int findPeakElement(int[] nums) {
        if (nums.length == 1) return 0;

        return search(nums, 0, nums.length - 1);
    }

    private int search(int[] nums, int lo, int hi) {
        int mid = (lo + hi) / 2;

        if (isPeak(nums, mid)) return mid;

        if (lo < mid && nums[mid - 1] > nums[mid]) return search(nums, lo, mid - 1);
        else if (mid < hi && nums[mid] < nums[mid + 1]) return search(nums, mid + 1, hi);

        return -1;
    }

    private boolean isPeak(int[] nums, int i) {
        if (i == 0) {
            if (nums[i] > nums[i + 1]) return true;
        } else if (i == nums.length - 1) {
            if (nums[i - 1] < nums[i]) return true;
        } else {
            if (nums[i - 1] < nums[i] && nums[i] > nums[i + 1]) return true;
        }

        return false;
    }
}
