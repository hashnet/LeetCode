package com.hashnet.leetcode.problemsetall;

public class Range_Sum_Query_Immutable {
	public class NumArray {
		int[] sums;
	    public NumArray(int[] nums) {
	        sums = new int[nums.length + 1];
	        
	        sums[0] = 0;
	        for(int i=0; i<nums.length; i++) {
	        	sums[i+1] = nums[i] + sums[i];
	        }
	    }
	    
	    public int sumRange(int i, int j) {
	        return sums[j+1] - sums[i];
	    }
	}
	
	public static void main(String[] args) {
		NumArray nm = new Range_Sum_Query_Immutable()
				.new NumArray(new int[] {-2, 0, 3, -5, 2, -1});
		
		System.out.println(nm.sumRange(0, 2));
		System.out.println(nm.sumRange(2, 5));
		System.out.println(nm.sumRange(0, 5));
	}
}
