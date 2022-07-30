package com.hashnet.leetcode.problemsetall;

public class Climbing_Stairs {
    public int climbStairs(int n) {
        int[] nWays = new int[n+1];
        nWays[0] = 1;
        nWays[1] = 1;
        
        for(int i=2; i<=n; i++) {
            nWays[i] = nWays[i-2] + nWays[i-1];
        }
        
        return nWays[n];
    }
    
    public static void main(String[] args) {
		Climbing_Stairs solution = new Climbing_Stairs();
		
		System.out.println(solution.climbStairs(2));
		System.out.println(3);
	}
}
