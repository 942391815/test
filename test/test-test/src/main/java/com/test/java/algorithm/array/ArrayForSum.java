package com.test.java.algorithm.array;

import java.util.HashMap;

/**
 * Created by Micheal on 2020/4/6.
 */
public class ArrayForSum {
    public static void main(String[] args) {
        int array[] = {3, 4, 7, 2, -3, 1, 4, 2};
        System.out.println(subarraySum(array, 7));
    }

    public static int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
