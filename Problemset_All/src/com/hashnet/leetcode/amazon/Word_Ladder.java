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
		int size;
		
		Map<String, List<String>> edgeTable;
		
		public G(List<String> wordList) {
			this.size = wordList.size();
			edgeTable = new HashMap<>();
			
			addVertices(wordList);
		}
		
		public void addVertices(List<String> vertices) {
			for(String vertex : vertices) {
				edgeTable.put(vertex, new ArrayList<>());
			}
		}
		
		public void addEdge(String from, String to) {
			List<String> edgeList = edgeTable.get(from);
			if(edgeList != null) edgeList.add(to);
		}
		
		public void connectEdge(String a, String b) {
			addEdge(a, b);
			addEdge(b, a);
		}
		
		public int bfs(String src, String dst) {
			if(!edgeTable.keySet().contains(dst)) return 0;
			
			Map<String, Integer> distanceTable = new HashMap<>();
			for(String vertex : edgeTable.keySet()) {
				distanceTable.put(vertex, Integer.MAX_VALUE);
			}

			Queue<String> q = new LinkedList<>();
			q.add(src);
			distanceTable.put(src, 0);
			while(!q.isEmpty()) {
				String vertex = q.remove();
				int dist = distanceTable.get(vertex);
				
				for(String next : edgeTable.get(vertex)) {
					if(distanceTable.get(next) == Integer.MAX_VALUE) {
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
			
			sb.append("size = " + size + "\n");
			
			for(String vertex : edgeTable.keySet()) {
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
		
		wordList = new ArrayList<>(words);
		int len = words.size();
		G g = new G(wordList);
		for(int i=0; i<len; i++) {
        	for(int j=i+1; j<len; j++) {
        		if(isUnitDistanced(wordList.get(i), wordList.get(j))) {
        			g.connectEdge(wordList.get(i), wordList.get(j));
        		}
        	}
        }
		
		//System.out.println(g);
		return g.bfs(beginWord, endWord);
    }
	
	private boolean isUnitDistanced(String a, String b) {
		int missedCount = 0;
		for(int i=0; i<a.length(); i++) {
			if(a.charAt(i) != b.charAt(i)) ++missedCount;
			
			if(missedCount > 1) return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		Word_Ladder solution = new Word_Ladder();
		
		System.out.println(solution.ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog")));
		System.out.println(solution.ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log")));
		System.out.println(solution.ladderLength("leet", "code", Arrays.asList("lest","leet","lose","code","lode","robe","lost")));
	}
}
