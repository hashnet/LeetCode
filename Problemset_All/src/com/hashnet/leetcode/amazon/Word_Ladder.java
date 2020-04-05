package com.hashnet.leetcode.amazon;

import javafx.util.Pair;

import java.util.*;

public class Word_Ladder {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Map<String, Set<String>> patternToWord = new HashMap<>();

		int len = beginWord.length();

		for (String word : wordList) {
			for(int i=0; i<len; i++) {
				String pattern = word.substring(0, i) + '_' + word.substring(i+1);

				Set<String> wordsForPattern = patternToWord.getOrDefault(pattern, new HashSet<>());
				wordsForPattern.add(word);
				patternToWord.put(pattern, wordsForPattern);
			}
		}

//		System.out.println(patternToWord);

		Queue<Pair<String, Integer>> Q = new ArrayDeque<>();
		Q.add(new Pair(beginWord, 1));
		Set<String> visited = new HashSet<>();
		while(!Q.isEmpty()) {
			Pair<String, Integer> pair = Q.remove();
			String word = pair.getKey();
			Integer level = pair.getValue();

			for(int i=0; i<len; i++) {
				String pattern = word.substring(0, i) + '_' + word.substring(i+1);

				for(String nextWord : patternToWord.getOrDefault(pattern, new HashSet<>())) {

					if (nextWord.equals(endWord)) {
						return level + 1;
					}

					if(!visited.contains(nextWord)) {
						Q.add(new Pair(nextWord, level + 1));
					}
				}
			}

			visited.add(word);
		}

		return 0;
 	}

	public static void main(String[] args) {
		Word_Ladder solution = new Word_Ladder();

		System.out.println(solution.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
		System.out.println(solution.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log")));
		System.out.println(solution.ladderLength("leet", "code", Arrays.asList("lest", "leet", "lose", "code", "lode", "robe", "lost")));
	}
}
