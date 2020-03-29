package com.test.java.algorithm.sort;

/**
 * Created by Micheal on 2020/3/27.
 */
public class MergeSortOne {
    public static void main(String[] args) {
        int array[] = {2, 3, 1, 0, -1, -9, 100, 200};
        split(array, 0, array.length - 1);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void split(int array[], int start, int end) {
        if (start < end) {
            int middle = (start + end) / 2;
            split(array, start, middle);
            split(array, middle + 1, end);
            sort(array, start, middle, end);
        }
    }

    public static void sort(int array[], int start, int middle, int end) {
        if (array == null || array.length == 0) {
            return;
        }
        int left = start;
        int right = middle + 1;
        int index = start;
        int temp[] = new int[end - start + 1];
        while (left <= middle && right <= end) {
            if (array[left] >= array[right]) {
                temp[index - start] = array[left];
                left++;
            } else {
                temp[index - start] = array[right];
                right++;
            }
            index++;
        }
        while (left <= middle) {
            temp[index - start] = array[left];
            left++;
            index++;
        }
        while (right <= end) {
            temp[index - start] = array[right];
            right++;
            index++;
        }
        for (int i = 0; i < temp.length; i++) {
            array[i + start] = temp[i];
        }
    }
}
