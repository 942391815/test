package com.test.java.algorithm.find.num;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Micheal on 2020/3/24.
 */
public class Solution {
    public static void main(String[] args) {
//        int[][] continuousSequence = findContinuousSequence(9);
////        System.out.println(continuousSequence);
//        int[][] continuousSequenceV1 = findContinuousSequenceV1(9);
//        System.out.println(continuousSequenceV1);
//        int[][] sumMine = getSumMine(9);
//        System.out.println(sumMine);
        int arrray[][] = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int[] ints = spiralOrder(arrray);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]+"\t");
        }
    }

    public static int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return null;
        }
        int start = 0;
        List<Integer> list = new ArrayList();
        int row = matrix.length;
        int column = matrix[0].length;
        while (start * 2 < row && start * 2 < column) {
            printArray(matrix, column, row, start, list);
            start++;
        }
        int result[] = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static void printArray(int[][] matrix, int row, int column, int start, List<Integer> list) {
        int rowEnd = row - start - 1;
        int columnEnd = column - start - 1;
        //从左到右
        for (int i = start; i <= columnEnd; i++) {
            list.add(matrix[start][i]);
        }
        //从上到下
        if (start < rowEnd) {
            for (int i = start + 1; i <= rowEnd; i++) {
                list.add(matrix[i][columnEnd]);
            }
        }
        //从右往左打印
        if (start < rowEnd && start < columnEnd) {
            for (int i = columnEnd - 1; i >= start; i--) {
                list.add(matrix[rowEnd][i]);
            }
        }
        //从下往上打印
        if (start < rowEnd - 1 && start < columnEnd) {
            for (int i = rowEnd - 1; i >= start + 1; i--) {
                list.add(matrix[i][start]);
            }
        }
    }


    public static int[][] getSumMine(int target) {
        if (target <= 2) {
            return null;
        }
        List<int[]> list = new ArrayList<>();
        int min = 1;
        int max = 2;
        int sum = min + max;
        while (min < max && max < target) {
            if (sum < target) {
                max++;
                sum += max;
            } else if (sum > target) {
                sum = sum - min;
                min++;
            } else {
                int temp[] = new int[max - min + 1];
                int j = min;
                for (int i = 0; i < temp.length; i++) {
                    temp[i] = j++;
                }
                list.add(temp);
                sum = sum - min;
                min++;
            }
        }
        return list.toArray(new int[0][]);
    }


    public static int[][] findContinuousSequenceV1(int target) {
        if (target <= 2) {
            return null;
        }
        List<int[]> res = new ArrayList<>();
        // 使用双指针
        int min = 1;
        int max = 2;
        int sum = 0;
        sum = min + max;
        while (min < max && max < target) {
            if (sum < target) {
                max++;
                sum += max;
            } else if (sum > target) {
                sum -= min;
                min++;
            } else {
                int[] temp = new int[max - min + 1];
                int j = min;
                for (int i = 0; i < temp.length; i++) {
                    temp[i] = j++;
                }
                // 添加结果
                res.add(temp);
                sum -= min;
                min++;
            }
        }
        return res.toArray(new int[0][]);
    }

    public static int[][] findContinuousSequence(int target) {
        int array[] = new int[target];
        for (int i = 1; i < target + 1; i++) {
            array[i - 1] = i;
        }
        int sum = 0;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i <= array.length / 2 + 1; i++) {
            List<Integer> each = new ArrayList<Integer>();
            int start = i;
            while (sum < target) {
                sum = sum + array[start];
                each.add(array[start]);
                start++;
            }
            if (sum > target) {
                each.clear();
            } else {
                result.add(new ArrayList<>(each));
                each.clear();
                i = start - 1;
            }
            sum = 0;
        }
        int resultArray[][] = new int[result.size()][];
        for (int row = 0; row < result.size(); row++) {
            resultArray[row] = new int[result.get(row).size()];
            List<Integer> columnList = result.get(row);
            for (int column = 0; column < columnList.size(); column++) {
                resultArray[row][column] = columnList.get(column);
            }
        }
        return resultArray;
    }
}
