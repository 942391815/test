package com.test.java.algorithm.second;

import static com.sun.tools.javac.jvm.ByteCodes.swap;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int array[][] = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        solution.rotate(array);
        solution.print(array);
    }

    public void print(int array[][]) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("");
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[i][j] + " \t");
            }
        }
    }

    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        int n = matrix.length;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }

    private void swap(int matrix, int matrix1) {

    }
}
