package com.test.java.algorithm.str;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Micheal on 2020/2/2.
 */
public class SplitSymmetricStr {
    static List<List<String>> listList = new ArrayList<>();

    public static void main(String[] args) {
        String s = "aab";
        List<List<String>> lists = partition(s);
        for (List<String> each : lists) {
            System.out.println(each);
        }
    }

    public static List<List<String>> partition(String s) {
        nextWords(s, 0, new ArrayList<>());
        return listList;
    }

    private static void nextWords(String str, int index, List<String> list) {
        if (index == str.length()) {
            //所有的结果集
            listList.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < str.length(); i++) {
            //获得一个一个的回文子串
            String subStr = str.substring(index, i + 1);
            if (isPalindrome(subStr)) {
                list.add(subStr);
                nextWords(str, i + 1, list);
                //删除结果集最后一个  然后返回上一层
                list.remove(list.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String s) {
        for (int i = 0; i <= s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}