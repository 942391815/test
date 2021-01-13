package com.test.java.algorithm.code.others;

import com.test.java.algorithm.offer.ArrayUtil;

import java.util.*;

/**
 * Created by Micheal on 2020/11/22.
 */
public class OthersTestV1 {
    public static void main(String[] args) {
        int array[] = {1, 2, 3, 10, 5, 6};
        OthersTestV1 othersTest = new OthersTestV1();
//        int tempArray[] = {1, 2, 3, 2, 1, 4};
//        int[] two = othersTest.getTwo(tempArray);
//        System.out.println(two[0] + "---" + two[1]);
//        int single[] = {1, 2, 3, 1, 2, 3, 1, 2, 3, 10};
//        System.out.println(othersTest.singleNumber(single));
//        //约瑟夫环
//        othersTest.cycle(array, 3);
//        //lru
//        System.out.println(othersTest.bigSumV1("555", "555"));
//        int[] result = othersTest.maxSlidingWindow(array, 4);
//        ArrayUtil.printArray(result);
//        othersTest.lruTest();
        //数组中出现次数超过一半的数字
//        int arrayTemp[] = {1,1,2,1};
//        System.out.println(othersTest.moreThanHalf(arrayTemp));
//        System.out.println(2&(-2));

        //十进制转二进制
//        System.out.println(othersTest.ten2Two(2));
        //二进制转十进制
//        System.out.println(othersTest.two2Ten("1000"));
        //字符串是否回文
//        System.out.println(othersTest.isPalindrome("1211"));
//        int tem[] = {1, 0, -5, 100, 20, -100, 500000, 0, 9, 19, 88};
//        othersTest.topK(tem, 3);
//        System.out.println(othersTest.isMatch("aaa", "ab*ac*a"));
//        int tempArray[][] = {
//                {1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9}
//        };
//        othersTest.printArray(tempArray);
//        System.out.println(othersTest.longestPalindrome("avccv"));
        double[] result = othersTest.twoSumV2(2);
        ArrayUtil.printArray(result);
//        String s = "abcabcbb";
//        System.out.println(othersTest.lengthOfLongestSubstringV1(s));
    }

