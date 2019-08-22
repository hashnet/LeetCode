package com.hashnet.leetcode.amazon;

import com.hashnet.leetcode.utility.ArrayUtility;

public class Rotate_Image {
	public void rotate(int[][] matrix) {
		int min = 0;
		int max = matrix.length - 1;
		
		while (min < max) {
			for(int count=1; count<=(max-min); count++) {
				int x = matrix[min][min];
				
				for(int j=min+1; j<=max; j++) {
					int temp = matrix[min][j];
					matrix[min][j] = x;
					x = temp;
				}
				for(int i=min+1; i<=max; i++) {
					int temp = matrix[i][max];
					matrix[i][max] = x;
					x = temp;
				}
				for(int j=max-1; j>=min; j--) {
					int temp = matrix[max][j];
					matrix[max][j] = x;
					x = temp;
				}
				for(int i=max-1; i>=min; i--) {
					int temp = matrix[i][min];
					matrix[i][min] = x;
					x = temp;
				}
			}
			
			min++;
			max--;
		}
	}

	public static void main(String[] args) {
		Rotate_Image solution = new Rotate_Image();
		
		int[][] matrix = {
		                  {15,13, 2, 5},
		                  {14, 3, 4, 1},
		                  {12, 6, 8, 9},
		                  {16, 7,10,11}
		                 };
		
		System.out.println("Original Matrix: \n" + ArrayUtility.int2DArrayToString((matrix)));
		solution.rotate(matrix);
		System.out.println("Rotated Matrix: \n" + ArrayUtility.int2DArrayToString((matrix)));
	}
}
