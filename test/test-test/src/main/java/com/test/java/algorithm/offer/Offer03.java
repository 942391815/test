package com.test.java.algorithm.offer;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.Objects;

/**
 * @Date 2020/10/10 16:33
 * @Created by qiaogu
 */
public class Offer03 {
    public static void main(String[] args) {
        Offer03 offer03 = new Offer03();
        int[] nums = {0, 3, 1, 4, 2, 5, 3};
        System.out.println(offer03.findRepeatNumberOne(nums));
    }

    public int findRepeatNumber(int[] nums) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return -1;
        }
        Map<Integer, Integer> map = Maps.newHashMap();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return nums[i];
            } else {
                map.put(nums[i], nums[i]);
            }
        }
        return -1;
    }

    public int findRepeatNumberOne(int[] nums) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return -1;
        }
        int i = 0;
        while (i < nums.length) {
            if(nums[i]==i){
                i++;
            }else{
                if(nums[nums[i]] == nums[i]){
                    return nums[i];
                }
                int temp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = temp;
            }
        }
        return -1;
    }
}
