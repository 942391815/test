package com.test.java.algorithm.offer;

/**
 * Created by Micheal on 2020/10/29.
 * 二维数组中查找数字
 */
public class Offer04 {
    public static void main(String[] args) {
        int array[][] = {{1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}};
        Offer04 offer04 = new Offer04();
        System.out.println(offer04.find(array, 4, 4, 5));
    }

    public boolean find(int[][] array, int rows, int columns, int number) {
        if (array != null && rows > 0 && columns > 0) {
            int row = 0;
            int column = columns - 1;
            while (row < rows && column >= 0) {
                if (array[row][column] > number) {
                    column--;
                } else if (array[row][column] < number) {
                    row++;
                } else {
                    return true;
                }
            }
        }
        return false;
    }
}
