package com.test.java.algorithm.code.dynamic;

import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Micheal on 2020/11/21.
 */
public class DynamicTestV1 {
    public static void main(String[] args) {
        int array[] = {9, 11, 8, 5, 7, 12, 16, 14};
        int giftArray[][] = {
                {1, 10, 3, 8},
                {12, 2, 9, 6},
                {5, 7, 4, 11},
                {3, 7, 16, 5}
        };
        DynamicTestV1 test = new DynamicTestV1();
//        int arrayTest[] = {10, 9, 2, 5, 3, 7, 101, 18};
//        System.out.println(test.maxUpSub(arrayTest));
//        String ss = "abcabcbb";
//        System.out.println(test.lengthOfLongestSubstring(ss));
//        int a = 10;
//        int b = 5;
//        a = a ^ b;
//        b = a ^ b;
//        a = a ^ b;
//        System.out.println("a:" + a + " b:" + b);
        int each[] = {1, 3, 1, 1};
        System.out.println(test.singleNumber(each));
    }

    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = 0;

        for (int i = 0; i < 32; i++) {
            int count = 0;
            int index = 1 << i;
            for (int j : nums) {
                if ((index & j) != 0) {
                    count++;
                }
            }
            if (count % 3 == 1) {
                result = result | index;
            }
        }
        return result;
    }


//    public int singleNumber(int nums[]) {
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//        int result = 0;
//        for (int i = 0; i < 32; i++) {
//            int count = 0;
//            int index = 1 << i;
//            for (int j : nums) {
//                if ((index & j) != 0) {
//                    count++;
//                }
//            }
//            if (count % 3 == 1) {
//                result = result | index;
//            }
//        }
//        return result;
//    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> indexMap = new HashMap<>();
        int result = 0;
        int dp = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer orgIndex = indexMap.getOrDefault(c, -1);
            indexMap.put(c, i);
            if (dp < i - orgIndex) {
                //当前不含重复字符
                dp = dp + 1;
            } else {
                dp = i - orgIndex;
            }
            result = Math.max(dp, result);
        }
        return result;
    }


    //最长不含重复字符的子串
    public int logNoRepeatV1(String str) {
        Map<Character, Integer> map = Maps.newHashMap();
        int res = 0;
        int dp = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            Integer larstIndex = map.getOrDefault(c, -1);
            map.put(c, i);
            if (dp < i - larstIndex) {
                dp = dp + 1;
            } else {
                dp = i - larstIndex;
            }
            res = Math.max(dp, res);
        }
        return res;
    }

    /**
     * 最大上升子序列
     *
     * @param array
     * @return
     */
    public int maxUpSub(int array[]) {
        int dp[] = new int[array.length];
        dp[0] = 1;
        int max = dp[0];
        for (int i = 1; i < array.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (array[i] > array[j] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    max = Math.max(dp[i], max);
                }
            }
        }
        return max;
    }

    public int maxGift(int array[][]) {
        int row = array.length;
        int column = array[0].length;
        int result[][] = new int[row][column];
        for (int i = 0; i < row; i++) {
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
        return result[row - 1][column - 1];
    }

}
