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
            System.out.println(array[i] + " \t");
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
}
