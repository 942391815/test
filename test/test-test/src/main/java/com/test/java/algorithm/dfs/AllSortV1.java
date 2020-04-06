package com.test.java.algorithm.dfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by Micheal on 2020/4/5.
 */
public class AllSortV1 {
    public static void main(String[] args) {
//        permulation("abc");
//        String[] result = permulationV1("abc");
//        for (String each : result) {
//            System.out.println(each);
//        }
        System.out.println(nthUglyNumber(1500));
    }

    public static int nthUglyNumber(int num) {
        int two = 0, three = 0, five = 0;
        int dp[] = new int[num];
        dp[0] = 1;
        for (int i = 1; i < num; i++) {
            int n2 = dp[two] * 2;
            int n3 = dp[three] * 3;
            int n5 = dp[five] * 5;
            dp[i] = Math.min(n2, Math.min(n3, n5));
            if (dp[i] == n2) two++;
            if (dp[i] == n3) three++;
            if (dp[i] == n5) five++;
        }
        return dp[num - 1];
    }

    public static String[] permulationV1(String str) {
        if (str == null) {
            return new String[0];
        }
        Set<String> result = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(str.substring(0, 1));
        while (!queue.isEmpty()) {
            if (queue.peek().length() == str.length()) {
                result.addAll(queue);
                break;
            }
            String temp = queue.poll();
            int i = temp.length();
            for (int j = 0; j <= temp.length(); j++) {
                StringBuilder sb = new StringBuilder(temp);
                sb.insert(j, str.charAt(i));
                queue.offer(sb.toString());
            }
        }
        return result.toArray(new String[0]);
    }

    public static void permulation(String str) {
        if (str == null) {
            return;
        }
        char[] chars = str.toCharArray();
        permulation(chars, 0);
    }

    public static String[] permutation(String s) {
        if (s.isEmpty()) {
            return new String[0];
        }
        Set<String> set = new HashSet<>();
        int i;
        Queue<String> queue = new LinkedList<>();
        queue.offer(s.substring(0, 1));
        while (!queue.isEmpty()) {
            if (queue.peek().length() == s.length()) {    //表明访问到了最后一层，从队列里全部取出进行去重
                set.addAll(queue);
                break;
            }

            String temp = queue.poll();
            i = temp.length();
            for (int j = 0; j <= temp.length(); j++) {      //在该字符串的每个空隙插入新增加的字符，并入队
                StringBuilder sb = new StringBuilder(temp);
                sb.insert(j, s.charAt(i));
                queue.offer(sb.toString());
            }
        }
        return set.toArray(new String[0]);
    }

    public static void permulation(char[] chars, int begin) {
        if (begin == chars.length - 1) {
            System.out.println(chars);
        } else {
            for (int i = begin; i < chars.length; i++) {
                char temp = chars[i];
                chars[i] = chars[begin];
                chars[begin] = temp;
                permulation(chars, begin + 1);

                temp = chars[i];
                chars[i] = chars[begin];
                chars[begin] = temp;
            }
        }
    }
}
