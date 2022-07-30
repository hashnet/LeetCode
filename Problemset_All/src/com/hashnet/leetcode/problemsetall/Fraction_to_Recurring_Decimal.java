package com.hashnet.leetcode.problemsetall;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Fraction_to_Recurring_Decimal {
	public String fractionToDecimal(int numerator, int denominator) {
		long num = numerator;
		long denom = denominator;
		if(num % denom == 0) return String.valueOf(num / denom);
		
		boolean sign = (num >= 0 && denom >= 0) || (num < 0 && denom < 0);
		num = Math.abs(num);
		denom = Math.abs(denom);
		
		StringBuilder sb = new StringBuilder();
		sb.append(!sign ? "-" : "");
        sb.append(num / denom);
        sb.append(".");

        long rem = num % denom;
        
        Integer startRepIdx = null;
        Map<Long, Integer> table = new HashMap<>();
        
        List<Long> digits = new ArrayList<>();
        int idx = 0;
        
        rem *= 10;
        while(true) {
        	startRepIdx = table.get(rem);
        	if(startRepIdx != null) break;
        	table.put(rem, idx);
        	
        	while(rem < denom) {
        		digits.add(0L);
        		++idx;
        		
        		rem *= 10;
        		table.put(rem,  idx);
        	}
        	
        	        	
        	digits.add(rem / denom);
        	++idx;
        	
        	if(rem % denom == 0) break;
        	rem %= denom;
        	rem *= 10;;
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
		Fraction_to_Recurring_Decimal solution = new Fraction_to_Recurring_Decimal();
		
		System.out.println(solution.fractionToDecimal(1, 9));
		System.out.println(solution.fractionToDecimal(1, 99));
		System.out.println(solution.fractionToDecimal(1, 999));
		System.out.println(solution.fractionToDecimal(1, 90));
		System.out.println(solution.fractionToDecimal(1, 990));
		System.out.println(solution.fractionToDecimal(1, 9090));
		System.out.println(solution.fractionToDecimal(1, 2));
		System.out.println(solution.fractionToDecimal(2, 1));
		System.out.println(solution.fractionToDecimal(2, 3));
		System.out.println(solution.fractionToDecimal(22, 7));
		System.out.println(solution.fractionToDecimal(7, 12));
		System.out.println(solution.fractionToDecimal(4, 333));
		System.out.println(solution.fractionToDecimal(-50, 8));
		System.out.println(solution.fractionToDecimal(-1, -2147483648));
	}
}
