package com.test.java.algorithm.number;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
//        int nthDigit = findNthDigit(2100);
//        System.out.println(nthDigit);
//
//        nthDigit = findNthDigitV2(2100);
//        System.out.println(nthDigit);
//        int array[] = {0, 2};
//        int result = maxProduct(array);
//        System.out.println(result);
//        int array[] = {1, 1, 1};
//        int result = numSubarrayProductLessThanK(array, 1);
//        int resultOne = numSubarrayProductLessThanKV1(array, 100);
//        int v2 = numSubarrayProductLessThanKV2(array, 1);
//        System.out.println(result);
//        System.out.println(resultOne);
//        System.out.println(v2);
        int i = cycelV1(5, 3);
        System.out.println(i);
    }

    public static int cycelV1(int n, int m) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int c = (m - 1) % n;
        while (list.size() != 1) {
            list.remove(c);
            c = (c + m - 1) % list.size();
        }
        return list.get(0);
    }


    public static int cycel(int nums, int loops) {
        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= nums; i++) {
            list.add(i);
        }
        int count = 1;
        while (list.size() > 1) {
            if (count % loops == 0) {
                if (count >= list.size()) {
                    count = 1;
                }
                System.out.println(list.get(count - 1));
                list.remove(count - 1);
            }
            count++;
        }
        return list.get(0);
    }

    public static int numSubarrayProductLessThanKV2(int nums[], int k) {
        if (k <= 0) {
            return 0;
        }
        int left = 0;
        int sum = 0;
        int now = 1;
        for (int right = 0; right < nums.length; right++) {
            now *= nums[right];
            while (now >= k) {
                now = now / nums[left];
                left++;
            }
            sum = sum + right - left + 1;
        }

        return sum;
    }


    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int now = 1, times = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            now *= nums[right];
            while (now >= k) now /= nums[left++];
            times += right - left + 1;
        }
        return times;
    }

    public static int numSubarrayProductLessThanKV1(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int left = 0;
        int times = 0;
        int now = 1;
        for (int right = 0; right < nums.length; right++) {
            now = now * nums[right];
            while (now >= k) {
                now = now / nums[left];
                left++;
            }
            times = times + right - left + 1;
        }
        return times;
    }

    private static int window(int start, int end, int[] nums) {
        int temp = 1;
        for (int i = start; i <= end; i++) {
            temp = temp * nums[i];
        }
        return temp;
    }

    public static int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        max[0] = nums[0];
        min[0] = nums[0];
        int res = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            max[i] = Math.max(Math.max(max[i - 1] * nums[i], min[i - 1] * nums[i]), nums[i]);
            min[i] = Math.min(Math.max(max[i - 1] * nums[i], min[i - 1] * nums[i]), nums[i]);
            res = Math.max(res, max[i]);
        }
        return res;
    }

    public static int findNthDigitV2(int index) {
        double lastSum = 0;
        int digist = 1;
        if (index <= 10) {
            return index;
        }
        double left = index;
        while (left > 0) {
            double num = Math.pow(10, digist - 1) * 9;
            left = left - num;
            if (left < 0) {
                break;
            }
            lastSum = lastSum + num;
            digist++;
        }
        digist = digist - 1;
        int beginIndex = index - (int) lastSum - 1;
        int beginNum = (int) Math.pow(10, digist - 1) * 9;
        int num = beginNum + beginIndex / digist;
        int numberIndex = beginIndex % digist;
        return Integer.toString(num).charAt(numberIndex) - '0';
    }


    public static int findNthDigit(int index) {
        //定义double类型是为了防止数组越界
        double left = (double) index;
        double lastSum = 0;
        int position = 1;
        double num = 0;
        if (index < 10) return index;
        while (left > 0) {
            lastSum = lastSum + num;
            num = 9 * Math.pow(10, position - 1) * position;
            left = left - num;
            position++;
        }
        position = position - 1;
        int beginIndex = index - (int) lastSum - 1;
        int div = (int) Math.pow(10, position - 1);
        int number = div + (beginIndex) / position;
        int numberIndex = beginIndex % position;
        return Integer.toString(number).charAt(numberIndex) - '0';
    }
}