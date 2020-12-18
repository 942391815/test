package com.test.java.algorithm.code.dynamic;

/**
 * Created by qiaogu on 2020/12/17.
 */
public class Test {
    public static void main(String[] args) {
        int nums[] = {7, 5, 6, 4};
        Test solution = new Test();
        System.out.println(solution.reversePairs(nums));
    }

    private int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int num[], int left, int right) {
        if (left >= right) {
            return 0;
        }
        int middle = (left + right) / 2;
        int lResult = mergeSort(num, left, middle);
        int rResult = mergeSort(num, middle + 1, right);
        int result = getMergeRsot(num, left, middle, right);
        return lResult + rResult + result;
    }

    private int getMergeRsot(int num[], int left, int middle, int right) {
        int count = 0;
        int temp[] = new int[right - left + 1];
        int leftStart = left;
        int rightStart = middle + 1;
        int index = 0;
        while (leftStart <= middle && rightStart <= right) {
            if (num[leftStart] > num[rightStart]) {
                temp[index] = num[rightStart];
                count = count + middle - leftStart + 1;
                rightStart++;
            } else {
                temp[index] = num[leftStart];
                leftStart++;
            }
            index++;
        }
        while (leftStart <= middle) {
            temp[index] = num[leftStart];
            leftStart++;
            index++;
        }
        while (rightStart <= right) {
            temp[index] = num[rightStart];
            rightStart++;
            index++;
        }
        //copy
        for (int i = 0; i < temp.length; i++) {
            num[left + i] = temp[i];
        }
        return count;
    }
}
