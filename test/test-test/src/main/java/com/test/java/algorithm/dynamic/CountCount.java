package com.test.java.algorithm.dynamic;


import com.test.java.algorithm.list.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Micheal on 2020/3/10.
 */
public class CountCount {

    public static void main(String[] args) {
        int[][] data =
                {
                        {1, 10, 3, 8},
                        {12, 2, 9, 6},
                        {5, 7, 4, 11},
                        {3, 7, 16, 5}
                };

//        int res = maxValueOfGifts(data);
        int res = maxValueV1(data);
        System.out.println(res);
        System.out.println(maxValueV2(data));
    }

    public static void print(int level, Stack<Node> stack) {
        if (stack.isEmpty()) {
            return;
        }
        System.out.print(level);
        Stack<Node> child = new Stack<>();
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            if (node != null) {
                System.out.print(node.value);
                if (level % 2 != 0) {
                    if (node.left != null) {
                        child.push(node.left);
                    }
                    if (node.right != null) {
                        child.push(node.right);
                    }
                } else {
                    if (node.right != null) {
                        child.push(node.right);
                    }
                    if (node.left != null) {
                        child.push(node.left);
                    }
                }
            }
        }
        System.out.println();
        level++;
        print(level, child);
    }

    public static int maxValueV2(int[][] values) {
        if (values == null || values.length == 0) {
            return 0;
        }
        int row = values.length;
        int col = values[0].length;
        int temp[][] = new int[row][col];
        temp[0][0] = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int left = 0;
                int up = 0;
                if (i > 0) {
                    up = temp[i - 1][j];
                }
                if (j > 0) {
                    left = temp[i][j - 1];
                }
                temp[i][j] = Math.max(up, left) + values[i][j];
            }
        }
        return temp[row - 1][col - 1];
    }

    public static int maxValueV1(int[][] values) {
        int result = 0;
        if (values == null) {
            return 0;
        }
        int row = values.length;
        int colum = values[0].length;

        int temp[][] = new int[row][colum];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < colum; j++) {
                int left = 0;
                int up = 0;
                if (i > 0) {
                    up = temp[i - 1][j];
                }
                if (j > 0) {
                    left = temp[i][j - 1];
                }
                temp[i][j] = Math.max(up, left) + values[i][j];
            }
        }
        return temp[row - 1][colum - 1];
    }


    public static int maxValueOfGifts(int[][] values) {
        if (values == null || values.length <= 0 || values[0].length <= 0)
            return 0;
        int rows = values.length;
        int cols = values[0].length;
        int[][] maxValue = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int left = 0;
                int up = 0;
                if (i > 0)
                    up = maxValue[i - 1][j];
                if (j > 0)
                    left = maxValue[i][j - 1];
                maxValue[i][j] = Math.max(up, left) + values[i][j];
            }
        }
        return maxValue[rows - 1][cols - 1];
    }

    public static int getMaxValue(int[][] data) {
        if (data == null) {
            return -1;
        }
        int row = data.length;
        int col = data[0].length;
        int[][] states = new int[row][col];
        states[0][0] = data[0][0];
        // 初始化第一行
        for (int i = 1; i < col; i++) {
            int pre = states[0][i - 1];
            states[0][i] = pre + data[0][i];
        }

        // 初始化第一列
        for (int i = 1; i < row; i++) {
            int pre = states[i - 1][0];
            states[i][0] = pre + data[i][0];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                states[i][j] = Math.max(states[i - 1][j], states[i][j - 1]) + data[i][j];
            }
        }

        return states[row - 1][col - 1];
    }

    public static char find(char[] chars1, char[] chars2) {
        int index1 = chars1.length;
        int index2 = chars2.length;
        int loops = Math.min(chars1.length, chars2.length);
        for (int i = 0; i < loops; i++) {
            if (chars1[i] != chars2[i]) {
                if (index1 < index2) {
                    return chars1[i];
                } else {
                    return chars2[i];
                }
            }
        }
        return ' ';
    }

    /**
     * 找交集
     *
     * @param array1
     * @param array2
     * @return
     */
    public static int[] retainAll(int array1[], int array2[]) {
        if (array1 == null || array2 == null) {
            return null;
        }
        List<Integer> result = new ArrayList<>();
        int lengthArr1 = array1.length;
        int lengthArr2 = array2.length;
        int index1 = 0;
        int index2 = 0;
        while (index1 < lengthArr1 && index2 < lengthArr2) {
            if (array1[index1] > array2[index2]) {
                index2++;
            } else if (array1[index1] < array2[index2]) {
                index1++;
            } else {
                result.add(array1[index1]);
                index1++;
                index2++;
            }
        }
        int[] resultArry = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArry[i] = result.get(i);
        }
        return resultArry;
    }
}
