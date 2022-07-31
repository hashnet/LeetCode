package com.hashnet.leetcode.problemsetall;

import com.hashnet.leetcode.utility.ArrayUtility;

public class Best_Time_to_Buy_and_Sell_Stock {
	public int maxProfit(int[] prices) {
		int result = 0;
		
		int minPrice = Integer.MAX_VALUE;
		int prev = Integer.MAX_VALUE;
		for(int i = 0; i<prices.length; i++) {
			if(prices[i] > prev) {
				if(prev < minPrice) minPrice = prev;
			}
			
			if(prices[i] > minPrice) {
				int diff = prices[i] - minPrice;
				if(diff > result) result = diff;
			}
			
			prev = prices[i];
		}
		
		return result;
	}

	public static void main(String[] args) {
		Best_Time_to_Buy_and_Sell_Stock solution = new Best_Time_to_Buy_and_Sell_Stock();
		
		System.out.println(solution.maxProfit(ArrayUtility.toIntArray(7,1,5,3,6,4)));
		System.out.println(solution.maxProfit(ArrayUtility.toIntArray(7,6,4,3,1)));
	}
}
