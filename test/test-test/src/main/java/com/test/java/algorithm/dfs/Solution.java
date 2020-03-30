package com.test.java.algorithm.dfs;

/**
 * Created by Micheal on 2020/3/29.
 */
public class Solution {
    public static void main(String[] args) {
        int array[][] = {{1, 0, 1}, {0, 0, 0}, {1, 0, 1}};
        int result = maxDistance(array);
        System.out.println(result);
    }

    public static int maxDistance(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return -1;
        }
        int max = 0;
        int row = grid.length;
        int column = grid[0].length;
        for (int i = row - 1; i > 0; i--) {
            for (int j = column - 1; j > 0; j--) {
                int result = getDistance(i, j, row, column, grid);
                max = Math.max(max, result);
            }
        }
        return max;
    }

    public static int getDistance(int i, int j, int row, int column, int grid[][]) {
        if (i < 0 || j < 0 || i >= row || j >= column || grid[i][j] == 1) {
            return 0;
        }
        grid[i][j] = 1;
        int result = 1;
        result = result + getDistance(i - 1, j, row, column, grid);
        result = result + getDistance(i + 1, j, row, column, grid);
        result = result + getDistance(i, j + 1, row, column, grid);
        result = result + getDistance(i, j - 1, row, column, grid);
        return result;
    }
}