package com.test.java.algorithm.code.dynamic;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Micheal on 2020/11/21.
 */
public class DynamicTest {
    public static void main(String[] args) {
        int array[] = {9, 11, 8, 5, 7, 12, 16, 14};
        int giftArray[][] = {
                {1, 10, 3, 8},
                {12, 2, 9, 6},
                {5, 7, 4, 11},
                {3, 7, 16, 5}
        };
        DynamicTest test = new DynamicTest();
        //股票的最大利润
//        System.out.println(test.maxProfit(array));
        //最大上升子序列
//        System.out.println(test.maxUpSub(array));
        //礼物的最大价值
//        System.out.println(test.maxGiftValue(giftArray, giftArray.length, giftArray[0].length));
        //剪绳子
//        System.out.println(test.cutRop(8));
        //最长不含重复字符的子串
//        System.out.println(test.longestStrNoRepeatV1("arabcacfr"));
        //连续子数组的最大和
        int subArray[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(test.maxSubArray(subArray));
    }

    //连续最数组的最大和
    public int maxSubArray(int array[]) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int dp[] = new int[array.length];
        dp[0] = array[0];
        int max = dp[0];
        for (int i = 1; i < array.length; i++) {
            dp[i] = Math.max(dp[i - 1] + array[i], array[i]);
            max = Math.max(dp[i], max);
        }
        return max;
    }

    //最长不含重复字符的子串
    public int longestStrNoRepeatV1(String str) {
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        int dp = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            Integer lastI = map.getOrDefault(c, -1);
            map.put(c, i);
            if (dp < i - lastI) {
                dp = dp + 1;
            } else {
                dp = i - lastI;
            }
            res = Math.max(dp, res);
        }
        return res;
    }

    //剪绳子
    public int cutRop(int len) {
        int result[] = new int[len + 1];
        if (len == 0) {
            return 0;
        }
        result[1] = 1;
        result[2] = 2;
        result[3] = 3;
        for (int i = 4; i <= len; i++) {
            int max = result[i];
            for (int j = 1; j <= i / 2; j++) {
                max = Math.max(max, result[i - j] * result[j]);
            }
            result[i] = max;
        }
        return result[len];
    }

    //礼物最大值
    public int maxGiftValue(int array[][], int column, int rows) {
        int result[][] = new int[rows][column];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < column; j++) {
                int left = 0;
                int up = 0;
                if (i > 0) {
                    up = result[i - 1][j];
                }
                if (j > 0) {
                    left = result[i][j - 1];
                }
                result[i][j] = Math.max(up, left) + array[i][j];
            }
        }
        return result[rows - 1][column - 1];
    }

    /**
     * 最大上升子序列
     * 输入: [10,9,2,5,3,7,101,18]
     * 输出: 4
     * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
     */
    public int maxUpSub(int num[]) {
        if (num == null || num.length == 0) {
            return 0;
        }
        int dp[] = new int[num.length];
        dp[0] = 1;
        int max = dp[0];
        for (int i = 1; i < num.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (num[i] > num[j] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }

    //股票最大值
    public int maxProfit(int array[]) {
        if (array == null || array.length < 2) {
            return 0;
        }
        int min = array[0];
        int maxDiff = array[1] - min;
        for (int i = 2; i < array.length; i++) {
            if (array[i - 1] < min) {
                min = array[i - 1];
            }
            int currentDiff = array[i] - min;
            if (currentDiff > maxDiff) {
                maxDiff = currentDiff;
            }
        }
        return maxDiff;
    }

}
