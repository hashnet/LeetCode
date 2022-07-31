package com.hashnet.leetcode.utility;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayUtility {
	public static int[] toIntArray(int... val) {
		return val;
	}

	public static int[] integerListToIntArray(List<Integer> list) {
		return list.stream()
				.mapToInt(Integer::intValue)
				.toArray();
	}
	
	private static String int1DArrayToString(int[] arr, int len) {
		StringBuilder sb = new StringBuilder("[");
		String format = "%" + (len+1) + "d";
		if(arr.length > 0) sb.append(String.format(String.valueOf(format), arr[0]));
		for(int i=1; i<arr.length; i++) {
			sb.append(String.format("," + format, arr[i]));
		}
		sb.append("]");
		
		return sb.toString();
	}
	
	public static String int1DArrayToString(int[] arr) {
		int max = 0;
		int min = 0;
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i] > max) max = arr[i];
			if(arr[i] < min) min = arr[i];
		}
		
		int len = Math.max(String.valueOf(min).length(), String.valueOf(max).length());
		
		return int1DArrayToString(arr, len);
	}
	
	public static String int2DArrayToString(int[][] arr) {
		int max = 0;
		int min = 0;
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				if(arr[i][j] > max) max = arr[i][j];
				if(arr[i][j] < min) min = arr[i][j];
			}
		}
		
		int len = Math.max(String.valueOf(min).length(), String.valueOf(max).length());
		
		StringBuilder sb = new StringBuilder("[");
		for(int i=0; i<arr.length; i++) {
			if(i > 0) sb.append(" ");
			
			sb.append(int1DArrayToString(arr[i], len));
			
			if(i != arr.length-1) {
				sb.append(",\n");
			}
		}
		sb.append("]");
		
		return sb.toString();
	}

	public static List<List<Integer>> int2DArrauyToList(int [][] arr) {
		List<List<Integer>> result = new ArrayList<>();

		if(arr.length == 0) {
			result.add(new ArrayList<>());
			return result;
		}

		for(int i=0; i<arr.length; i++) {
			List<Integer> row = Arrays.stream(arr[i]).boxed().collect(Collectors.toList());
			result.add(row);
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(ArrayUtility.int1DArrayToString(ArrayUtility.toIntArray()));
		System.out.println(ArrayUtility.int1DArrayToString(ArrayUtility.toIntArray(1, 2, 3)));
		System.out.println(ArrayUtility.int1DArrayToString(ArrayUtility.toIntArray(1, 2, 333)));
		System.out.println(ArrayUtility.int1DArrayToString(ArrayUtility.toIntArray(1, -222, 333)));
		
		int[][] testArr = {{1, 2, 3}, {1, -222, 3}, {1, 2, 333}};
		System.out.println(ArrayUtility.int2DArrayToString(testArr));
		System.out.println(ArrayUtility.int2DArrauyToList(testArr));
		
		System.out.println(ArrayUtility.int1DArrayToString(ArrayUtility.integerListToIntArray(Arrays.asList(1, -222, 3))));		
	}
}
