package com.test.java.algorithm.find.test;

public class One {
    public static void main(String[] args) {
        int[][] num = num(4, 4);
        System.out.println(num[4][1]);
        System.out.println(num[4][2]);
        System.out.println(num[4][3]);
    }

    public static int[][] num(int row, int column) {
        int[][] arr = new int[row + 1][column + 1];
        arr[0][0] = 1;
        arr[1][0] = 1;
        arr[1][1] = 1;
        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = 1;
        }
        for (int i = 2; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                arr[i][j] = arr[i - 1][j] + arr[i - 1][j - 1];
            }
        }
        return arr;
    }
}