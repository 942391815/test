package com.test.java.algorithm.code.find;

/**
 * Created by Micheal on 2020/11/9.
 * 二分查找
 */
public class FindForTwo {
    public static void main(String[] args) {
        int array[] = {1, 2, 5, 9, 11, 15};
        FindForTwo forTwo = new FindForTwo();
        System.out.println(forTwo.findV1(array, 15));
        System.out.println(forTwo.find(array, 15));

    }

    public boolean find(int array[], int num) {
        if (array == null || array.length == 0) {
            return false;
        }
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int middle = (start + end) / 2;
            if (array[middle] > num) {
                end = middle - 1;
            } else if (array[middle] < num) {
                start = middle + 1;
            } else {
                return true;
            }
        }
        return false;
    }


    public boolean findV1(int array[], int num) {
        if (array == null || array.length == 0) {
            return false;
        }
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int middle = (start + end) / 2;
            if (array[middle] > num) {
                end = middle - 1;
            } else if (array[middle] < num) {
                start = middle + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
