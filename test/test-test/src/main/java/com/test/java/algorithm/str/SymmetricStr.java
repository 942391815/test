package com.test.java.algorithm.str;

/**
 * Created by Micheal on 2020/2/2.
 * 字符串是否是回文数
 */
public class SymmetricStr {
    public static void main(String[] args) {
        String str = "123";
        System.out.println(isSymmetric(str));
    }

    public static boolean isSymmetric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        char[] chars = str.toCharArray();
        int start = 0;
        int end = chars.length - 1;
        while (start < end) {
            if (chars[start] == chars[end]) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }
}
