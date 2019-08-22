package com.hashnet.leetcode.problemsetall;

import com.hashnet.leetcode.utility.ArrayUtility;

public class _338_Counting_Bits {
	public int[] countBits(int num) {
		int result[] = new int[num+1];
		result[0] = 0;
		
		int ceil = 1;
		for(int i=1; i<=num; i++) {
			if(i == ceil) {
				result[i] = 1;
				ceil *= 2;
			} else {
				result[i] = 1 + result[i - (ceil/2)];
			}
		}
		
		return result;
	}

	public static void main(String[] args) {
		_338_Counting_Bits solution = new _338_Counting_Bits();
		
		System.out.println(ArrayUtility.int1DArrayToString(solution.countBits(10)));
	}
}
