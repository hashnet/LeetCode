package com.hashnet.leetcode.problemsetall;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _166_Fraction_to_Recurring_Decimal {
	/*private class Pair {
		int val;
		int idx;
		
		public Pair(int val, int idx) {
			this.val = val;
			this.idx = idx;
		}
	}
	
	*/
	public String fractionToDecimal(int numerator, int denominator) {
		if(numerator % denominator == 0) return String.valueOf(numerator / denominator);
		
		StringBuilder sb = new StringBuilder();
        sb.append(numerator / denominator);
        sb.append(".");

        int rem = numerator % denominator;
        
        Integer startRepIdx = null;
        int idx = 0;
        Map<Integer, Integer> table = new HashMap<>();
        List<Integer> digits = new ArrayList<>();
        while(true) {
        	startRepIdx = table.get(rem);
        	if(startRepIdx != null) break;
        	table.put(rem, idx);
        	
        	rem *= 10;
        	while(rem < denominator) {
        		digits.add(0);
        		++idx;
        		
        		rem *= 10;
        	}
        	
        	        	
        	digits.add(rem / denominator);
        	if(rem % denominator == 0) break;
        	rem %= denominator;
        	
        	++idx;
        }
        
        for(int i=0; i<digits.size(); i++) {
        	if(startRepIdx != null && startRepIdx == i) {
        		sb.append("(");
        	}
        	sb.append(digits.get(i));
        }
        
        if(startRepIdx != null) sb.append(")");
        
        return sb.toString();
    }
	
	public static void main(String[] args) {
		_166_Fraction_to_Recurring_Decimal solution = new _166_Fraction_to_Recurring_Decimal();
		
		System.out.println(solution.fractionToDecimal(1, 2));
		System.out.println(solution.fractionToDecimal(2, 1));
		System.out.println(solution.fractionToDecimal(2, 3));
		System.out.println(solution.fractionToDecimal(22, 7));
		System.out.println(solution.fractionToDecimal(7, 12));
		System.out.println(solution.fractionToDecimal(4, 333));	
	}
}
