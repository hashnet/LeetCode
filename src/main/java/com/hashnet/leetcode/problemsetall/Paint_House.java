package com.hashnet.leetcode.problemsetall;

public class Paint_House {
    public int minCost(int[][] costs) {
        int len = costs.length;
        if (len == 0) return 0;

        int idx = len - 2;

        while (idx >= 0) {
            costs[idx][0] += Math.min(costs[idx + 1][1], costs[idx + 1][2]);
            costs[idx][1] += Math.min(costs[idx + 1][0], costs[idx + 1][2]);
            costs[idx][2] += Math.min(costs[idx + 1][0], costs[idx + 1][1]);

            --idx;
        }

        return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));
    }
}
