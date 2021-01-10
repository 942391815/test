package com.test.java.algorithm.code.dynamic;

import com.test.java.algorithm.offer.TreeNode;

import java.util.*;

/**
 * Created by Micheal on 2020/11/21.
 */
public class DynamicTestV2 {
    public static void main(String[] args) {
        int array[] = {9, 11, 8, 5, 7, 12, 16, 14};
        int giftArray[][] = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        DynamicTestV2 test = new DynamicTestV2();
        //股票的最大利润
//        System.out.println(test.maxProfit(array));
//        System.out.println(test.maxUpSubV1(array));
        //最大上升子序列
//        System.out.println(test.maxUpSub(array));
        //礼物的最大价值
//        System.out.println(test.maxGiftValue(giftArray, giftArray.length, giftArray[0].length));
        //剪绳子
//        System.out.println(test.cutRop(8));
        //最长不含重复字符的子串
//        System.out.println(test.longestStrNoRepeat("arabcacfr"));
        //连续子数组的最大和
        int subArray[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(test.maxSubArray(subArray));
        //全排列
//        int array1[] = {1, 2, 3};
//        List<List<Integer>> permute = test.permute(array1);
//        System.out.println(permute);
//        int num[] = {3, 30, 34, 5, 9};
//        System.out.println(test.minNumber(num));
//        System.out.println(treeNode);
//        int arrayV[] = {1, 2, 3, 4,};
//        System.out.println(test.exchange(arrayV));
        int num[] = {1, 3, -1, -3, 5, 3, 6, 7};
//        int[] ints = test.maxSlidingWindow(num, 3);
//        System.out.println(ints);
    }

    private int maxSubArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int dp[] = new int[array.length];
        dp[0] = array[0];
        int result = dp[0];
        for (int i = 1; i < array.length; i++) {
            dp[i] = array[i];
            if (dp[i - 1] + array[i] > dp[i]) {
                dp[i] = dp[i - 1] + array[i];
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    private int longestStrNoRepeat(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int dp = 0;
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            Integer orDefault = map.getOrDefault(str.charAt(i), -1);
            map.put(str.charAt(i), i);
            if (dp < i - orDefault) {
                dp = dp + 1;
            } else {
                dp = i - orDefault;
            }
            result = Math.max(result, dp);
        }
        return result;
    }

    private int cutRop(int len) {
        if (len <= 4) {
            return len;
        }
        int dp[] = new int[len];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i < len; i++) {
            dp[i] = i;
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] * dp[j]);
            }
        }
        return dp[len - 1];
    }

    private int maxGiftValue(int[][] gift, int row, int column) {
        if (gift == null || gift.length == 0) {
            return 0;
        }
        int dp[][] = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                int up = 0;
                int left = 0;
                if (i > 0) {
                    up = dp[i - 1][j];
                }
                if (j > 0) {
                    left = dp[i][j - 1];
                }
                dp[i][j] = Math.max(up, left) + gift[i][j];
            }
        }
        return dp[row - 1][column - 1];
    }

    //int array[] = {9, 11, 8, 5, 7, 12, 16, 14};
    private int maxUpSub(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int dp[] = new int[array.length];
        int max = 1;
        dp[0] = 1;
        for (int i = 1; i < array.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (array[i] > array[j] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }

    private int maxProfit(int[] array) {
        if (array == null || array.length < 2) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int result = Integer.MIN_VALUE;
        for (int each : array) {
            min = Math.min(min, each);
            result = Math.max(each - min, result);
        }
        return result;
    }

}
