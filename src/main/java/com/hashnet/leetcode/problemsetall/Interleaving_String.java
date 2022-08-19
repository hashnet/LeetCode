package com.hashnet.leetcode.problemsetall;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Interleaving_String {
    private static class Pair {
        int i;
        int j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Pair pair = (Pair) o;
            return i == pair.i && j == pair.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if(s3.length() != (s1.length() + s2.length())) return false;

        int x = s1.length();
        int y = s2.length();

        boolean[][] map = new boolean [x+1][y+1];
        map[0][0] = true;

        for(int i=0; i<=x; i++) {
            for(int j=0; j<=y; j++) {
                if(i==0 && j==0) {
                    continue;
                }

                if(i==0) {
                    map[i][j] = map[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1);
                } else if(j ==0) {
                    map[i][j] = map[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1);
                } else {
                    map[i][j] = (map[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1)) || (map[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1));
                }
            }
        }

        return map[x][y];
    }

    public boolean isInterleaveRecursive(String s1, String s2, String s3) {
        if(s3.length() != (s1.length() + s2.length())) return false;

        int i = s1.length()-1;
        int j = s2.length()-1;

        Map<Pair, Boolean> mem = new HashMap<>();

        return helper(s1, i, s2, j, s3, mem);
    }

    private boolean helper(String s1, int i, String s2, int j, String t, Map<Pair, Boolean> mem) {
        Pair p = new Pair(i, j);
        if(mem.containsKey(p)) {
            return mem.get(p);
        }

        int k = i + j + 1;
        if(k < 0) {
            mem.put(p, true);
            return true;
        }

        if(i >= 0 && s1.charAt(i) == t.charAt(k)) {
            boolean result = helper(s1, i-1, s2, j, t, mem);
            if (result) {
                mem.put(p, true);
                return true;
            }
        } if (j >= 0 && s2.charAt(j) == t.charAt(k)) {
            boolean result = helper(s1, i, s2, j-1, t, mem);
            if(result) {
                mem.put(p, true);
                return true;
            }
        }

        mem.put(p, false);
        return false;
    }

    public static void main(String[] args) {
        Interleaving_String solution = new Interleaving_String();

        System.out.println(solution.isInterleave("baa", "aaaba", "aaabaaba"));
        System.out.println(solution.isInterleave("a", "", "a"));
        System.out.println(solution.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(solution.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
        System.out.println(solution.isInterleave("", "", ""));
    }
}
