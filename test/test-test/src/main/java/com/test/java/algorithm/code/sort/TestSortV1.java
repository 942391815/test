package com.test.java.algorithm.code.sort;

/**
 * Created by Micheal on 2020/11/19.
 */
public class TestSortV1 {
    public static void main(String[] args) {
        TestSortV1 test = new TestSortV1();
        int array[] = {1, 0, 9, 1, -5, -10, 90, 1, 0, 9, 1, -5, -10, 90};
//        test.bubbleSort(array);
//        test.quickSort(array);
//        test.heapSort(array);
        test.mergeSort(array);
        test.printArray(array);
    }

    public void mergeSort(int array[]) {
        mergeSort(array, 0, array.length - 1);
    }

    public void mergeSort(int array[], int start, int end) {
        if (start < end) {
            int middle = (start + end) / 2;
            mergeSort(array, start, middle);
            mergeSort(array, middle + 1, end);
            mergeSort(array, start, middle, end);
        }
    }

    public void mergeSort(int array[], int start, int middle, int end) {
        int temp[] = new int[end - start + 1];
        int index = 0;
        int left = start;
        int right = middle + 1;
        while (left <= middle && right <= end) {
            if (array[left] > array[right]) {
                temp[index] = array[right];
                right++;
                index++;
            } else {
                temp[index] = array[left];
                left++;
                index++;
            }
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
        //copy
        for (int i = 0; i < temp.length; i++) {
            array[start + i] = temp[i];
        }
    }

    public void heapSort(int array[]) {
        if (array == null) {
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

    public void heapSort(int array[], int index, int size) {
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
            heapSort(array, largest, size);
        }
    }

    public void swap(int array[], int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public void quickSort(int array[]) {
        quickSort(array, 0, array.length - 1);
    }

    public void quickSort(int array[], int start, int end) {
        if (start >= end) {
            return;
        }
        int left = start;
        int right = end;
        int key = array[start];
        while (left < right) {
            while (left < right && key <= array[right]) {
                right--;
            }
            array[left] = array[right];
            while (left < right && key >= array[left]) {
                left++;
            }
            array[right] = array[left];
        }
        array[left] = key;
        quickSort(array, start, left);
        quickSort(array, left + 1, end);

    }

    public void bubbleSort(int array[]) {
        for (int i = 0; i < array.length - 1; i++) {
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
    }
}
