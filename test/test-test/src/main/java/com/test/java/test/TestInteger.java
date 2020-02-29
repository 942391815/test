package com.test.java.test;

/**
 * Created by Micheal on 2020/2/29.
 */
public class TestInteger {
    public static void main(String[] args) {
        int arry[] = {0, 2, 1, 0, 2};
        int trip = trip(arry);
        System.out.println(trip);
    }

    public static int trip(int[] height) {
        int result = 0;
        if (height == null || height.length < 3) {
            //小于3接不到水
            return result;
        }
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        int length = height.length;
        for (int i = 1; i < length; i++) {
            // 记录每个挡板的左/右边的最高挡板高度 L[0]和R[length-1]为0
            left[i] = Math.max(left[i - 1], height[i - 1]);
            right[length - 1 - i] = Math.max(right[length - i], height[length - i]);
        }

        //当前高度小于左边高度和右边最大高度
        for (int i = 0; i < length; i++) {
            if (left[i] > height[i] && right[i] > height[i]) {
                result = result + Math.min(left[i], right[i]) - height[i];
            }
        }
        return result;
    }
}
