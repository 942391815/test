package com.test.java.algorithm.number;

/**
 * Created by Micheal on 2020/4/1.
 */
public class SearchNum {
    public static void main(String[] args) {
//        int nums[] = {4, 5, 6, 7, 0, 1, 2};
//        System.out.println(search(nums, 7));
//        int array[] = {7, 1, 5, 3, 6, 4};
//        System.out.println(getMax(array));
//        int temp[] = {7, 6, 4, 3, 1};
//        System.out.println(maxProfit(temp));
//        System.out.println(getMax(temp));
//        int array[] = {1, 3, -1, -3, 5, 3, 6, 7};
//        int k = 3;
        int result[] = {3, 3, 5, 5, 6, 7};
        moveV1(result, 1);
//        int[] tempArray = maxSlidingWindow(result, 3);
//        for (int each : tempArray) {
//            System.out.println(each);
//        }
        for (int each : result) {
            System.out.println(each);
        }
    }

    public static void moveV1(int array[], int step) {
        int reverse = step % array.length;
        reverse(array, 0, array.length - 1);
        reverse(array, 0, reverse - 1);
        reverse(array, reverse, array.length - 1);
    }

    public static void reverse(int array[], int start, int end) {
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }

    public static void move(int array[], int step) {
        if (array == null || array.length == 0) {
            return;
        }
        int len = array.length;
        int temp[] = new int[len];
        for (int i = 0; i < array.length; i++) {
            temp[(i + step) % len] = array[i];
        }
        for (int i = 0; i < len; i++) {
            array[i] = temp[i];
        }
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int length = nums.length;
        int result[] = new int[length - k + 1];
        if (k <= 0) {
            return nums;
        }
        for (int i = 0; i <= length - k; i++) {
            int max = getMax(i, i + k - 1, nums);
            result[i] = max;
        }
        return result;
    }

    public static int getMax(int start, int end, int[] array) {
        int max = array[start];
        for (int i = start + 1; i <= end; i++) {
            max = Math.max(max, array[i]);
        }
        return max;
    }

    public static int getMax(int array[]) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
            int temp = array[i] - min;
            result = Math.max(temp, result);
        }
        return result;
    }


    public static int maxProfit(int[] prices) {
        int maxP = 0;
        int low = Integer.MAX_VALUE;
        for (int p : prices) {
            if (p < low) {
                low = p;
            }
            maxP = Math.max(maxP, p - low);
        }
        return maxP;
    }

    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int middle = (start + end) / 2;
            if (target == nums[middle]) {
                return middle;
            }
            //后半部分有序
            if (nums[middle] < nums[end]) {
                if (nums[middle] < target && target <= nums[end]) {
                    start = middle + 1;
                } else {
                    end = middle - 1;
                }
            } else {
                if (nums[middle] > target && target >= nums[start]) {
                    end = middle - 1;
                } else {
                    start = middle + 1;
                }
            }
        }
        return -1;
    }
}
