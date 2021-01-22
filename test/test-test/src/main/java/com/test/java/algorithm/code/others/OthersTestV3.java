package com.test.java.algorithm.code.others;

import com.test.java.algorithm.offer.ArrayUtil;

import java.util.*;

/**
 * Created by Micheal on 2020/11/22.
 */
public class OthersTestV3 {
    public static void main(String[] args) {
        OthersTestV3 othersTest = new OthersTestV3();
//        double[] doubles = othersTest.twoSum(2);
//        ArrayUtil.printArray(doubles);
        int coins[] = {1, 2, 5};
        int amount = 5;

        int array[][] = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        othersTest.spiralOrder(array);
    }

    public void spiralOrder(int array[][]) {
        if (array == null || array.length == 0) {
            return;
        }
        int start = 0;
        int row = array.length;
        int column = array[0].length;
        while (row > start * 2 && column > start * 2) {
            spiralOrder(array, row, column, start);
            start++;
        }
    }

    public void spiralOrder(int array[][], int row, int column, int start) {
        int endRow = row - start - 1;
        int endColumn = column - start - 1;

        //从左往右
        for (int i = start; i <= endColumn; i++) {
            System.out.print(array[start][i] + " \t");
        }
        //从上往下
        if (start < endRow) {
            for (int i = start + 1; i <= endRow; i++) {
                System.out.print(array[i][endColumn] + " \t");
            }
        }
        //从右往左
        if (start < endRow && start < endColumn) {
            for (int i = endColumn - 1; i >= start; i--) {
                System.out.print(array[endRow][i] + " \t");
            }
        }
        //从下往上
        if (start < endRow - 1 && start < endColumn) {
            for (int i = endRow - 1; i > start; i--) {
                System.out.print(array[i][start] + "\t");

            }
        }
    }
}