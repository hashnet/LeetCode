package com.hashnet.leetcode.problemsetall;

import com.sun.tools.javac.Main;

public class Island_Perimeter {
    public int islandPerimeter(int[][] grid) {
        int result = 0;

        int nRow = grid.length;
        int nCol = grid[0].length;

        for (int r = 0; r < nRow; r++) {
            for (int c = 0; c < nCol; c++) {
                if (grid[r][c] == 1) {
                    if (r == 0 || grid[r - 1][c] == 0) ++result;
                    if (r == nRow - 1 || grid[r + 1][c] == 0) ++result;
                    if (c == 0 || grid[r][c - 1] == 0) ++result;
                    if (c == nCol - 1 || grid[r][c + 1] == 0) ++result;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Island_Perimeter solution = new Island_Perimeter();

        System.out.println(solution.islandPerimeter(new int[][]{{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}}));
        System.out.println(solution.islandPerimeter(new int[][]{{1}}));
        System.out.println(solution.islandPerimeter(new int[][]{{1, 0}}));
    }
}
