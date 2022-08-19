package com.hashnet.temp;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class HashTest {
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

    public static void main(String[] args) {
        Set<Pair> pairs = new HashSet<>();
        pairs.add(new Pair(10, 20));

        System.out.println(pairs.contains(new Pair(10, 11)));
        System.out.println(pairs.contains(new Pair(10, 20)));
    }
}
