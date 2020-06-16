package com.test.java.algorithm.array;

/**
 * Created by Micheal on 2020/4/8.
 * 连续子数组的最大和
 */
public class MaxSubSumArray {
    public static void main(String[] args) {
        int array[] = {2, -1, -1, -1};
        System.out.println(maxSubArray(array));
    }

    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
