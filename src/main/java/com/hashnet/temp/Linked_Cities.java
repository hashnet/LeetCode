package com.hashnet.temp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Linked_Cities {
	/**
	 * Iterate through each line of input.
	 */
	public static void main(String[] args) throws IOException {
		InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
//		InputStreamReader reader = new InputStreamReader(new FileInputStream("src/inputs/cities.txt"), StandardCharsets.UTF_8);
		BufferedReader in = new BufferedReader(reader);
		
		CityGraph cityGraph = new CityGraph();
		
		int count = Integer.parseInt(in.readLine());
		
		String line;
		String[] cities;
		for(int i=0; i<=count; i++) {
			line = in.readLine();
			cities = line.split(",");
			
			if(i < count) {		//Build the edge map for first N lines
				cityGraph.addEdge(cities[0], cities[1]);
			}
			else {				//Get the connectivity for the N+1th line
				System.out.println(cityGraph.checkConnected(cities[0], cities[1]));
			}
		}
		
		in.close();
	}
	
	private static class CityGraph {
		// Edges map where Key is the source Nodes(Cities) and the values of Set are the connected Nodes (Cities)
		Map<String, Set<String>> edges;
		// To avoid cycles and to reduce unnecessary DFS recursion to the visited Nodes(Cities).
		Set<String> visited;
		
		public CityGraph() {
			edges = new HashMap<>();
			visited = new HashSet<>();
		}
		
		public void addEdge(String a, String b) {
			Set<String> edgesOfA = edges.getOrDefault(a, new HashSet<>());
			edgesOfA.add(b);
			edges.put(a,edgesOfA);
			
			Set<String> edgesOfB = edges.getOrDefault(b, new HashSet<>());
			edgesOfB.add(a);
			edges.put(b, edgesOfB);
		}
		
		// Finds the connectivity using Depth First Search in a recursive manner.
		public boolean checkConnected(String src, String dst) {
			if(src.equals(dst)) {
				return true;
			}
			
			visited.add(src);
			
			for(String edge: edges.get(src)) {
				if(visited.contains(edge)) {
					// If the node at this edge is already visited, ignore it.
					continue;	
				}
				
				if(checkConnected(edge, dst)) {
					// Check the positive connectivity eagerly and return if true.
					return true;	
				}
			}
			
			return false;
		}
	}
}