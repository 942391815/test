package com.test.java.algorithm.str;

/**
 * Created by Micheal on 2020/4/6.
 */
public class ReverseStr {
    public static void main(String[] args) {
        String s = "a good   example";
        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        String[] split = s.split(" ");
        int start = 0;
        int end = split.length - 1;
        while (start < end) {
            String temp = split[start];
            split[start] = split[end];
            split[end] = temp;
            start++;
            end--;
        }
        StringBuilder result = new StringBuilder();
        for(String each:split){
            if(each.trim().length()==0){
            }else{
                result.append(each).append(" ");
            }
        }
        return result.toString().trim();
    }
}
