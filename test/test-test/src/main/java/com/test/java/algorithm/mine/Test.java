package com.test.java.algorithm.mine;

/**
 * Created by Micheal on 2020/3/23.
 */
public class Test {
    public static void main(String[] args) {
        int[][] array = getArray(4, 4);
        System.out.println(array[4][1]);
    }

    public static int[][] getArray(int row, int column) {
        int array[][] = new int[row + 1][column + 1];
        array[0][0] = 1;
        array[1][0] = 1;
        array[1][1] = 1;
        for (int i = 0; i < array.length; i++) {
            array[i][0] = 1;
        }
        for (int i = 2; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                array[i][j] = array[i - 1][j] + array[i - 1][j - 1];
            }
        }
        return array;
    }
}
