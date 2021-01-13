package com.test.java.algorithm.code.others;

import com.test.java.algorithm.offer.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        System.out.println(othersTest.changeV1(coins, amount));

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
