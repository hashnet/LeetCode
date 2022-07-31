package com.hashnet.leetcode.problemsetall;

import java.util.Arrays;

public class Smallest_Integer_Not_Occuring_in_A {
    public int solution(int[] A) {
        int max = 1;

        Arrays.sort(A);

        for(int i : A) {
            if(i == max) ++max;
            else if(i < max) continue;
            else return max;
        }

        return max;
    }

    public static void main(String[] args) {
        Smallest_Integer_Not_Occuring_in_A s = new Smallest_Integer_Not_Occuring_in_A();
        System.out.println(s.solution(new int[]{1, 3, 6, 4, 1, 2}));
        System.out.println(s.solution(new int[]{1, 2, 3}));
        System.out.println(s.solution(new int[]{-1, -3}));
        System.out.println(s.solution(new int[]{Integer.MIN_VALUE}));
    }
}
