package com.test.java.algorithm.offer;

/**
 * Created by Micheal on 2020/10/29.
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。
 * 如果有多对数字的和等于s，则输出任意一对即可。
 * 示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]
 * 示例 2：
 * 输入：nums = [10,26,30,31,47,60], target = 40
 * 输出：[10,30] 或者 [30,10]
 * 链接：https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof
 */
public class Offer57 {
    public static void main(String[] args) {
        Offer57 offer57 = new Offer57();
        int[] nums = {10, 26, 30, 31, 47, 60};
        int[] result = offer57.twoSum(nums, 40);
        System.out.println(result[0] + "----" + result[1]);
    }

    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            if (nums[start] + nums[end] > target) {
                end--;
            } else if (nums[start] + nums[end] < target) {
                start++;
            } else {
                int[] result = new int[2];
                result[0] = nums[start];
                result[1] = nums[end];
                return result;
            }
        }
        return new int[0];
    }
}
