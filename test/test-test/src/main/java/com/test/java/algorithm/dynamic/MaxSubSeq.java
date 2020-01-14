package com.test.java.algorithm.dynamic;

/**
 * Created by Micheal on 2020/1/13.
 * 最大上升子序列
 */
public class MaxSubSeq {
    public static void main(String[] args) {
        int arr[] = {1, 2, 10, 8, 0, 90};
        System.out.println(getLargestLen(arr));
    }

    private static int getLargestLen(int[] nums) {
        int dp[] = new int[nums.length];
        dp[0] = 1;
        int max = dp[0];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j <= i - 1; j++) {
                if (nums[i] > nums[j] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        return max;
    }
}
