package com.hashnet.leetcode.problemsetall;

public class Integer_to_Roman {
	public String intToRoman(int num) {
		StringBuilder sb = new StringBuilder();
		
		int t = num / 1000;
		if(t != 0) {
			for(int i=1; i<=t; i++) {
				sb.append("M");
			}
		}
		
		num %= 1000;
		convert(num/100, sb, "C", "D", "M");
		
		num %= 100;
		convert(num/10, sb, "X", "L", "C");
		
		num %= 10;
		convert(num, sb, "I", "V", "X");
		
		return sb.toString();
	}
	
	private void convert(int num, StringBuilder sb, String one, String five, String ten) {
		if(num != 0) {
			if(num < 5) {
				if(num == 4) {
					sb.append(one + five);
				} else {
					for(int i=1; i<=num; i++) {
						sb.append(one);
					}
				}
			} else {
				if(num == 9) {
					sb.append(one + ten);
				} else {
					sb.append(five);
					num -= 5;
					for(int i=1; i<=num; i++) {
						sb.append(one);
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Integer_to_Roman solution = new Integer_to_Roman();
		

		System.out.println(solution.intToRoman(1));
		System.out.println(solution.intToRoman(3));
		System.out.println(solution.intToRoman(4));
		System.out.println(solution.intToRoman(9));
		System.out.println(solution.intToRoman(58));
		System.out.println(solution.intToRoman(1994));
	}
}
