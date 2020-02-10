package com.test.java.algorithm.dynamic;

/**
 * Created by Micheal on 2020/2/7.
 */
public class Rain {
    public static void main(String[] args) {
        int arry[] = {1,0,5};
        System.out.println(trap(arry));
    }

    public static int trap(int[] array) {
        int left = 0;
        int right = array.length - 1;
        int rightMax = 0;
        int leftMax = 0;
        int res = 0;
        while (left < right) {
            if (array[left] < array[right]) {
                leftMax = Math.max(array[left], leftMax);
                res += leftMax - array[left];
                left++;
            } else {
                rightMax = Math.max(array[right], rightMax);
                res += rightMax - array[right];
                right--;
            }
        }
        return res;
    }


}
