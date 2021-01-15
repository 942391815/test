package com.test.java.algorithm.code.others;

import java.util.*;

public class Solution {

    List<String> res = new ArrayList(); //结果字符串数组
    StringBuilder cur = new StringBuilder();

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] result = solution.permutation("abb");
        System.out.println(result);
    }


    public String[] permutation(String s) {
        recur(s);
        return res.toArray(new String[res.size()]);
    }

    //递归：每个字符轮流当第一个，然后对剩余字符排列。结束条件：没有剩余字符，则把当前串加入结果集中【相当于树的遍历】
    void recur(String str) {
        if (str.length() == 0) {
            res.add(cur.toString());
            return;
        }
        Set<Character> set = new HashSet(); //剪枝去重，字符相同的就不必再递归了
        for (int i = str.length() - 1; i >= 0; --i) {
            if (!set.add(str.charAt(i))) {
                continue;
            }
            cur.append(str.charAt(i));
            String substr = str.substring(0, i) + str.substring(i + 1);
            recur(substr);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

    class LRU extends LinkedHashMap<String,String> {
        public LRU(int size){
            super(size);
        }


    }
}
