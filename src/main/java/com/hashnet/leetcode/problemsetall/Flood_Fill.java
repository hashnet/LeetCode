package com.hashnet.leetcode.problemsetall;

import com.hashnet.leetcode.utility.ArrayUtility;

public class Flood_Fill {
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		boolean[][] visited = new boolean[image.length][image[0].length];
		
		if(image[sr][sc] != newColor) dfs(image, visited, sr, sc, newColor);
		
		return image;
	}
	
	private void dfs(int[][] image, boolean[][] visited, int sr, int sc, int newColor) {
		int color = image[sr][sc];
		visited[sr][sc] = true;
		
		if(sr > 0 && !visited[sr-1][sc] && image[sr-1][sc] == color) dfs(image, visited, sr-1, sc, newColor);
		if(sr < image.length-1 && !visited[sr+1][sc] && image[sr+1][sc] == color) dfs(image, visited, sr+1, sc, newColor);
		if(sc > 0 && !visited[sr][sc-1] && image[sr][sc-1] == color) dfs(image, visited, sr, sc-1, newColor);
		if(sc < image[0].length-1 && !visited[sr][sc+1] && image[sr][sc+1] == color) dfs(image, visited, sr, sc+1, newColor);
		
		image[sr][sc] = newColor;
	}

	public static void main(String[] args) {
		Flood_Fill solution = new Flood_Fill();
		
		int[][] image = {
				{1, 1, 1},
				{1, 1, 0},
				{1, 0, 1}
		};
		
		System.out.println(ArrayUtility.int2DArrayToString(solution.floodFill(image, 1, 1, 2)));
	}
}
