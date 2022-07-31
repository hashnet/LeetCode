package com.hashnet.leetcode.problemsetall;

import java.util.ArrayList;
import java.util.List;

import com.hashnet.leetcode.utility.ArrayUtility;

public class Missing_Ranges {
	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
		List<String> result = new ArrayList<>();
		
		if(nums.length == 0) {
			result.add(getRangeRepr(lower, upper));
			return result;
		}
		
		long start = lower;
		for(long i : nums) {
			long end = Math.min(upper, i-1);
			
			if(start <= end) {
				result.add(getRangeRepr(start, end));
			}
			
			start = Math.max(i+1, lower);
		}
		
		if(start <= upper) result.add(getRangeRepr(start, upper));
		
		return result;
	}
	
	private String getRangeRepr(long lo, long hi) {
		if(lo == hi) return String.valueOf(lo);
		else return String.valueOf(lo) + "->" + String.valueOf(hi);
	}

	public static void main(String[] args) {
		Missing_Ranges solution = new Missing_Ranges();
		
		System.out.println(solution.findMissingRanges(ArrayUtility.toIntArray(2147483647), 0, 2147483647));
		System.out.println(solution.findMissingRanges(ArrayUtility.toIntArray(-1), -1, 0));
		System.out.println(solution.findMissingRanges(ArrayUtility.toIntArray(0, 1, 3, 50, 75), 0, 99));
		System.out.println(solution.findMissingRanges(ArrayUtility.toIntArray(0, 1, 3, 50, 75), 50, 50));
		System.out.println(solution.findMissingRanges(ArrayUtility.toIntArray(0, 1, 3, 50, 75), 5, 10));
		System.out.println(solution.findMissingRanges(ArrayUtility.toIntArray(0, 1, 3, 50, 75), 80, 99));
	}
}
