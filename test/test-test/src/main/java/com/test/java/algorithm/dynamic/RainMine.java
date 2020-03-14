package com.test.java.algorithm.dynamic;

/**
 * Created by Micheal on 2020/3/13.
 */
public class RainMine {
    public static void main(String[] args) {
        int rain[] = {2, 0, 2};
        System.out.println(rain(rain));
    }

    public static int rain(int rain[]) {
        if (rain == null || rain.length <= 2) {
            return 0;
        }
        int max = 0;
        int left[] = new int[rain.length];
        left[0] = 0;
        for (int i = 1; i < rain.length; i++) {
            left[i] = Math.max(rain[i - 1], left[i - 1]);
        }
        int length = rain.length;
        int right[] = new int[rain.length];
        right[length - 1] = 0;

        for (int i = rain.length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], rain[i + 1]);
        }
        for (int i = 0; i < length; i++) {
            if (left[i] > rain[i] && right[i] > rain[i]) {
                int hight = Math.min(left[i], right[i]);
                max = max + hight - rain[i];
            }
        }
        return max;
    }
}
