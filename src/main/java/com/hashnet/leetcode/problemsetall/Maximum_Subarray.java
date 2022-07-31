package com.hashnet.leetcode.problemsetall;

import com.hashnet.leetcode.utility.ArrayUtility;

public class Maximum_Subarray {
	public int maxSubArray(int[] nums) {
		int result = nums[0];

		int sum = result;
		for(int i=1; i<nums.length; i++) {
			if(sum <= 0) {
				sum = nums[i];
			} else {
				sum += nums[i];
			}

			result = Math.max(result, sum);
		}
		
		return result;
    }
	
	public static void main(String[] args) {
		Maximum_Subarray solution = new Maximum_Subarray();

		System.out.println(solution.maxSubArray(ArrayUtility.toIntArray(-2, 1)));
		System.out.println(solution.maxSubArray(ArrayUtility.toIntArray(2,1,-3,4,-1,2,1,-5,4)));
		System.out.println(solution.maxSubArray(ArrayUtility.toIntArray(-2, -3)));
		System.out.println(solution.maxSubArray(ArrayUtility.toIntArray(-3, -2)));
	}
}
