package com.hashnet.leetcode.problemsetall;

import com.hashnet.leetcode.utility.ArrayUtility;

public class Min_Cost_Climbing_Stairs {
    public int minCostClimbingStairs(int[] cost) {
        for (int i = 2; i < cost.length; i++) {
            cost[i] += Math.min(cost[i - 1], cost[i - 2]);
        }

        return Math.min(cost[cost.length - 1], cost[cost.length - 2]);
    }

    public static void main(String[] args) {
        Min_Cost_Climbing_Stairs solution = new Min_Cost_Climbing_Stairs();

        System.out.println(solution.minCostClimbingStairs(ArrayUtility.toIntArray(10, 15, 20)));
        System.out.println(solution.minCostClimbingStairs(ArrayUtility.toIntArray(1, 100, 1, 1, 1, 100, 1, 1, 100, 1)));
    }
}
