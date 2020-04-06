package com.test.java.algorithm.dfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Micheal on 2020/4/5. 字符全排列
 */
public class AllSortArray {
    List<String> res = new LinkedList<>();
    char[] c;

    public static void main(String[] args) {
        AllSortArray allSortArray = new AllSortArray();
        String[] result = allSortArray.permutation("abc");
        printArray(result);
    }

    public static void printArray(String result[]) {
        for (String each : result) {
            System.out.println(each);
        }
    }

    public String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }

    void dfs(int x) {
        if (x == c.length - 1) {
            res.add(String.valueOf(c)); // 添加排列方案
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = x; i < c.length; i++) {
            if (set.contains(c[i])) continue; // 重复，因此剪枝
            set.add(c[i]);
            swap(i, x); // 交换，固定此位为 c[i]
            dfs(x + 1); // 开启固定第 x + 1 位字符
            swap(i, x); // 恢复交换
        }
    }

    void swap(int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }
}
