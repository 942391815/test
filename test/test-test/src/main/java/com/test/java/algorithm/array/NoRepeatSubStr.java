package com.test.java.algorithm.array;

import java.util.Objects;

/**
 * Created by Micheal on 2020/3/8.
 * 最长无重复子字符串
 */
public class NoRepeatSubStr {
    public static void main(String[] args) {
        String str = "arabcacfr";
//        int maxSubStr = getMaxSubStr(str);
        int maxSubStrV1 = getMaxSubStrV1(str);
//        System.out.println(maxSubStr);
        System.out.println(maxSubStrV1);
    }

    public static int getMaxSubStrV1(String str) {
        if (Objects.isNull(str) || str.length() == 0) {
            return 0;
        }
        int curLen = 0;
        int maxLen = 0;
        int charIndex[] = new int[26];
        for (int i = 0; i < charIndex.length; i++) {
            charIndex[i] = -1;
        }
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int preIndex = charIndex[chars[i] - 'a'];
            if (preIndex < 0 || i - preIndex > curLen) {
                curLen = curLen + 1;
            } else {
                curLen = i - preIndex;
            }
            charIndex[chars[i] - 'a'] = i;
            maxLen = Math.max(curLen, maxLen);
        }
        return maxLen;
    }


    public static int getMaxSubStr(String str) {
        if (Objects.isNull(str) || str.length() == 0) {
            return 0;
        }
        int maxLength = 0;
        int curLength = 0;
        int charIndex[] = new int[26];
        for (int i = 0; i < 26; i++) {
            charIndex[i] = -1;
        }
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int preIndex = charIndex[chars[i] - 'a'];
            //abacd
            if (preIndex < 0 || i - preIndex > curLength) {
                curLength++;
            } else {
                if (curLength > maxLength) {
                    maxLength = curLength;
                }
                curLength = i - preIndex;
            }
            charIndex[chars[i] - 'a'] = i;
        }
        maxLength = Math.max(curLength, maxLength);
        return maxLength;
    }
}
