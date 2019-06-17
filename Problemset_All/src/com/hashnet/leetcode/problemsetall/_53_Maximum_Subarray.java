package com.hashnet.leetcode.problemsetall;

import com.hashnet.leetcode.utility.ArrayUtility;

public class _53_Maximum_Subarray {
	public int maxSubArray(int[] nums) {
		int result = nums[0];
		
		for(int i=1; i<nums.length; i++) {
			if(nums[i-1] > 0)  nums[i] += nums[i-1];
			
			if(nums[i] > result) result = nums[i];
		}
		
		return result;
    }
	
	public static void main(String[] args) {
		_53_Maximum_Subarray solution = new _53_Maximum_Subarray();
		
		System.out.println(solution.maxSubArray(ArrayUtility.toIntArray(-2, 1)));
		System.out.println(solution.maxSubArray(ArrayUtility.toIntArray(2,1,-3,4,-1,2,1,-5,4)));
	}
}
