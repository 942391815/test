package com.test.java.algorithm.offer;

import java.util.Objects;

/**
 * Created by Micheal on 2020/10/26.
 * 剑指 Offer 05. 替换空格
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * 示例 1：
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 */
public class Offer05 {
    public static void main(String[] args) {
        Offer05 offer05 = new Offer05();
        System.out.println(offer05.replaceSpace(" We are happy "));
    }

    public String replaceSpace(String s) {
        if (Objects.isNull(s)) {
            return null;
        }
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Objects.equals(s.charAt(i), ' ')) {
                len = len + 3;
            } else {
                len = len + 1;
            }
        }
        char result[] = new char[len];
        for (int i = s.length() - 1, j = result.length - 1; i >= 0; i--) {
            if (Objects.equals(s.charAt(i), ' ')) {
                result[j] = '0';
                result[j - 1] = '2';
                result[j - 2] = '%';
                j = j - 3;
            } else {
                result[j] = s.charAt(i);
                j--;
            }
        }
        return new String(result);
    }
}
