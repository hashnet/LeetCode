package com.hashnet.leetcode.problemsetall;

public class Divisor_Game {
    public boolean divisorGame(int N) {
        return (N % 2 == 0);
    }

    public static void main(String[] args) {
        Divisor_Game solution = new Divisor_Game();

        System.out.println(solution.divisorGame(2));
    }
}
