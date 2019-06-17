package com.hashnet.leetcode.problemsetall;

public class _1025_Divisor_Game {
	public boolean divisorGame(int N) {
		return (N%2 == 0);
	}

	public static void main(String[] args) {
		_1025_Divisor_Game solution = new _1025_Divisor_Game();
		
		System.out.println(solution.divisorGame(2));
	}
}
