package com.hashnet.leetcode.amazon;

import com.hashnet.leetcode.utility.ArrayUtility;

public class Trapping_Rain_Water {
	public int trap(int[] height) {
		int len = height.length;
		if(len == 0) return 0;
		
		int[] left = new int[len];
		left[0] = 0;
		for(int i=1; i<len; i++) left[i] = Math.max(left[i-1], height[i-1]);
		
		int[] right = new int[len];
		right[len-1] = 0;
		for(int i=len-2; i>=0; i--) right[i] = Math.max(right[i+1], height[i+1]);
		
		int result = 0;
		for(int i=0; i<len; i++) {
			int wall = Math.min(left[i], right[i]);
			if(height[i] < wall) result += (wall - height[i]);
		}
		
		return result;
	}

	public static void main(String[] args) {
		Trapping_Rain_Water solution = new Trapping_Rain_Water();
		
		System.out.println(solution.trap(ArrayUtility.toIntArray(0,1,0,2,1,0,1,3,2,1,2,1)));
	}
}
