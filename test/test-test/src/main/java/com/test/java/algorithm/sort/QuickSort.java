package com.test.java.algorithm.sort;

/**
 * Created by Micheal on 2020/1/9.
 */
public class QuickSort {
    public static void main(String[] args) {
        int array [] = {17,2,5,1,6,7,9,0};
        quickSort(array,0,array.length-1);
        System.out.println(array);
    }
    private static void quickSort(int[] arr, int leftIndex, int rightIndex) {
        if (leftIndex >= rightIndex) {
            return;
        }
        int left = leftIndex;
        int right = rightIndex;
        //待排序的第一个元素作为基准值
        int key = arr[left];
        while (left < right) {
            while (right > left && arr[right] >= key) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= key) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = key;
        quickSort(arr, leftIndex, left - 1);
        quickSort(arr, right + 1, rightIndex);
    }


}