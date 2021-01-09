package com.test.java.algorithm.code.sort;

/**
 * Created by Micheal on 2020/11/19.
 */
public class TestSortV2 {
    public static void main(String[] args) {
        TestSortV2 test = new TestSortV2();
        int array[] = {1, 0, 9, 1, -5, -10, 90, 1, 0, 9, 1, -5, -10, 90};
//        test.bubbleSort(array);
//        test.quickSort(array);
//        test.heapSort(array);
        test.mergeSort(array);
        test.printArray(array);
    }

    private void mergeSort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        mergeSort(array, 0, array.length - 1);
    }

    private void mergeSort(int array[], int start, int end) {
        if (start < end) {
            int middle = (start + end) / 2;
            mergeSort(array, start, middle);
            mergeSort(array, middle + 1, end);
            mergeArray(array, start, middle, end);
        }
    }

    private void mergeArray(int array[], int start, int middle, int end) {
        if (start >= end) {
            return;
        }
        int temp[] = new int[end - start + 1];
        int index = 0;
        int left = start;
        int right = middle + 1;
        while (left <= middle && right <= end) {
            if (array[left] < array[right]) {
                temp[index] = array[left];
                left++;
            } else {
                temp[index] = array[right];
                right++;
            }
            index++;
        }
        while (left <= middle) {
            temp[index] = array[left];
            left++;
            index++;
        }
        while (right <= end) {
            temp[index] = array[right];
            right++;
            index++;
        }

        for (int i = 0; i < temp.length; i++) {
            array[start + i] = temp[i];
        }
    }

    private void heapSort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int size = array.length;
        for (int i = size / 2; i >= 0; i--) {
            heapfiy(array, i, size);
        }
        for (int i = size - 1; i > 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapfiy(array, 0, i);
        }

    }

    private void heapfiy(int array[], int index, int size) {
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
            swap(array, largest, index);
            heapfiy(array, largest, size);
        }

    }

    private void swap(int array[], int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    private void quickSort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int array[], int start, int end) {
        if (start >= end) {
            return;
        }
        int left = start;
        int right = end;
        int index = array[left];
        while (left < right) {
            while (left < right && array[right] >= index) {
                right--;
            }
            array[left] = array[right];
            while (left < right && array[left] <= index) {
                left++;
            }
            array[right] = array[left];
        }
        array[left] = index;
        quickSort(array, start, left - 1);
        quickSort(array, left + 1, end);
    }

    private void bubbleSort(int[] array) {
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


    public void printArray(int array[]) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.println();
    }
}
