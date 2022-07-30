package com.hashnet.leetcode.problemsetall;

import com.hashnet.leetcode.utility.ArrayUtility;

public class Container_With_Most_Water2 {
	public int maxArea(int[] height) {
		int maxVolume = 0;
		
		int i = 0;
		int j = height.length - 1;
		while(j > i) {
			int volume = (j-i) * Math.min(height[i], height[j]);
			if(volume > maxVolume) maxVolume = volume;
			
			if(height[i] < height[j]) {
				i++;
			} else if(height[i] > height[j]) {
				j--;
			} else {
				i++;
				j--;
			}
		}
		
		return maxVolume;
	}

	public static void main(String[] args) {
		Container_With_Most_Water2 solution = new Container_With_Most_Water2();
		
		System.out.println(solution.maxArea(ArrayUtility.toIntArray(1,8,6,2,5,4,8,3,7)));
	}
}
