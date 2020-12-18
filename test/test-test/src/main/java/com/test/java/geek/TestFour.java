package com.test.java.geek;

/**
 * Created by Micheal on 2020/12/11.
 */
public class TestFour {
    public static void main(String[] args) {
        int values[] = {3, 5};
        int total = 4;
        TestFour testFour = new TestFour();
        int minCounts = testFour.getMinCounts(total, values);
        System.out.println(minCounts);

        String ss = "张三s";
        System.out.println(ss.getBytes().length);
    }

    int getMinCounts(int k, int values[]) {
        int result[] = new int[k + 1];
        result[0] = 0;
        for (int i = 1; i < k + 1; i++) {
            result[i] = k + 1;
        }
        for (int i = 1; i < k + 1; i++) {
            for (int coin : values) {
                if (i - coin < 0) {
                    continue;
                }
                result[i] = Math.min(result[i], result[i - coin] + 1);
            }
        }
        return result[k] == k + 1 ? -1 : result[k];
    }



}
