package com.test.java.algorithm.sort;

/**
 * Created by Micheal on 2021/02/19.
 */
public class TestSortV1 {
    public static void main(String[] args) {
        int array[] = {6, 7, 5, 1, 0, 4, 6};
//        quickSort(array);
//        heapfy(array);
//        bubbleSort(array);
//        mergeSort(array);
        printArray(array);
    }

    public static void mergeSort(int array[]) {
        if (array == null || array.length == 0) {
            return;
        }
        mergeSort(array, 0, array.length - 1);
    }

    private static void mergeSort(int[] array, int start, int end) {
        if (array == null || array.length == 0) {
            return;
        }
        if (start < end) {
            int middle = (start + end) / 2;
            mergeSort(array, start, middle);
            mergeSort(array, middle + 1, end);
            sort(array, start, middle, end);
        }
    }

    public static void sort(int array[], int start, int middle, int end) {
        int temp[] = new int[end - start + 1];
        int leftStart = start;
        int rightStart = middle + 1;
        int index = 0;
        while (leftStart <= middle && rightStart <= end) {
            if (array[leftStart] < array[rightStart]) {
                temp[index] = array[leftStart];
                leftStart++;
            } else {
                temp[index] = array[rightStart];
                rightStart++;
            }
            index++;
        }
        while (leftStart <= middle) {
            temp[index] = array[leftStart];
            leftStart++;
            index++;
        }

        while (rightStart <= end) {
            temp[index] = array[rightStart];
            rightStart++;
            index++;
        }
        //copy
        for (int i = 0; i < temp.length; i++) {
            array[start + i] = temp[i];
        }
    }

    private static void bubbleSort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void heapfy(int array[]) {
        if (array == null || array.length == 0) {
            return;
        }
        int size = array.length;
        for (int i = size / 2 - 1; i >= 0; i--) {
            //构建堆
            heapfy(array, i, size);
        }
        for (int i = size - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapfy(array, 0, i);
        }
    }

    public static void heapfy(int array[], int index, int size) {
        int largest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        if (left < size && array[left] > array[largest]) {
            largest = left;
        }
        if (right < size && array[right] > array[largest]) {
            largest = right;
        }
        if (largest != index) {
            swapArray(array, largest, index);
            heapfy(array, largest, size);
        }
    }

    private static void swapArray(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " \t");
        }
    }

    public static void quickSort(int array[]) {
        if (array == null || array.length == 0) {
            return;
        }
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int left = start;
        int right = end;
        int key = array[left];
        while (left < right) {
            while (left < right && array[right] >= key) {
                right--;
            }
            array[left] = array[right];
            while (left < right && array[left] <= key) {
                left++;
            }
            array[right] = array[left];
        }
        array[left] = key;
        quickSort(array, start, left - 1);
        quickSort(array, left + 1, end);
    }
}
