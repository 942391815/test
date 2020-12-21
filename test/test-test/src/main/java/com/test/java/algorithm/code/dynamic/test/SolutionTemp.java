package com.test.java.algorithm.code.dynamic.test;

import com.test.java.algorithm.offer.ArrayUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qiaogu on 2020/12/20.
 */
public class SolutionTemp {
    public static void main(String[] args) {
        int[][] array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        SolutionTemp temp = new SolutionTemp();
        ArrayUtil.printArray(temp.spiralOrder(array));
    }

    //螺旋打印数组
    public int[] spiralOrder(int array[][]) {
        List<Integer> list = new ArrayList<>();
        if (array == null || array.length == 0) {
            return new int[0];
        }
        int row = array.length;
        int column = array[0].length;
        int loops = 0;
        while (row > 2 * loops && column > 2 * loops) {
            printArray(array, row, column, loops, list);
            loops++;
        }
        int result[] = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private void printArray(int array[][], int row, int column, int start, List<Integer> list) {
        int endX = column - start - 1;
        int endY = row - start - 1;
        //从左往右
        for (int i = start; i <= endX; i++) {
            list.add(array[start][i]);
        }
        if (start < endY) {
            //从上往下
            for (int i = start + 1; i <= endY; i++) {
                list.add(array[i][endX]);
            }
        }
        if (start < endX && start < endY) {
            //从右往左
            for (int i = endX - 1; i >= start; i--) {
                list.add(array[endY][i]);
            }
        }
        if (start < endX && start < endY - 1) {
            //从下往上
            for (int i = endY - 1; i >= start + 1; i--) {
                list.add(array[i][start]);
            }
        }
    }
}
