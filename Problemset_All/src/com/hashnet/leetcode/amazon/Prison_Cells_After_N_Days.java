package com.hashnet.leetcode.amazon;

import com.hashnet.leetcode.utility.ArrayUtility;

public class Prison_Cells_After_N_Days {
	public int[] prisonAfterNDays(int[] cells, int N) {
		
	}
	
	private int nextState(int num) {
		return ((num << 1) ^ (num >> 1)) ^ 0;
	}
	
	private int arrayToInt(int[] arr) {
		int num = 0;
		for(int i=0; i<arr.length; i++) {
			num = num << 1;
			num |= arr[i];
		}
		
		return num;
	}
	
	private int[] intToArray(int num, int len) {
		int[] arr = new int[len];
		for(int i=len-1; i>=0; i--) {
			arr[i] = num & 1;
			num >>= 1;
		}
		
		return arr;
	}

	public static void main(String[] args) {
		Prison_Cells_After_N_Days solution = new Prison_Cells_After_N_Days();
		
		System.out.println(ArrayUtility.Int1DArrayToString(solution.prisonAfterNDays(ArrayUtility.toIntArray(0, 0, 1), 7)));
		System.out.println(ArrayUtility.Int1DArrayToString(solution.prisonAfterNDays(ArrayUtility.toIntArray(0,1,0,1,1,0,0,1), 7)));
	}
}
