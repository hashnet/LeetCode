package com.hashnet.leetcode.problemsetall;

import java.util.ArrayDeque;
import java.util.Queue;

public class Design_Hit_Counter {
    private static class HitCounter {
        private final Queue<Integer> queue;

        public HitCounter() {
            queue = new ArrayDeque<>();
        }

        public void hit(int timestamp) {
            while(queue.peek() != null && queue.peek() <= timestamp-300) {
                queue.remove();
            }

            queue.add(timestamp);
        }

        public int getHits(int timestamp) {
            while(queue.peek() != null && queue.peek() <= timestamp-300) {
                queue.remove();
            }

            return queue.size();
        }
    }

    public static void main(String[] args) {
        Design_Hit_Counter.HitCounter solution = new Design_Hit_Counter.HitCounter();
        solution.hit(1);
        solution.hit(2);
        solution.hit(3);
        System.out.println(solution.getHits(4));
        solution.hit(300);
        System.out.println(solution.getHits(300));
        System.out.println(solution.getHits(301));
    }
}
