package com.hashnet.leetcode.problemsetall;

import java.math.BigInteger;

class Factorial_Trailing_Zeroes {
	public static void main(String[] args) {
		Factorial_Trailing_Zeroes s = new Factorial_Trailing_Zeroes();
		
		System.out.println(s.fact(200));
		System.out.println(s.trailingZeroes(200));
	}
	
	private String fact(int n) {
		BigInteger num = new BigInteger(String.valueOf(n));
		BigInteger one = new BigInteger("1");
		
		BigInteger res = new BigInteger("1");
		while(num.compareTo(one) > 0) {
			res = res.multiply(num);
			num = num.subtract(one);
		}
		
		return res.toString();
	}
	
    public int trailingZeroes(int n) {
        long res = 1;
        
        int count = 0;
        while(n > 1) {
        	res = res * n;
            
            while(res%10 == 0) {
                ++count;
                res = res/10;
            }
            res = res%1000;
            
            --n;
        }
        
        return count;
    }
}