package com.hashnet.leetcode.problemsetall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.hashnet.leetcode.utility.ArrayUtility;

public class _3Sum {
	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		
		List<List<Integer>> results = new ArrayList<>();
		
		for(int i=0; i<nums.length-2; i++) {
			if(i>0 && (nums[i] == nums[i-1])) continue;
			int target = -nums[i];
			
			int start = i+1;
			int end = nums.length-1;
			
			while(start < end) {
				int sum = nums[start] + nums[end];
				if(sum > target) {
					--end;
				} else if(sum < target) {
					++start;
				} else {
					results.add(Arrays.asList(nums[i], nums[start], nums[end]));
					
					++start;
					while(start < end && nums[start] == nums[start-1]) ++start;
						
					--end;
					while(start < end && nums[end] == nums[end+1]) --end;
				}
			}
		}
		
		return results;
	}
	
	public static void main(String[] args) {
		_3Sum solution = new _3Sum();
		

		System.out.println(solution.threeSum(ArrayUtility.toIntArray(0, 0, -1, 1, 1)));
		System.out.println(solution.threeSum(ArrayUtility.toIntArray(-1, 0, -1, 1, 1)));
		System.out.println(solution.threeSum(ArrayUtility.toIntArray(-1, 0, 1, 2, -1, -4)));
		System.out.println(solution.threeSum(ArrayUtility.toIntArray(0, 0, 0, 0)));
	}
}
