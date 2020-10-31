package com.test.java.algorithm.offer;

/**
 * Created by Micheal on 2020/10/31.
 */
public class Offer13 {
    public static void main(String[] args) {
        Offer13 offer13 = new Offer13();
        System.out.println(offer13.movingCount(2, 3, 1));
    }

    public int movingCount(int m, int n, int k) {
        boolean temp[][] = new boolean[m][n];
        return dfs(0, 0, m, n, k, temp);
    }

    public int dfs(int i, int j, int m, int n, int k, boolean temp[][]) {
        if (i >= m || j >= n || temp[i][j] || k < sum(i, j)) {
            return 0;
        }
        temp[i][j] = true;
        return 1 + dfs(i + 1, j, m, n, k, temp) + dfs(i, j + 1, m, n, k, temp);
    }

    public int sum(int i, int j) {
        int sum = 0;
        while (i != 0) {
            sum = sum + i % 10;
            i = i / 10;
        }
        while (j != 0) {
            sum = sum + j % 10;
            j = j / 10;
        }
        return sum;
    }
}
