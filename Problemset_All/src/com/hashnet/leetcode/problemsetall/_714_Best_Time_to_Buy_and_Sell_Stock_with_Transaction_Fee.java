package com.hashnet.leetcode.problemsetall;

import com.hashnet.leetcode.utility.ArrayUtility;

public class _714_Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee {
	class Solution {
	    public int maxProfit(int[] prices, int fee) {
	        if(prices.length == 0) return 0;
	        
	        int total = 0;
	        int min = prices[0];
	        int max = prices[0];
	        
	        for(int i=1; i<prices.length; i++) {
	        	if(prices[i] < max - fee) {
	        		int d = max - min - fee;
	        		if(d > 0) total += d;
	        		
	        		min = prices[i];
	        		max = prices[i];
	        	} else {
	        		if(prices[i] > max) max = prices[i];
	        		if(prices[i] < min) min = prices[i];
	        	}
	        }
	        
	        int d = max - min - fee;
	        if(d > 0) total += d;
	        
	        return total;
	    }
	}
	
	public static void main(String[] args) {
		Solution solution = new _714_Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee().new Solution();
		
		System.out.println(solution.maxProfit(ArrayUtility.toIntArray(1, 3, 2, 8, 4, 9), 2));
	}
}
