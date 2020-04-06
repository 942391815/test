package com.test.java.algorithm.number;

/**
 * Created by Micheal on 2020/4/6.
 * 查找0到N确实的数字
 */
public class One2N {
    public static void main(String[] args) {
        int num[] = {0, 1, 2, 3, 4, 6};
        System.out.println(missingNumberV1(num));
    }

    public static int missingNumberV1(int[] nums) {
        int low = 0, high = nums.length;
        while (low < high) {
            int mid = (low + high) >> 1;
            if (nums[mid] != mid) high = mid;
            else low = mid + 1;
        }
        return low;
    }

    public static int missingNumber(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] != mid) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return nums[low] == low ? nums[low] + 1 : nums[low] - 1;
    }
}
