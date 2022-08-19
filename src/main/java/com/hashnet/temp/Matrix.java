package com.hashnet.temp;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

public class Matrix {
    public static void main(String[] args) {
        int nRow = 6;
        int nCol = 8;
        int nSnake = 3;

        int[][] matrix = new int[nRow][nCol];
        Random rand = new Random();
        for(int i=0; i<nSnake; i++) {
            matrix[rand.nextInt(nRow)][rand.nextInt(nCol)] = 1;
        }

        drawMatrix(matrix);
    }

    private static void drawMatrix(int[][] matrix) {
        System.out.println("-".repeat(matrix[0].length * 4 + 1));

        for (int[] ints : matrix) {
            String line = Arrays.stream(ints)
                    .boxed()
                    .map(String::valueOf)
                    .collect(Collectors.joining(" | ", "| ", " |"));
            System.out.println(line);

            System.out.println("-".repeat(matrix[0].length * 4 + 1));
        }
    }
}
