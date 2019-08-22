package com.hashnet.leetcode.problemsetall;

import com.hashnet.leetcode.utility.ArrayUtility;

public class _1130_Minimum_Cost_Tree_From_Leaf_Values {
	public int mctFromLeafValues(int[] arr) {
        int n = arr.length;
        
        int[][] sum = new int[n][n];
        int[][] max = new int[n][n];
        
        for(int i=0; i<n; i++) {
            max[i][i] = arr[i];
        }
        
        for(int k=1; k<n; k++) {
            for(int i=0; i<=(n-k-1); i++) {
                int j = i+k;
                
                max[i][j] = Math.max(max[i][j-1], max[i+1][j]);
                sum[i][j] = Math.min(sum[i][j-1] + (max[i][j-1] * arr[j]), sum[i+1][j] + (max[i+1][j] * arr[i]));
            }
        }
        
        System.out.println(ArrayUtility.int2DArrayToString(max));
        System.out.println(ArrayUtility.int2DArrayToString(sum));
        
        return sum[0][n-1];
    }
	
	public static void main(String[] args) {
		_1130_Minimum_Cost_Tree_From_Leaf_Values solution = new _1130_Minimum_Cost_Tree_From_Leaf_Values();
		
		System.out.println(solution.mctFromLeafValues(ArrayUtility.toIntArray(3,7,2,12,15,10,3,9)));
		
		System.out.println(solution.mctFromLeafValues(ArrayUtility.toIntArray(6, 2, 4)));
	}
}
