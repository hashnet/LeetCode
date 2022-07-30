package com.hashnet.leetcode.problemsetall;

public class String_to_Integer_atoi {
	public int myAtoi(String str) {
		boolean isPos = true;
		
		str = str.trim();
		
		if(str.length() == 0) return 0;
		
		int start = 0;
		char first = str.charAt(0);
		if(first == '+') {
			isPos = true;
			start = 1;
		} else if(first == '-') {
			isPos = false;
			start = 1;
		} else if(first < '0' || first > '9') return 0;
		
		long result = 0;
		for(int i=start; i<str.length() && (str.charAt(i)>='0' && str.charAt(i) <='9'); i++) {
			if(isPos) {
				result  = (result * 10) + (str.charAt(i) - '0');
				if(result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
			} else  {
				result  = (result * 10) - (str.charAt(i) - '0');
				if(result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
			}
		}
		
		return (int)result;
	}

	public static void main(String[] args) {
		String_to_Integer_atoi solution = new String_to_Integer_atoi();
		
		System.out.println(solution.myAtoi("4193 with words"));
		System.out.println(solution.myAtoi("42"));
		System.out.println(solution.myAtoi("   -42"));
		System.out.println(solution.myAtoi("words and 987"));
		System.out.println(solution.myAtoi("-91283472332"));
	}
}
