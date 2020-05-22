package com.hashnet.leetcode.problemsetall;

import java.util.*;

public class _743_Network_Delay_Time {
    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, List<int[]>> edgeMap = new HashMap<>();
        for(int[] edge : times) {
            List<int[]> edges = edgeMap.getOrDefault(edge[0]-1, new ArrayList<>());
            edges.add(new int[] {edge[1]-1, edge[2]});
            edgeMap.put(edge[0]-1, edges);
        }

/*        edgeMap.forEach( (s, edges) -> {
            System.out.print("s=" + s + " -> ");
            edges.forEach( edge -> {
                System.out.print("d=" + (edge[0]-1) + "/w=" + (edge[1]-1) + ", ");
            });
            System.out.println();
        });*/

        boolean[] processed = new boolean[N];
        int[] distance = new int[N];
        for(int i=0; i<N; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> {  //[0] = index, [1] = distance
            return Integer.compare(o1[1], o2[1]);
        });

        distance[K-1] = 0;
        q.add(new int[]{K-1, distance[K-1]});
        while(!q.isEmpty()) {
            int[] node = q.poll();
            int si = node[0];
            int sd = node[1];

            if(processed[si]) continue;
            if(!edgeMap.containsKey(si)) continue;

            for (int[] edge : edgeMap.get(si)) {
                int di = edge[0];
                int w = edge[1];
                if(processed[di]) continue;

                if((sd + w) < distance[di]) {
                    distance[di] = sd + w;
                    q.add(new int[]{di, distance[di]});
                }
            }

            processed[si] = true;
        }

        int minDistance = Integer.MIN_VALUE;
        for(int d : distance) {
            minDistance = Math.max(minDistance, d);
        }

        if(minDistance == Integer.MAX_VALUE) return -1;
        else return minDistance;
    }

    public static void main(String[] args) {
        _743_Network_Delay_Time solution = new _743_Network_Delay_Time();
        System.out.println(solution.networkDelayTime(new int[][]{{2,1,1},{2,3,1},{3,4,1}}, 4, 2));

    }
}
