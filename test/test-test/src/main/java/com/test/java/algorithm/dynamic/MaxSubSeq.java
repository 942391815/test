package com.test.java.algorithm.dynamic;

/**
 * Created by Micheal on 2020/1/13.
 * 最大上升子序列
 */
public class MaxSubSeq {
    public static void main(String[] args) {
        int arr[] = {1, 2, 10, 8, 0, 90};
        System.out.println(getLargestLen(arr));
    }

    private static int getLargestLen(int[] array) {
        int[] max = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            max[i] = 1;
        }

        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[i] > array[j] && max[i] < max[j] + 1) {
                    max[i] = max[j] + 1;
                }
            }
        }
        int maxLen = 0;
        for (int i = 0; i < array.length; i++) {
            if (maxLen < max[i]) {
                maxLen = max[i];
            }
        }
        return maxLen;
    }
}
