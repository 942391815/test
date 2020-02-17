package com.test.java.algorithm.dynamic;

/**
 * Created by Micheal on 2020/2/16.
 */
public class Test {
    public static void main(String[] args) {
//        int[] arr = {1, 10, 1, 9};
//        System.out.println(maxProfit(arr));
//        int array[] = {4, 0, 3, 2};
//        System.out.println(findMaxAverage(array, 1));
//        System.out.println(bigCount(-2));
        System.out.println(getMax(10));
    }

    public static int getMax(int num) {
        int max = 0;
        int result[] = new int[num + 1];
        if (num == 0) {
            return 0;
        }
        if (num == 1) {
            return 1;
        }
        if (num == 2) {
            return 2;
        }
        if (num == 3) {
            return 3;
        }
        result[0] = 0;
        result[1] = 1;
        result[2] = 2;
        result[3] = 3;
        int temp = 0;
        for (int i = 4; i <= num; i++) {
            max = 0;
            for (int j = 1; j <= i / 2; j++) {
                temp = result[j] * result[i - j];
                max = Math.max(max, temp);
                result[i] = max;
            }
        }
        return max;
    }

    public static int bigCount(int num) {
        int count = 0;
        while (num != 0) {
            count = count + num & 1;
            num = num >>> 1;
        }
        return count;
    }

    public static double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum = sum + nums[i];
        }
        double temp = sum;
        for (int i = 1; i < nums.length - k + 1; i++) {
            temp = temp - nums[i - 1] + nums[i + k - 1];
            sum = Math.max(sum, temp);
        }
        return sum / k;
    }

    public static int maxProfit(int[] prices) {
        if (prices.length <= 1)
            return 0;
        int min = prices[0], max = 0;
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return max;
    }
}
