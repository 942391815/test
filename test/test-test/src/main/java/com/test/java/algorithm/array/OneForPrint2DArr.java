package com.test.java.algorithm.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Micheal on 2020/2/9.
 */
public class OneForPrint2DArr {
    public static void main(String[] args) throws Exception {
        int[][] array = {{1, 2, 3}, {4, 5, 6}};
        List<Integer> list = printMatrix(array);
        System.out.println(list);
    }

    public static List<Integer> print(int[][] array) {
        List<Integer> list = new ArrayList<>();
        int row = array.length;
        int column = array[0].length;
        return list;
    }

    public static List<Integer> printMatrix(int[][] array) {
        List<Integer> result = new ArrayList<Integer>();
        if (array.length == 0) return result;
        int n = array.length, m = array[0].length;
        if (m == 0) return result;
        int layers = (Math.min(n, m) - 1) / 2 + 1;//这个是层数
        for (int i = 0; i < layers; i++) {
            for (int k = i; k < m - i; k++) result.add(array[i][k]);//左至右
            for (int j = i + 1; j < n - i; j++) result.add(array[j][m - i - 1]);//右上至右下
            for (int k = m - i - 2; (k >= i) && (n - i - 1 != i); k--) result.add(array[n - i - 1][k]);//右至左
            for (int j = n - i - 2; (j > i) && (m - i - 1 != i); j--) result.add(array[j][i]);//左下至左上
        }
        return result;
    }
}
