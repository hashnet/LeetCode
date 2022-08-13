package com.hashnet.leetcode.problemsetall;

import java.util.*;

public class Word_Search_II {
    private class TrieNode {
        private Map<Character, TrieNode> links;
        private String word;

        public TrieNode() {
            links = new HashMap<>();
        }
    }

    private TrieNode root = new TrieNode();
    private char[][] board;
    private int nRow;
    private int nCol;
    private boolean[][] visited;

    public List<String> findWords(char[][] board, String[] words) {
        //First insert the words into the Trie structure
        for (String word : words) {
            TrieNode node = root;

            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (!node.links.containsKey(ch)) {
                    node.links.put(ch, new TrieNode());
                }

                node = node.links.get(ch);
            }

            node.word = word;
        }

        this.board = board;
        nRow = this.board.length;
        nCol = this.board[0].length;
        this.visited = new boolean[nRow][nCol];

        //start from all cell
        for (int i = 0; i < nRow; i++) {
            for (int j = 0; j < nCol; j++) {
                char ch = this.board[i][j];

                if (root.links.containsKey(ch)) {
                    recurse(i, j, root.links.get(ch));
                }
            }
        }

        return new ArrayList<>(result);
    }

    private Set<String> result = new HashSet<>();

    private void recurse(int iRow, int iCol, TrieNode node) {
        char ch = board[iRow][iCol];

        if (node.word != null) {
            result.add(node.word);
        }

        visited[iRow][iCol] = true;

        int[] rowOffset = {0, 1, 0, -1};
        int[] colOffset = {1, 0, -1, 0};
        for (int i = 0; i < 4; i++) {
            int nextRow = iRow + rowOffset[i];
            int nextCol = iCol + colOffset[i];

            if (nextRow < 0 || nextRow >= nRow || nextCol < 0 || nextCol >= nCol) continue;
            if (visited[nextRow][nextCol]) continue;

            char nextChar = board[nextRow][nextCol];
            if (node.links.containsKey(nextChar)) {
                recurse(nextRow, nextCol, node.links.get(nextChar));
            }
        }

        visited[iRow][iCol] = false;
    }

    public static void main(String[] args) {
        Word_Search_II solution = new Word_Search_II();

        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        System.out.println(solution.findWords(board, new String[]{"oath", "pea", "eat", "rain"}));
    }
}
