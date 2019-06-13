package com.hashnet.leetcode.amazon;

import java.util.Arrays;

import com.hashnet.leetcode.utility.ArrayUtility;

public class _3Sum_Closest {
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		
		int min = Integer.MAX_VALUE;
		int closest = 0;
		for(int i=0; i<nums.length-2; i++) {
			int start = i+1;
			int end = nums.length-1;
			
			int req = target - nums[i];
			while(start < end) {
				int sum = nums[start] + nums[end];
				int total = sum + nums[i];
				int diff = Math.abs(target - total);
				if(diff < min) {
					min = diff;
					closest = total;
				}
				
				if(sum > req) {
					--end;
				} else if(sum < req) {
					++start;
				} else {
					return target;
				}
			}
		}
		
		return closest;
	}

	public static void main(String[] args) {
		_3Sum_Closest solution = new _3Sum_Closest();
		
		System.out.println(solution.threeSumClosest(ArrayUtility.toIntArray(-1, 2, 1, -4), 1));
	}
}
