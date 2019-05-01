package com.hashnet.leetcode.problemsetall;

public class _6_ZigZag_Conversion {
	public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        
        int pos;
		StringBuilder[] sb = new StringBuilder[numRows];
		for(int i=0; i<numRows; i++) {
			sb[i] = new StringBuilder();
		}
		
		int mod = (numRows - 1) * 2;
		for(int i=0; i<s.length(); i++) {
			pos = i % mod;
			if(pos >= numRows) pos = mod - pos;
			sb[pos].append(s.charAt(i));
		}
		
		StringBuilder result = new StringBuilder();
		for(int i=0; i<numRows; i++) {
			result.append(sb[i]);
		}
		return result.toString();
    }
	
	public static void main(String[] args) {
		_6_ZigZag_Conversion solution = new _6_ZigZag_Conversion();
		
		System.out.println(solution.convert("PAYPALISHIRING", 3));
		System.out.println(solution.convert("PAYPALISHIRING", 4));
	}
}
