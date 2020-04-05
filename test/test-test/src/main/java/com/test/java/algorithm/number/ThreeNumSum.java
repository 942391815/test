//package com.test.java.algorithm.number;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by Micheal on 2020/4/1.
// * 三数之和
// */
//public class ThreeNumSum {
//    public static void main(String[] args) {
//        int nums[] = {-1, 0, 1, 2, -1, -4};
//        sortArray(nums);
//        System.out.println(nums);
//    }
//
//    public static List<List<Integer>> getThree(int nums[], int target) {
//        sortArray(nums);
//        int start = 0;
//        int end = nums.length - 1;
//        while (start < end) {
//            int sum = nums[start] + nums[end];
//            if (target <= sum) {
//                end--;
//            } else {
//                int middleStart = start + 1;
//                while (middleStart < end) {
//                    if (nums[middleStart] != target - sum) {
//                        middleStart++;
//                    } else {
//                        List<Integer> list = new ArrayList<>();
//                        list.add(start);
//                        list.add(middleStart);
//                        list.add(end);
//                    }
//                }
//            }
//        }
//        return null;
//    }
//
//    public static void sortArray(int nums[]) {
//        int length = nums.length;
//
//        for (int i = 0; i < length; i++) {
//            for (int j = 0; j < length - i - 1; j++) {
//                if (nums[j] > nums[j + 1]) {
//                    int temp = nums[j];
//                    nums[j] = nums[j + 1];
//                    nums[j + 1] = temp;
//                }
//            }
//        }
//    }
//}
