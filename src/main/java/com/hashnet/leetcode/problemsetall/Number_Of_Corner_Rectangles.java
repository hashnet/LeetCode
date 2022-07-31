package com.hashnet.leetcode.problemsetall;

import java.util.HashMap;
import java.util.Map;

public class Number_Of_Corner_Rectangles {
	public int countCornerRectangles(int[][] grid) {
		Map<String, Integer> rectTop = new HashMap<>();
		
		int count = 0;
		for(int[] row : grid) {
			for(int colS=0; colS < row.length-1; colS++) {
				if(row[colS] == 1) {
					for(int colE=colS+1; colE < row.length; colE++) {
						if(row[colE] == 1) {
							String rectBottom = String.valueOf(colS) + ":" + String.valueOf(colE);
							
							int tops = rectTop.getOrDefault(rectBottom, 0);
							count += tops;
							
							rectTop.put(rectBottom, tops+1);
						}
					}
				}
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		Number_Of_Corner_Rectangles solution = new Number_Of_Corner_Rectangles();
		
		int[][] grid1 = 
				{{1, 0, 0, 1, 0},
				 {0, 0, 1, 0, 1},
				 {0, 0, 0, 1, 0},
				 {1, 0, 1, 0, 1}};
		System.out.println(solution.countCornerRectangles(grid1));
		
		int[][] grid2 =
			   {{1, 1, 1},
		        {1, 1, 1},
		        {1, 1, 1}};
		System.out.println(solution.countCornerRectangles(grid2));
		
		int[][] grid3 = {{1, 1, 1, 1}};
		System.out.println(solution.countCornerRectangles(grid3));
	}
}
