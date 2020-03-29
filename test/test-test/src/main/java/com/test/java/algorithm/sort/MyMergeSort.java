package com.test.java.algorithm.sort;

/**
 * Created by Micheal on 2020/3/25.
 */
public class MyMergeSort {
    public static void main(String[] args) {
        int array[] = {2, 3, 10, 1};
        mergeSort(array, 0, array.length - 1);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void sort(int array[], int start, int middle, int end) {
        int temp[] = new int[end - start + 1];
        int left = start;
        int right = middle + 1;
        int index = start;
        while (left <= middle && right <= end) {
            if (array[left] >= array[right]) {
                temp[index-start] = array[right];
                right++;
            } else {
                temp[index-start] = array[left];
                left++;
            }
            index++;
        }
        while (left <= middle) {
            temp[index-start] = array[left];
            index++;
            left++;
        }
        while (right <= end) {
            temp[index-start] = array[right];
            index++;
            right++;
        }
        for (int i = 0; i < temp.length; i++) {
            array[i + start] = temp[i];
        }
    }

    public static void mergeSort(int array[], int start, int end) {
        if (start < end) {
            int middle = (start + end) / 2;
            mergeSort(array, start, middle);
            mergeSort(array, middle + 1, end);
            sort(array, start, middle, end);
        }
    }
}
