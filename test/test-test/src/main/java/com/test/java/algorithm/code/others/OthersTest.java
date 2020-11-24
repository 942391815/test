package com.test.java.algorithm.code.others;

import org.springframework.util.StringUtils;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Micheal on 2020/11/22.
 */
public class OthersTest {
    public static void main(String[] args) {
        int array[] = {1, 2, 3, 4, 5, 6};
        OthersTest othersTest = new OthersTest();
//        othersTest.cycle(array, 3);

        System.out.println(othersTest.bigSumV1("555", "555"));
    }


    //顺时针打印矩阵
    public void prntArray(int array[][]) {

    }

    //窗口最大值的数组
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < 2) return nums;
        // 双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数值按从大到小排序
        LinkedList<Integer> queue = new LinkedList();
        // 结果数组
        int[] result = new int[nums.length - k + 1];
        // 遍历nums数组
        for (int i = 0; i < nums.length; i++) {
            // 保证从大到小 如果前面数小则需要依次弹出，直至满足要求
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }
            // 添加当前值对应的数组下标
            queue.addLast(i);
            // 判断当前队列中队首的值是否有效
            if (queue.peek() <= i - k) {
                queue.poll();
            }
            // 当窗口长度为k时 保存当前窗口中最大值
            if (i + 1 >= k) {
                result[i + 1 - k] = nums[queue.peek()];
            }
        }
        return result;
    }

    public String bigSumV1(String one, String two) {
        StringBuilder result = new StringBuilder();
        int i = one.length() - 1;
        int j = two.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0 || carry != 0) {
            int numOne = i >= 0 ? one.charAt(i) - '0' : 0;
            int numTwo = i >= 0 ? two.charAt(i) - '0' : 0;
            int sum = numOne + numTwo + carry;
            carry = sum / 10;
            int temp = sum % 10;
            result.append(temp + "");
            i--;
            j--;
        }
        return result.reverse().toString();
    }

    //大数相加
    public String bigSum(String one, String two) {
        if (StringUtils.isEmpty(one) && StringUtils.isEmpty(two)) {
            return "0";
        }
        if (StringUtils.isEmpty(one)) {
            return two;
        }
        if (StringUtils.isEmpty(two)) {
            return one;
        }
        int oneLen = one.length();
        int twoLen = two.length();
        int loops = oneLen > twoLen ? twoLen : oneLen;
        String result = "";
        int temp = 0;
        for (int i = 0; i < loops; i++) {
            char oneC = one.charAt(oneLen - i - 1);
            char twoC = two.charAt(twoLen - i - 1);
            int sum = Integer.parseInt(oneC + "") + Integer.parseInt(twoC + "") + temp;
            if (sum >= 10) {
                temp = 1;
                sum = sum - 10;
            }
            result = sum + "" + result;
        }
        if (loops == oneLen) {
            for (int i = loops; i < twoLen; i++) {
                if (temp > 0) {
                    result = (Integer.parseInt(two.charAt(twoLen - i - 1) + "") + temp) + result;
                    temp = 0;
                } else {
                    result = Integer.parseInt(two.charAt(twoLen - i - 1) + "") + result;
                }
            }
        } else {
            for (int i = loops; i < oneLen; i++) {
                if (temp > 0) {
                    result = (Integer.parseInt(one.charAt(oneLen - i - 1) + "") + temp) + result;
                    temp = 0;
                } else {
                    result = Integer.parseInt(one.charAt(oneLen - i - 1) + "") + result;
                }
            }

        }
        return result;
    }

    //约瑟夫环

    public void cycle(int array[], int num) {
        List<Integer> list = new LinkedList<>();
        for (int each : array) {
            list.add(each);
        }
        int c = (num - 1) % list.size();
        while (list.size() != 0) {
            System.out.print(list.remove(c) + " \t");
            if (list.size() != 0) {
                c = (c + num - 1) % list.size();
            }
        }
    }
}
