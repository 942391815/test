package com.test.java.algorithm.find;

/**
 * Created by Micheal on 2020/3/24.
 */
public class Test {
    public static void foreach(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == 1) {
                    System.out.println(dfsSearch(i, j, array));
                }
            }
        }
    }

    private static int dfsSearch(int i, int j, int[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == 0) {
            return 0;
        }
        System.out.println("[" + i + "," + j + "]");
        grid[i][j] = 0;
        int num = 1;
        num += dfsSearch(i + 1, j, grid);
        num += dfsSearch(i - 1, j, grid);
        num += dfsSearch(i, j + 1, grid);
        num += dfsSearch(i, j - 1, grid);
        return num;

    }

    public static void main(String[] args) {
        int[][] grid = new int[3][3];
        grid[0][0] = 1;
        grid[0][1] = 1;
        grid[0][2] = 0;
        grid[1][0] = 0;
        grid[1][1] = 1;
        grid[1][2] = 1;
        grid[2][0] = 0;
        grid[2][1] = 0;
        grid[2][2] = 0;
        foreach(grid);
    }
}
