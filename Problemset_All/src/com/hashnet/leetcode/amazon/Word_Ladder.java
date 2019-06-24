package com.hashnet.leetcode.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Word_Ladder {
	private class G {
		private Set<String> words;
		private Map<String, List<String>> wordToMaskList;
		private Map<String, Set<String>> maskTable;
		private Map<String, List<String>> edgeTable;

		public G(Set<String> words) {
			this.words = words;
			this.wordToMaskList = new HashMap<>();
			this.maskTable = new HashMap<>();
			this.edgeTable = new HashMap<>();
		}

		public int getSize() {
			return words.size();
		}

		public void prepareEdge() {
			for (String str : words) {
				List<String> maskList = new ArrayList<>();
				for (int i = 0; i < str.length(); i++) {
					String mask = str.substring(0, i) + "*" + str.substring(i + 1, str.length());

					maskList.add(mask);

					Set<String> mapping = maskTable.get(str);
					if (mapping == null) {
						mapping = new HashSet<>();
						maskTable.put(mask, mapping);
					}
					mapping.add(str);
				}

				wordToMaskList.put(str, maskList);
			}

			for (String str : words) {
				edgeTable.put(str, new ArrayList<>());
			}

			for (String str : words) {
				for (String mask : wordToMaskList.get(str)) {
					for (String next : maskTable.get(mask)) {
						if (!next.equals(str)) {
							edgeTable.get(str).add(next);
							edgeTable.get(next).add(str);
						}
					}
				}
			}
		}

		public int bfs(String src, String dst) {
			if (!edgeTable.keySet().contains(dst))
				return 0;

			Map<String, Integer> distanceTable = new HashMap<>();
			for (String vertex : edgeTable.keySet()) {
				distanceTable.put(vertex, Integer.MAX_VALUE);
			}

			Queue<String> q = new LinkedList<>();
			q.add(src);
			distanceTable.put(src, 0);
			while (!q.isEmpty()) {
				String vertex = q.remove();
				int dist = distanceTable.get(vertex);

				for (String next : edgeTable.get(vertex)) {
					if (distanceTable.get(next) == Integer.MAX_VALUE) {
						q.add(next);
						distanceTable.put(next, dist + 1);
					}
				}
			}

			int bfsResult = distanceTable.get(dst);
			return bfsResult == Integer.MAX_VALUE ? 0 : bfsResult + 1;
		}

		public String toString() {
			StringBuilder sb = new StringBuilder();

			sb.append("size = " + getSize() + "\n");

			for (String vertex : edgeTable.keySet()) {
				sb.append(vertex + ": ");
				sb.append(edgeTable.get(vertex));
				sb.append("\n");
			}

			return sb.toString();
		}
	}

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Set<String> words = new HashSet<>(wordList);
		words.add(beginWord);

		G g = new G(words);
		g.prepareEdge();

		System.out.println(g);

		return g.bfs(beginWord, endWord);
	}

	public static void main(String[] args) {
		Word_Ladder solution = new Word_Ladder();

		System.out.println(solution.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
		System.out.println(solution.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log")));
		System.out.println(solution.ladderLength("leet", "code", Arrays.asList("lest", "leet", "lose", "code", "lode", "robe", "lost")));
	}
}
