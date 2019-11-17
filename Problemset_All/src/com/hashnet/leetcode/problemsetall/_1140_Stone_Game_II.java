package com.hashnet.leetcode.problemsetall;

import com.hashnet.leetcode.utility.ArrayUtility;

public class _1140_Stone_Game_II {
	public int stoneGameII(int[] piles) {
        int n = piles.length;
        
        int[][] matrix = new int[n+1][n+1];
        int [] sum = new int[n];
        
        int add = 0;
        for(int j=n-1; j>=0; j--) {
            add += piles[j];
            sum[j] = add;
        }
        
        for(int i=0; i<n; i++) {
            matrix[i][n-1] = sum[n-1];
            matrix[i][n-2] = sum[n-2];
        }
              
        for(int j=n-3; j>=0; j--) {
            for(int i=n-1; i>=0; i--) {
                int min = Integer.MAX_VALUE;
                
                int m = i+1;
                int ti, tj;
                for(int k=1; k<=(2*m); k++) {
                    if(k<=m) {
                        ti = i;
                        tj = j+k;
                    } else {
                        ti = i+(k-m);
                        tj = j+k;
                    }
                    
                    if(ti > n || tj > n) break;
                    
                    if(matrix[ti][tj] < min) min = matrix[ti][tj];
                }
                
                matrix[i][j] = sum[j] - min;
            }
            //System.out.println(ArrayUtility.int2DArrayToString(matrix));
        }
        
        return matrix[0][0];
    }
	
	public static void main(String[] args) {
		_1140_Stone_Game_II solution = new _1140_Stone_Game_II();
		
		System.out.println(solution.stoneGameII(ArrayUtility.toIntArray(2,7,9,4,4)));
		//System.out.println(solution.stoneGameII(ArrayUtility.toIntArray(9,2,2,8,3,7,9,9)));
	}
}
