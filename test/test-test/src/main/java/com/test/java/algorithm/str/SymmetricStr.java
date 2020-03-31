package com.test.java.algorithm.str;

/**
 * Created by Micheal on 2020/2/2.
 * 字符串是否是回文数
 */
public class SymmetricStr {
    public static void main(String[] args) {
        String str = "1233211";
//        System.out.println(isSymmetric(str));
        System.out.println(getMaxSubSymmetric(str));
    }

    public static String getMaxSubSymmetric(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        int len = str.length();
        int max = 0;
        int maxStr = 0;
        int maxEnd = 0;
        boolean dp[][] = new boolean[len][len];
        for (int r = 1; r < len; r++) {
            for (int l = 0; l < r; l++) {
                if (str.charAt(r) == str.charAt(l) && (r - l <= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    if (r - l + 1 > max) {
                        max = r - l + 1;
                        maxStr = l;
                        maxEnd = r;
                    }
                }
            }
        }
        return str.substring(maxStr, maxEnd + 1);
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
