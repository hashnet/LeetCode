package com.hashnet.leetcode.problemsetall;

import java.util.ArrayList;
import java.util.List;

public class Spiral_Matrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        if(matrix.length == 0) return result;

        int top, bottom, left, right;
        top = left = 0;
        bottom = matrix.length-1;
        right = matrix[0].length-1;

        int dir = 0;    //0 = left to right, 1 = top to bottom, 2 = right to left, 3 = bottom to top
        boolean leftToRight = true;
        boolean topToBottom = true;
        while(true) {
            if(dir == 0 || dir == 2) {
                if(right < left) break;

                int i = dir == 0 ? top : bottom;
                int str = dir == 0 ? left : right;
                int end = dir == 0 ? right : left;

                if(dir == 0) {
                    for(int j=str; j<=end; j++) {
                        result.add(matrix[i][j]);
                    }
                    ++top;
                } else {
                    for(int j=str; j>=end; j--) {
                        result.add(matrix[i][j]);
                    }
                    --bottom;
                }

                leftToRight = !leftToRight;
            } else {
                if(bottom < top) break;

                int str = dir == 1 ? top : bottom;
                int end = dir == 1 ? bottom : top;
                int j = dir == 1 ? right : left;

                if(dir == 1) {
                    for(int i=str; i<=end; i++) {
                        result.add(matrix[i][j]);
                    }
                    --right;
                } else {
                    for(int i=str; i>=end; i--) {
                        result.add(matrix[i][j]);
                    }
                    ++left;
                }

                topToBottom = !topToBottom;
            }

            dir = (dir + 1) % 4;
        }

        return result;
    }

    public static void main(String[] args) {
        Spiral_Matrix solution = new Spiral_Matrix();

        int[][] matrix = {
            { 1, 2, 3 },
            { 4, 5, 6 },
            { 7, 8, 9 }
        };
        System.out.println(solution.spiralOrder(matrix));
    }
}
