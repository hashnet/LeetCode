package com.hashnet.leetcode.utility;

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
}
