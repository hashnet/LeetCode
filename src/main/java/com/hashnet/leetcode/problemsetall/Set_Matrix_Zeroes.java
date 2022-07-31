package com.hashnet.leetcode.problemsetall;

public class Set_Matrix_Zeroes {
	public static void main(String[] args) {
		Set_Matrix_Zeroes s = new Set_Matrix_Zeroes();
		int[][] matrix = {
		                  {0,1,2,0},
		                  {3,4,5,2},
		                  {1,3,1,5}
		                  };
		
		
		s.printMatrix(matrix);
		s.setZeroes(matrix);
		s.printMatrix(matrix);
		
		
	}
	public void setZeroes(int[][] matrix) {
		boolean firstRowZero = false;
		boolean firstColZero = false;
		
		for(int j=0; j<matrix[0].length; j++) {
			if(matrix[0][j] == 0) {
				firstRowZero = true;
				break;
			}
		}
		
		for(int i=0; i<matrix.length; i++) {
			if(matrix[i][0] == 0) {
				firstColZero = true;
				break;
			}
		}
		
		for(int i=1; i<matrix.length; i++) {
			for(int j=1; j<matrix[0].length; j++) {
				if(matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		
		for(int i=1; i<matrix.length; i++) {
			if(matrix[i][0] == 0) zeroRow(matrix, i);
		}
		
		for(int j=1; j<matrix[0].length; j++) {
			if(matrix[0][j] == 0) zeroCol(matrix, j);
		}
		
		if(firstRowZero) zeroRow(matrix, 0);
		if(firstColZero) zeroCol(matrix, 0);
    }
	
	private void zeroRow(int[][] matrix, int row) {
		for(int j=0; j<matrix[0].length; j++) matrix[row][j] = 0;
	}
	
	private void zeroCol(int[][] matrix, int col) {
		for(int i=0; i<matrix.length; i++) matrix[i][col] = 0;
	}
	
	private void printMatrix(int[][] matrix) {
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[i].length; j++) {
				System.out.print(String.format("%2d", matrix[i][j]));
			}
			
			System.out.println();
		}
		System.out.println();
	}
}
