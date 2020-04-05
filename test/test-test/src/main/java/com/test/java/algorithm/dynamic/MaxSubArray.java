package com.test.java.algorithm.dynamic;

/**
 * Created by Micheal on 2020/4/1.
 */
public class MaxSubArray {
    public static void main(String[] args) {
        int array[] = {-2, 1, -3};
        System.out.println(maxSubArray(array));
    }

    public static int maxSubArray(int[] nums) {
        int length = nums.length;
        int dp[] = new int[length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }
}
