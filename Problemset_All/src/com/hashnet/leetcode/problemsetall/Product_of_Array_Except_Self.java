package com.hashnet.leetcode.problemsetall;

import java.util.Arrays;

import com.hashnet.leetcode.utility.ArrayUtility;

public class Product_of_Array_Except_Self {
	public int[] productExceptSelf(int[] nums) {
		int[] result = new int[nums.length];
		result[0] = 1;
		for(int i=1; i<nums.length; i++) {
			result[i] = result[i-1] * nums[i-1];
		}
		
		int r = 1;
		for(int i=nums.length-1; i>=0; i--) {
			result[i] = result[i] * r;
			r *= nums[i];
		}
		
		return result;
	}

	public static void main(String[] args) {
		Product_of_Array_Except_Self solution = new Product_of_Array_Except_Self();
		
		System.out.println(Arrays.toString(solution.productExceptSelf(ArrayUtility.toIntArray(1,2,3,4))));
	}
}
