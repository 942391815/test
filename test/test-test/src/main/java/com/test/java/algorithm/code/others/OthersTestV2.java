package com.test.java.algorithm.code.others;

import com.test.java.algorithm.offer.ArrayUtil;

import java.util.*;

import static jdk.nashorn.internal.objects.Global.print;

/**
 * Created by Micheal on 2020/11/22.
 */
public class OthersTestV2 {
    public static void main(String[] args) {
        OthersTestV2 othersTest = new OthersTestV2();
//        double[] doubles = othersTest.twoSum(2);
//        ArrayUtil.printArray(doubles);
        int coins[] = {1, 2, 5};
        int amount = 5;
//        System.out.println(othersTest.coinChange(coins, amount));
//        System.out.println(othersTest.changeV1(coins, amount));
//        System.out.println(othersTest.permutation("baa"));

//        System.out.println(Integer.MAX_VALUE / 10);
//        System.out.println(othersTest.strToIntTwo("   -42"));
        int array[] = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] result = othersTest.maxSlidingWindow(array, 3);
        ArrayUtil.printArray(result);

        System.out.println();
        int arrayTemp[][] = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        othersTest.spiralOrder(arrayTemp);
    }

    public int[] spiralOrder(int array[][]) {
        if (array == null || array.length == 0) {
            return new int[0];
        }
        int row = array.length;
        int column = array[0].length;
        int start = 0;
        while (row > start * 2 && column > start * 2) {
            printArray(array, row, column, start);
            start++;
        }
        return null;
    }

    private void printArray(int array[][], int row, int column, int start) {
        int endColumn = column - start - 1;
        int endRow = row - start - 1;
        //从左到右
        for (int i = start; i <= endColumn; i++) {
            System.out.print(array[start][i] + "\t");
        }
        //从上到下
        if (start < endRow) {
            for (int i = start + 1; i <= endRow; i++) {
                System.out.print(array[i][endColumn] + "\t");
            }
        }
        //从下到上
        if (start < endColumn && start < endRow) {
            for (int i = endColumn - 1; i >= start; i--) {
                System.out.print(array[endRow][i] + "\t");
            }
        }
        if (start < endColumn && start < endRow - 1) {
            for (int i = endRow - 1; i >= start + 1; i--) {
                System.out.print(array[i][start] + "\t");
            }
        }

    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }
        int result[] = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && deque.getLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
        }
        result[0] = deque.getFirst();
        for (int i = k, j = 1; i < nums.length; i++, j++) {
            if (!deque.isEmpty() && deque.getFirst() == nums[i - k]) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && deque.getLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
            result[j] = deque.getFirst();
        }
        return result;
    }

    public int strToIntTwo(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        boolean positive = true;
        boolean flag = true;
        char[] chs = str.trim().toCharArray();
        StringBuffer sb = new StringBuffer();
        for (char ch1 : chs) {
            if (sb.length() == 0 && flag && (ch1 == '-' || ch1 == '+')) {
                positive = ch1 == '+';
                flag = false;
            } else if (ch1 >= '0' && ch1 <= '9') {
                sb.append(ch1);
            } else {
                break;
            }
        }
        if (sb.length() == 0) {
            return 0;
        }
        String curStr = sb.toString();
        char[] curChs = curStr.toCharArray();
        int limit = Integer.MAX_VALUE / 10;
        int num = 0;
        for (char ch : curChs) {
            if (num > limit || (num == limit && ch >= '7')) {
                return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            } else {
                num = num * 10 + ch - '0';
            }
        }
        return positive ? num : -num;
    }

    public int strToInt(String str) {
        //str为null，返回0
        if (str == null) {
            return 0;
        }
        //记录当前可能的数字是正数还是负数
        boolean positive = true;

        //记录-、+是否出现，并且只能出现一次
        boolean flag = true;

        //str.trim()，去掉前后空格，其实这里应该自己写一个方法，有点偷懒了
        char[] chs = str.trim().toCharArray();

        //记录可能的数值
        StringBuilder sb = new StringBuilder();
        for (char ch1 : chs) {
            //正负号只能出现一次，并且前面没有数字，否则无效
            if (sb.length() == 0 && flag && (ch1 == '-' || ch1 == '+')) {
                positive = ch1 == '+';
                flag = false;
                //如果字符在'0'～'9'就记录当前字符
            } else if (ch1 >= '0' && ch1 <= '9') {
                sb.append(ch1);
            } else {
                //出现非正负号、数字字符，退出循环
                break;
            }
        }
        //如果没有有效的数字，返回0
        if (sb.length() == 0) {
            return 0;
        }
        String curStr = sb.toString();
        char[] curChs = curStr.toCharArray();

        int limit = Integer.MAX_VALUE / 10;
        int num = 0;
        for (char ch : curChs) {
            // 因为有可能num*10就溢出了，也有可能num *10 + ch - '0'才溢出（这里的溢出指超过Integer的范围）
            // 如果当前数字大于Integer.MAX_VALUE / 10，再*10 + ch - '0'肯定溢出
            // Integer.MAX_VALUE / 10 = 214748364、Integer.MAX_VALUE = 2147483647
            // 如果当前数字==Integer.MAX_VALUE / 10，ch就不能大于'7'
            if (num > limit || (num == limit && ch > '7')) {
                //溢出的话，根据正负号返回相应的极值
                return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            } else {
                num = num * 10 + ch - '0';
            }
        }
        //有效数字没有溢出，返回对应的结果
        return positive ? num : -num;
    }

    List<List<Character>> resultVal = new ArrayList<>();

    public String[] permutation(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        List<Character> list = new ArrayList<>();
        boolean visited[] = new boolean[str.length()];
        permutation(0, str, list, visited);
        return (String[]) resultVal.toArray();
    }

    public void permutation(int start, String str, List<Character> list, boolean visited[]) {
        if (list.size() == str.length()) {
            resultVal.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < str.length(); i++) {
            if (visited[i]) {
                continue;
            }
            if (i > 0 && str.charAt(i) == str.charAt(i - 1) && !visited[i - 1]) {
                continue;
            }
            list.add(str.charAt(i));
            visited[i] = true;
            permutation(start, str, list, visited);
            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }

    List<List<Integer>> result = new ArrayList<>();

    public int changeV1(int coins[], int amount) {
        List<Integer> list = new ArrayList<>();
        changeV1(coins, amount, list, 0);
        return result.size();
    }

    public void changeV1(int coins[], int amount, List<Integer> list, int start) {
        for (int i = start; i < coins.length; i++) {
            int temp = amount - coins[i];
            if (temp == 0) {
                list.add(coins[i]);
                result.add(new ArrayList<>(list));
                list.remove(list.size() - 1);
            } else if (temp < 0) {
                continue;
            } else {
                list.add(coins[i]);
                changeV1(coins, temp, list, i);
                list.remove(list.size() - 1);
            }
        }
    }


    public int change(int[] coins, int amount) {
        int dp[] = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int j = coin; j < amount + 1; j++) {
                dp[j] = dp[j] + dp[j - coin];
            }
        }
        return dp[amount];

    }

    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return 0;
        }
        int dp[] = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i - coin] != amount + 1) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }
        if (dp[amount] == amount + 1) {
            dp[amount] = -1;
        }
        return dp[amount];
    }

    public double[] twoSum(int n) {
        int dp[][] = new int[n + 1][6 * n + 1];
        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1;
        }
        for (int i = 1; i <= n; i++) {//骰子数目
            for (int j = 1; j <= 6 * n; j++) {//可能的取值
                for (int k = 1; k <= 6 && j >= k; k++) {
                    dp[i][j] = dp[i][j] + dp[i - 1][j - k];
                }
            }
        }
        ArrayUtil.printArray(dp);
        double result[] = new double[5 * n + 1];
        for (int i = n; i <= 6 * n; i++) {
            result[i - n] = (double) dp[n][i] / Math.pow(6, n);
        }
        return result;
    }

}
