package com.test.java.algorithm.str;

import com.alibaba.druid.sql.visitor.functions.Char;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Micheal on 2020/4/1.
 */
public class MaxHeadSubStr {
    public static void main(String[] args) {
//        String strArr[] = {"flower", "flow", "flight"};
//        String maxCommonHead = getMaxCommonHead(strArr);
//        System.out.println(maxCommonHead);
        String strArray[] = {"abcde", "ace"};
//        String maxCommonHead = getMaxSubStr(strArray);
//        System.out.println(maxCommonHead);
        int maxSubStr = getMaxSubStrV1("abcde", "ace");
        System.out.println(maxSubStr);
    }

    public static int getMaxSubStrV1(String one, String two) {
        int oneLen = one.length();
        int twoLen = two.length();
        int dp[][] = new int[oneLen + 1][twoLen + 1];
        for (int i = 1; i <= oneLen; i++) {
            for (int j = 1; j <= twoLen; j++) {
                if (one.charAt(i - 1) == two.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[oneLen][twoLen];
    }

    public static String getMaxSubStr(String[] array) {
        if (array == null || array.length == 0) {
            return "";
        }
        if (array.length == 1) {
            return array[0];
        }
        String res = array[0];
        for (int i = 1; i < array.length; i++) {
            List<Character> list = new ArrayList<>();
            String each = array[i];
            int start = 0;
            int resStart = 0;
            while (resStart < res.length() && start < each.length()) {
                if (res.charAt(resStart) == each.charAt(start)) {
                    list.add(res.charAt(start));
                    resStart++;
                    start++;
                } else {
                    start++;
                }
            }
            res = getString(list);
        }
        return res;
    }

    public static String getMaxCommonSubStr(String str1, String str2) {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); ) {
                if (str1.charAt(i) == str1.charAt(j)) {
                    i++;
                    j++;
                    list.add(str1.charAt(i));
                } else {
                    j++;
                }
            }
        }
        return getString(list);
    }

    static String getString(List<Character> list) {
        if (list == null || list.size() == 0) {
            return "";
        }
        String str = "";
        for (Character each : list) {
            str += each;
        }
        return str;
    }


    public static String getMaxCommonHead(String[] array) {
        if (array == null || array.length == 0) {
            return "";
        }
        if (array.length == 1) {
            return array[0];
        }
        String res = array[0];
        for (int i = 0; i < array.length; i++) {
            String each = array[i];
            if (each == null || each.length() == 0 || each.equals("")) {
                return "";
            }
            int start = 0;
            while (start < res.length() && start < each.length() && res.charAt(start) == each.charAt(start)) {
                start++;
            }
            res = res.substring(0, start);
        }
        return res;
    }
}
