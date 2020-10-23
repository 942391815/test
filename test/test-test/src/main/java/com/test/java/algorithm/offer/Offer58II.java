package com.test.java.algorithm.offer;

/**
 * Created by Micheal on 2020/10/23.
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 * 示例 1：
 * 输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 * 示例 2：
 * 输入: s = "lrloseumgh", k = 6
 * 输出: "umghlrlose"
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof
 */
public class Offer58II {
    public static void main(String[] args) {
        Offer58II offer58II = new Offer58II();
        System.out.println(offer58II.reverseLeftWords("lrloseumgh", 6));
    }

    public String reverseLeftWords(String s, int n) {
        if (n == 0) {
            return s;
        }
        int length = s.length();
        int step = n % length;
        char[] result = new char[s.length()];
        int j = 0;
        for (int i = step; i < length; i++) {
            result[j] = s.charAt(i);
            j = j + 1;
        }
        for (int i = 0; i < step; i++) {
            result[j] = s.charAt(i);
            j++;
        }
        return new String(result);
    }
}
