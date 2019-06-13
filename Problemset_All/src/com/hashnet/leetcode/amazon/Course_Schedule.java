package com.hashnet.leetcode.amazon;

import java.util.ArrayList;
import java.util.List;

public class Course_Schedule {
	private class DiGraph {
		private int V;
		List<List<Integer>> edges;
		
		public DiGraph(int V) {
			this.V = V;
			
			edges = new ArrayList<>(V);
			for(int i=0; i<V; i++) {
				edges.add(new ArrayList<>());
			}
		}
		
		public void addEdge(int source, int dest) {
			edges.get(source).add(dest);
		}
		
		public boolean isCyclic() {
			boolean[] visited = new boolean[V];
			boolean[] inStack = new boolean[V];
			
			for(int i=0; i<V; i++) {
				if(!visited[i]) {
						if(isCyclicDFS(i, visited, inStack)) {
							return true;
						}
				}
			}
			
			return false;
		}
		
		public boolean isCyclicDFS(int idx, boolean[] visited, boolean[] inStack) {
			if(inStack[idx]) return true;
			
			inStack[idx] = true;
			visited[idx] = true;
			
			for(int nextIdx : edges.get(idx)) {
				if(isCyclicDFS(nextIdx, visited, inStack))	return true;
			}
			
			inStack[idx] = false;
			
			return false;
		}
		
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append("Number of vertices: " + V + "\n");
			sb.append("Edge list:\n");
			for(int i=0; i<V; i++) {
				sb.append(String.format("%3d:", i));
				boolean first = true;
				for(int next : edges.get(i)) {
					if(!first) {
						sb.append(",");
						first = false;
					}
					sb.append(String.format("%3d", next));
				}
				sb.append("\n");
			}
			
			return sb.toString();
		}
	}
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		DiGraph g = new DiGraph(numCourses);	
		for(int i=0; i<prerequisites.length; i++) {
			g.addEdge(prerequisites[i][1], prerequisites[i][0]);
		}
		
		return g.isCyclic();
	}

	public static void main(String[] args) {
		Course_Schedule solution = new Course_Schedule();
		
		int vCount = 4;
		int[][] prerequisites = {{1, 0},{2, 0}, {2, 1}, {0, 2}, {3, 2}, {3, 3}};
		
		System.out.println(solution.canFinish(vCount, prerequisites));
	}
}
