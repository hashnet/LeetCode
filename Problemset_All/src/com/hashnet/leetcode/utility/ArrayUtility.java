package com.hashnet.leetcode.utility;

import java.util.Arrays;
import java.util.List;

public class ArrayUtility {
	public static int[] toIntArray(int... val) {
		return val;
	}

	public static int[] integerListToIntArray(List<Integer> list) {
		return list.stream()
				.mapToInt(Integer::intValue)
				.toArray();
	}
	
	public static String Int1DArrayToString(int[] arr) {
		return Arrays.toString(arr);
	}
	
	public static String Int2DArrayToString(int[][] arr) {
		StringBuilder sb = new StringBuilder("[");
		for(int i=0; i<arr.length; i++) {
			sb.append(Arrays.toString(arr[i]));
			
			if(i != arr.length-1) {
				sb.append(",\n");
			}
		}
		sb.append("]");
		
		return sb.toString();
	}
}
