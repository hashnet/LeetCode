package com.hashnet.leetcode.problemsetall;
import com.hashnet.leetcode.utility.ArrayUtility;

public class Trapping_Rain_Water {
	public int trap(int[] height) {
		int[] rMax = new int[height.length];
		int max = 0;
		for(int i= height.length-1; i>=0; i--) {
			rMax[i] = max;
			if(height[i] > max) max = height[i];
		}
		
		int h;
		int sum=0;
		max = 0;
		for(int i=0; i<height.length; i++) {
			h = Integer.min(max, rMax[i]);
			if(height[i] < h) sum += (h - height[i]);
			if(height[i] > max) max = height[i];
		}
		
		return sum;
	}

	public static void main(String[] args) {
		Trapping_Rain_Water solution = new Trapping_Rain_Water();
		
		System.out.println(solution.trap(ArrayUtility.toIntArray(0,1,0,2,1,0,1,3,2,1,2,1)));
	}
}
