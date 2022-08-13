package com.hashnet.leetcode.problemsetall;

import java.util.PriorityQueue;

public class K_Closest_Points_to_Origin {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> q = new PriorityQueue<>(K, (o1, o2) -> {
            return -Integer.compare(o1[0], o2[0]);
        });

        for (int[] point : points) {
            int d = (point[0] * point[0]) + (point[1] * point[1]);
            q.add(new int[]{d, point[0], point[1]});

            if (q.size() > K) q.poll();
        }

        int[][] result = new int[q.size()][2];
        int i = 0;
        for (int[] point : q) {
            result[i][0] = point[1];
            result[i][1] = point[2];

            ++i;
        }

        return result;
    }
}
