package com.hashnet.leetcode.amazon;

import java.util.HashMap;
import java.util.Map;

import com.hashnet.leetcode.utility.ArrayUtility;

public class Prison_Cells_After_N_Days {
	public int[] prisonAfterNDays(int[] cells, int N) {
		int num = arrayToInt(cells);
		
		int mask = getMask(cells.length);
		
		Map<Integer, Integer> table = new HashMap<>();
		table.put(num, 0);
		for(int i=1; i<=N; i++) {
			num = nextState(num, mask);
			
			if(table.containsKey(num)) {
				int idx = table.get(num);
				int mod = i - idx;
				
				int rem = (N - idx) % mod;
				for(int j=1; j<=rem; j++) {
					num = nextState(num, mask);
				}
				break;
			}
			
			table.put(num, i);
		}
		
		return intToArray(num, cells.length);
	}
	
	private int nextState(int num, int mask) {
		num = ~((num << 1) ^ (num >> 1));
		num &= mask;
		
		return num;
	}
	
	private int getMask(int len) {
		int num = 0;
		for(int i=1; i<=len-2; i++) {
			num = num | 1;
			num = num << 1;
		}
		
		return num;
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
		
		//System.out.println(ArrayUtility.Int1DArrayToString(solution.prisonAfterNDays(ArrayUtility.toIntArray(0, 1, 1, 0), 7)));
		//System.out.println(ArrayUtility.Int1DArrayToString(solution.prisonAfterNDays(ArrayUtility.toIntArray(0, 0, 1), 7)));
		//System.out.println(ArrayUtility.Int1DArrayToString(solution.prisonAfterNDays(ArrayUtility.toIntArray(0,1,0,1,1,0,0,1), 7)));
		System.out.println(ArrayUtility.Int1DArrayToString(solution.prisonAfterNDays(ArrayUtility.toIntArray(1,0,0,1,0,0,1,0), 1000000000)));
	}
}
