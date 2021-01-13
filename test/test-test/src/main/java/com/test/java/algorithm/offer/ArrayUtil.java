package com.test.java.algorithm.offer;

import java.util.Objects;

/**
 * Created by Micheal on 2020/10/26.
 */
public class ArrayUtil {
    public static void printArray(int[] array) {
        if (Objects.isNull(array)) {
            return;
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " \t");
        }
    }

    public static void printArray(int[][] array) {
        if (Objects.isNull(array)) {
            return;
        }
        int row = array.length;
        int column = array[0].length;
        for (int i = 0; i < row; i++) {
            System.out.println(" \t");
            for (int j = 0; j < column; j++) {
                System.out.print(array[i][j] + " \t");
            }
        }
    }

    public static void printArray(String[] array) {
        if (Objects.isNull(array)) {
            return;
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " \t");
        }
    }

    public static void printArray(double[] array) {
        if (Objects.isNull(array)) {
            return;
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " \t");
        }
    }
}
