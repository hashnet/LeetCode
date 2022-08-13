package com.hashnet.leetcode.problemsetall;

import java.util.*;

public class Alien_Dictionary {
    private class DiGraph<T> {
        private Set<T> vertices;
        private Map<T, Set<T>> adj;

        public DiGraph() {
            vertices = new HashSet<>();
            this.adj = new HashMap<>();
        }

        public void addEdge(T vFrom, T vTo) {
            if (vFrom == vTo) return;

            if (!vertices.contains(vFrom)) addVertex(vFrom);
            if (!vertices.contains(vTo)) addVertex(vTo);

            if (!adj.get(vFrom).contains(vTo)) adj.get(vFrom).add(vTo);
        }

        public void addVertex(T vertex) {
            if (!vertices.contains(vertex)) {
                vertices.add(vertex);
                adj.put(vertex, new HashSet<>());
            }
        }

        public List<T> topologicalSort() {
            Set<T> visited = new HashSet<>();
            Deque<T> stack = new ArrayDeque<>();

            for (T vertex : vertices) {
                if (!visited.contains(vertex)) {
                    dfsTS(vertex, visited, stack);
                }
            }

            return new ArrayList<>(stack);
        }

        private void dfsTS(T vertex, Set<T> visited, Deque<T> stack) {
            visited.add(vertex);

            for (T next : adj.get(vertex)) {
                if (!visited.contains(next)) {
                    dfsTS(next, visited, stack);
                }
            }

            stack.push(vertex);
        }

        public boolean isCyclic() {
            Set<T> initial = new HashSet<>(vertices);
            Set<T> visiting = new HashSet<>();
            Set<T> visited = new HashSet<>();

            while (!initial.isEmpty()) {
                T vertex = initial.iterator().next();

                if (dfsCyc(vertex, initial, visiting, visited)) return true;
            }

            return false;
        }

        private boolean dfsCyc(T vertex, Set<T> initial, Set<T> visiting, Set<T> visited) {
            initial.remove(vertex);
            visiting.add(vertex);

            for (T next : adj.get(vertex)) {
                if (visited.contains(next)) continue;

                if (visiting.contains(next)) {
                    return true;
                }

                if (dfsCyc(next, initial, visiting, visited)) return true;
            }

            visiting.remove(vertex);
            visited.add(vertex);

            return false;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (T vertex : vertices) {
                sb.append(vertex);
                sb.append(": ");
                for (T next : adj.get(vertex)) {
                    sb.append("->" + next);
                }
                sb.append("\n");
            }

            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Alien_Dictionary s = new Alien_Dictionary();
        String[] words = {"wrt",
                "wrf",
                "er",
                "ett",
                "rftt"};
        System.out.println(s.alienOrder(words));
    }

    public String alienOrder(String[] words) {
        DiGraph<Character> dg = buildGraph(words);
//        System.out.println(dg.toString());

        if (dg.isCyclic()) return "";

        List<Character> ts = dg.topologicalSort();
        StringBuilder sb = new StringBuilder();
        for (char c : ts) {
            sb.append(c);
        }
        return sb.toString();
    }

    private DiGraph<Character> buildGraph(String[] words) {
        DiGraph<Character> dg = new DiGraph<>();

        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                dg.addVertex(word.charAt(i));
            }
        }

        for (int i = 1; i < words.length; i++) {
            String a = words[i - 1];
            String b = words[i];

            for (int j = 0; j < a.length() && j < b.length(); j++) {
                if (a.charAt(j) == b.charAt(j)) {
                    dg.addVertex(a.charAt(j));
                    continue;
                }

                dg.addEdge(a.charAt(j), b.charAt(j));
                break;
            }
        }

        return dg;
    }
}