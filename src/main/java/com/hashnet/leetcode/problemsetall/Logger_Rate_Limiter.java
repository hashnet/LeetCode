package com.hashnet.leetcode.problemsetall;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class Logger_Rate_Limiter {
    public static class Logger {
        private static class Pair<U, V> {
            private U left;
            private V right;

            public Pair(U left, V right) {
                this.left = left;
                this.right = right;
            }

            public U getLeft() {
                return left;
            }

            public void setLeft(U left) {
                this.left = left;
            }

            public V getRight() {
                return right;
            }

            public void setRight(V right) {
                this.right = right;
            }
        }
        private Queue<Pair<Integer, String>> queue;
        private Set<String> msgs;

        public Logger() {
            queue = new ArrayDeque<>();
            msgs = new HashSet<>();
        }

        public boolean shouldPrintMessage(int timestamp, String message) {
            while(queue.peek() != null && queue.peek().getLeft() <= timestamp - 10) {
                msgs.remove(queue.peek().getRight());
                queue.remove();
            }

            if(!msgs.contains(message)) {
                queue.add(new Pair<>(timestamp, message));
                msgs.add(message);
                return true;
            }

            return false;
        }
    }




    public static void main(String[] args) {
        Logger_Rate_Limiter.Logger solution = new  Logger_Rate_Limiter.Logger();

        System.out.println(solution.shouldPrintMessage(1, "foo"));
        System.out.println(solution.shouldPrintMessage(2, "bar"));
        System.out.println(solution.shouldPrintMessage(3, "foo"));
        System.out.println(solution.shouldPrintMessage(8, "bar"));
        System.out.println(solution.shouldPrintMessage(10, "foo"));
        System.out.println(solution.shouldPrintMessage(16, "foo"));
    }
}
