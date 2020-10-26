package com.test.java.algorithm.offer;

/**
 * Created by Micheal on 2020/10/26.
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 * 示例 1:
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 * 说明：
 * 用返回一个整数列表来代替打印
 * n 为正整数
 * 链接：https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof
 */
public class Offer17 {
    public static void main(String[] args) {
        Offer17 offer17 = new Offer17();
        ArrayUtil.printArray(offer17.printNumbers(1));
    }

    public int[] printNumbers(int n) {
        if (n <= 0) {
            return new int[0];
        }
        int num = 1;
        while (n > 0) {
            num = num * 10;
            n--;
        }
        int[] result = new int[num - 1];
        for (int i = 1; i < num; i++) {
            result[i - 1] = i;
        }
        return result;
    }
}
