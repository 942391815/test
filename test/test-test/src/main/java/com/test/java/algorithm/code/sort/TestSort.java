package com.test.java.algorithm.code.sort;

/**
 * Created by Micheal on 2020/11/18.
 */
public class TestSort {
    public static void main(String[] args) {
        int num[] = {1, 2, 5, 2, 1, 0, 3};
        TestSort testSort = new TestSort();
        //冒泡排序
//        testSort.bubbleSort(num);
        //快速排序
//        testSort.quickSort(num);
        //堆排序
        //testSort.heapSort(num);
        //归并排序
        testSort.mergeSort(num, 0, num.length - 1);
        testSort.print(num);
    }

    public void mergeSort(int array[], int start, int end) {
        if (start < end) {
            int middle = (start + end) / 2;
            mergeSort(array, start, middle);
            mergeSort(array, middle + 1, end);
            mergeSort(array, start, middle, end);
        }

    }

    public void mergeSort(int[] array, int start, int middle, int end) {
        int temp[] = new int[end - start + 1];
        int left = start;
        int right = middle + 1;
        int index = start;
        while (left <= middle && right <= end) {
            if (array[left] >= array[right]) {
                temp[index - start] = array[right];
                right++;
            } else {
                temp[index - start] = array[left];
                left++;
            }
            index++;
        }
        while (left <= middle) {
            temp[index - start] = array[left];
            index++;
            left++;
        }
        while (right <= end) {
            temp[index - start] = array[right];
            index++;
            right++;
        }
        for (int i = 0; i < temp.length; i++) {
            array[i + start] = temp[i];
        }
    }

    public void print(int num[]) {
        for (int each : num) {
            System.out.print(each + " \t");
        }
    }

    //堆排序
    public void heapSort(int num[]) {
        if (num == null || num.length == 0) {
            return;
        }
        int size = num.length;
        for (int i = num.length / 2; i >= 0; i--) {
            heapSort(num, i, size);
        }
        for (int i = size - 1; i >= 0; i--) {
            int temp = num[0];
            num[0] = num[i];
            num[i] = temp;
            heapSort(num, 0, i);
        }
    }

    public void heapSort(int num[], int index, int size) {
        int larget = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        if (left < size && num[left] > num[larget]) {
            larget = left;
        }
        if (right < size && num[right] > num[larget]) {
            larget = right;
        }
        if (larget != index) {
            swap(num, larget, index);
            heapSort(num, larget, size);
        }
    }

    public void swap(int num[], int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }

    //快速排序
    public void quickSort(int num[]) {
        if (num == null) {
            return;
        }
        quickSort(num, 0, num.length - 1);
    }

    public void quickSort(int num[], int start, int end) {
        if (start >= end) {
            return;
        }
        int key = num[start];
        int low = start;
        int high = end;
        while (low < high) {
            while (low < high && num[high] >= key) {
                high--;
            }
            num[low] = num[high];
            while (low < high && num[low] <= key) {
                low++;
            }
            num[high] = num[low];
        }
        num[low] = key;
        quickSort(num, start, low - 1);
        quickSort(num, low + 1, end);
    }

    //冒泡排序
    public void bubbleSort(int num[]) {
        if (num == null || num.length == 0) {
            return;
        }
        for (int i = 0; i < num.length - 1; i++) {
            for (int j = 0; j < num.length - i - 1; j++) {
                if (num[j] > num[j + 1]) {
                    int temp = num[j];
                    num[j] = num[j + 1];
                    num[j + 1] = temp;
                }
            }
        }
    }
}