    public String longestPalindromeV1(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        int len = s.length();
        boolean dp[][] = new boolean[len][len];
        int maxStart = 0;
        int maxEnd = 0;
        int maxLen = 0;
        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[i - 1][j + 1])) {
                    dp[i][j] = true;
                    if (i - j > maxLen) {
                        maxLen = Math.max(maxLen, (i - j));
                        maxStart = j;
                        maxEnd = i;
                    }
                }
            }
        }
        return null;
    }

    public int lengthOfLongestSubstringV1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int result = 0;
        int i = -1;
        for (int j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(i, map.get(s.charAt(j)));
            }
            map.put(s.charAt(j), j);
            result = Math.max(result, j - i);
        }
        return result;
    }


    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int i = -1, res = 0;
        for (int j = 0; j < s.length(); j++) {
            if (dic.containsKey(s.charAt(j))) {
                i = Math.max(i, dic.get(s.charAt(j))); // 更新左指针 i
            }
            dic.put(s.charAt(j), j); // 哈希表记录
            res = Math.max(res, j - i); // 更新结果
        }
        return res;
    }

    public double[] twoSumV1(int n) {
        double[] res = new double[5 * n + 1];
        int curSum = n;
        for (int i = 0; i < res.length; i++) {
            res[i] = countSumV1(curSum, n) / Math.pow(6, n);
            curSum++;
        }
        return res;
    }

    private int countSumV1(int curSum, int n) {
        if (n < 0 || curSum < 0) {
            return 0;
        }
        if (curSum == 0 && n == 0) {
            return 1;
        }
        int sum = 0;
        for (int i = 1; i < 7; i++) {
            sum = sum + countSum(curSum - i, n - 1);
        }
        return sum;

    }

    public double[] twoSum(int n) {
        //思路一：遍历 5*n+1种不重复结果，计算每一种不重复结果的组合个数
        double[] res = new double[5 * n + 1];
        int curSum = n;
        for (int i = 0; i < res.length; ++i) {
            res[i] = countSum(curSum, n) / Math.pow(6, n);
            curSum++;
        }
        return res;
    }

    int countSum(int curSum, int n) {
        if (n < 0 || curSum < 0) {
            return 0;
        }
        if (n == 0 && curSum == 0) {
            return 1;
        }
        int sum = 0;
        for (int i = 1; i < 7; i++) {
            sum = sum + countSum(curSum - i, n - 1);
        }
        return sum;
    }

    public double[] twoSumV2(int n) {
        int[][] dp = new int[n + 1][6 * n + 1];//dp[骰子个数][所有可能的值]
        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {//i代表当前骰子的个数
            for (int j = i; j <= 6 * n; j++) {//j代表当前值的和
                for (int k = 1; k <= 6 && k <= j; k++) {//k代表当前筛子的值
                    //状态转移方程： i个骰子和为j += i-1个骰子和为j-k + 第i个骰子值为k
                    dp[i][j] = dp[i][j] + dp[i - 1][j - k];
                }
            }
        }
        ArrayUtil.printArray(dp);
        final double totalNum = Math.pow(6, n);//总次数
        double[] ans = new double[5 * n + 1];
        for (int i = n; i <= 6 * n; i++) {
            ans[i - n] = ((double) dp[n][i]) / totalNum;
        }
        return ans;
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int maxStart = 0;
        int maxEnd = 0;
        int maxLen = 1;
        int strLen = s.length();
        boolean dp[][] = new boolean[strLen][strLen];
        for (int r = 1; r < strLen; r++) {
            for (int l = 0; l < r; l++) {
                if (s.charAt(r) == s.charAt(l) && (r - l <= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    if (r - l + 1 > maxLen) {
                        maxLen = r - l + 1;
                        maxStart = l;
                        maxEnd = r;
                    }
                }
            }
        }
        return s.substring(maxStart, maxEnd + 1);
    }


    public int singleNumber(int num[]) {
        if (num == null || num.length == 0) {
            return -1;
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int index = 1 << i;
            int count = 0;
            for (int each : num) {
                if ((index & each) != 0) {
                    count++;
                }
            }
            if (count % 3 == 1) {
                res = res | index;
            }
        }
        return res;
    }

    public int[] getTwo(int array[]) {
        if (array == null || array.length == 0) {
            return new int[0];
        }
        int res = 0;
        for (int each : array) {
            res = res ^ each;
        }
        int h = 1;
        while ((res & h) == 0) {
            h = h << 1;
        }
        int a = 0;
        int b = 0;
        for (int each : array) {
            if ((each & h) == 0) {
                a = a ^ each;
            } else {
                b = b ^ each;
            }
        }
        int result[] = new int[2];
        result[0] = a;
        result[1] = b;
        return result;
    }

    public void rotate(int[][] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int len = array.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                int temp = array[i][j];
                array[i][j] = array[j][i];
                array[j][i] = temp;
            }
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len / 2; j++) {
                int temp = array[i][j];
                array[i][j] = array[i][len - j - 1];
                array[i][len - j - 1] = temp;
            }
        }
    }

    public int[] maxSlidingWindow(int array[], int k) {
        if (array == null || array.length == 0) {
            return new int[0];
        }
        int result[] = new int[array.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        //构建窗口
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && deque.getLast() < array[i]) {
                deque.removeLast();
            }
            deque.addLast(array[i]);
        }
        result[0] = deque.getFirst();
        for (int i = k, j = 1; i < array.length; i++, j++) {
            if (deque.getFirst() == array[i - k]) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && deque.getLast() < array[i]) {
                deque.remove();
            }
            deque.addLast(array[i]);
            result[j] = deque.getFirst();
        }
        return result;
    }

    private String bigSumV1(String one, String two) {
        int i = one.length() - 1;
        int j = two.length() - 1;
        StringBuffer stringBuffer = new StringBuffer();
        int carry = 0;
        while (i >= 0 || j >= 0 || carry != 0) {
            int numOne = i >= 0 ? one.charAt(i) - '0' : 0;
            int numTwo = j >= 0 ? one.charAt(j) - '0' : 0;
            int sum = numOne + numTwo + carry;
            carry = sum / 10;
            int temp = sum % 10;
            stringBuffer.append(temp + "");
            i--;
            j--;
        }
        return stringBuffer.reverse().toString();
    }

    public int cycle(int[] array, int num) {
        if (array == null || array.length == 0) {
            return -1;
        }
        List<Integer> list = new LinkedList<Integer>();
        for (int each : array) {
            list.add(each);
        }
        int index = (num - 1) % list.size();
        while (list.size() > 1) {
            list.remove(index);
            index = (index + num - 1) % list.size();
        }
        return list.get(0);
    }
}
