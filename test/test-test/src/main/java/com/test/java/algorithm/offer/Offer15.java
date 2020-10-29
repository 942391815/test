package com.test.java.algorithm.offer;

/**
 * Created by Micheal on 2020/10/29.
 * <p>
 * 请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，
 * 有 2 位是 1。因此，如果输入 9，则该函数输出 2。
 * 示例 1：
 * <p>
 * 输入：00000000000000000000000000001011
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 * 示例 2：
 * <p>
 * 输入：00000000000000000000000010000000
 * 输出：1
 * 解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
 * 示例 3：
 * <p>
 * 输入：11111111111111111111111111111101
 * 输出：31
 * 解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
 */
public class Offer15 {
    public static void main(String[] args) {
        Offer15 offer15 = new Offer15();
        int result = offer15.hammingWeight(3);
        System.out.println(result);
    }

    public int hammingWeight(int n) {
        int res = 0;
        while (n > 0) {
            res += n & 1;
            n >>>= 1;
        }
        return res;
    }
}
