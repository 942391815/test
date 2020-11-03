package com.test.java.algorithm.sort;

/**
 * Created by Micheal on 2020/11/2.
 */
public class TestSort {
    public static void main(String[] args) {
        int array[] = {6, 7, 5, 1, 0, 4, 6};
        heapfiy(array);
        printArray(array);
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " \t");
        }
    }
//
//    public static void heapfiy(int array[]) {
//        if (array == null || array.length == 0) {
//            return;
//        }
//        int size = array.length;
//        for (int i = size / 2; i >= 0; i--) {
//            heapSort(array, i, size);
//        }
//        for (int i = size - 1; i >= 0; i--) {
//            int temp = array[0];
//            array[0] = array[i];
//            array[i] = temp;
//            heapSort(array, 0, i);
//        }
//    }

    public static void heapfiy(int array[]) {
        if (array == null || array.length == 0) {
            return;
        }
        int size = array.length;
        for (int i = size / 2; i >= 0; i--) {
            heapSort(array, i, size);
        }
        for (int i = size - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapSort(array, 0, i);

        }
    }

    public static void heapSort(int array[], int index, int size) {
        int larget = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        if (left < size && array[left] > array[larget]) {
            larget = left;
        }
        if (right < size && array[right] > array[larget]) {
            larget = right;
        }
        if (larget != index) {
            swap(array, larget, index);
            heapSort(array, larget, size);
        }
    }

    public static void swap(int array[], int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
