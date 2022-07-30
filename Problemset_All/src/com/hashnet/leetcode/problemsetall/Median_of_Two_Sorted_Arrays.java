package com.hashnet.leetcode.problemsetall;

import com.hashnet.leetcode.utility.ArrayUtility;

public class Median_of_Two_Sorted_Arrays {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if (nums1.length > nums2.length) {
			int[] temp = nums1;
			nums1 = nums2;
			nums2 = temp;
		}

		int len1 = nums1.length;
		int len2 = nums2.length;
		boolean even = (len1 + len2) % 2 == 0 ? true : false;

		int minI = 0;
		int maxI = nums1.length;
		int i, j;
		while (true) {
			// i represents cut in nums1 array while j represents cut in nums2 array.
			i = (minI + maxI) / 2; // mid of minI and maxI
			j = (len1 + len2 + 1) / 2 - i;

			if ((i - 1) >= 0 && j <= (len2 - 1)) {
				if (nums1[i - 1] > nums2[j]) {
					maxI = i - 1;
					continue;
				}
			}

			if (i <= (len1 - 1) && (j - 1) >= 0) {
				if (nums2[j - 1] > nums1[i]) {
					minI = i + 1;
					continue;
				}
			}

			break;	// found the median cut
		}

		int left = Integer.MIN_VALUE;
		if ((i - 1) >= 0 && nums1[i - 1] > left) {
			left = nums1[i - 1];
		}
		if ((j - 1) >= 0 && nums2[j - 1] > left) {
			left = nums2[j - 1];
		}
		if (!even)
			return left;

		int right = Integer.MAX_VALUE;
		if (i <= (len1 - 1) && nums1[i] < right) {
			right = nums1[i];
		}
		if (j <= (len2 - 1) && nums2[j] < right) {
			right = nums2[j];
		}

		return ((double) left + right) / 2;
	}

	public static void main(String args[]) {
		Median_of_Two_Sorted_Arrays solution = new Median_of_Two_Sorted_Arrays();

		int[] nums1;
		int[] nums2;

		nums1 = ArrayUtility.toIntArray(1, 3);
		nums2 = ArrayUtility.toIntArray(2);
		System.out.println(solution.findMedianSortedArrays(nums1, nums2));

		nums1 = ArrayUtility.toIntArray(1, 2);
		nums2 = ArrayUtility.toIntArray(3, 4);
		System.out.println(solution.findMedianSortedArrays(nums1, nums2));

		nums1 = ArrayUtility.toIntArray(2, 4, 7);
		nums2 = ArrayUtility.toIntArray(1, 3, 5, 6, 8);
		System.out.println(solution.findMedianSortedArrays(nums1, nums2));
	}
}
