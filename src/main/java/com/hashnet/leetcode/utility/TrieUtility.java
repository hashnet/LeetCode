package com.hashnet.leetcode.utility;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TrieUtility {
    private class Trie {
        private class TrieNode {
            private Map<Character, TrieNode> links;
            private boolean isTerminal;

            public TrieNode() {
                links = new HashMap<>();
            }
        }

        private TrieNode  root;

        /** Initialize your data structure here. */
        public Trie() {
            root  = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode node = root;

            for(int i=0; i<word.length(); i++) {
                char ch = word.charAt(i);

                if(!node.links.containsKey(ch)) {
                    node.links.put(ch, new TrieNode());
                }

                node = node.links.get((ch));
            }

            node.isTerminal = true;
        }

        private TrieNode searchPrefix(String word)  {
            TrieNode node = root;

            for(int i=0; i<word.length(); i++) {
                char  ch = word.charAt(i);

                if(!node.links.containsKey(ch)) {
                    return null;
                }

                node = node.links.get(ch);
            }

            return node;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode node = searchPrefix(word);

            return node != null && node.isTerminal;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            TrieNode node = searchPrefix(prefix);

            return node != null;
        }
    }


    public static void main(String[] args) {
        Trie trie = new TrieUtility().new Trie();

        String[] names = {
                "najat",
                "namir",
                "nayala",
                "hasib"
        };
        Arrays.stream(names).forEach((word) -> {
            trie.insert(word);
        });

        String[] searches = {
                "najat",
                "naj",
                "najat123",
                "naz",
                "namir",
                "has"
        };
        Arrays.stream(searches).forEach((word) -> {
            System.out.println(word + (trie.search(word) ? " found" : " not found") + " as word, "
            + (trie.startsWith(word) ? " found" : " not found") + " as prefix.");
        });
    }
}
