package com.test.java.algorithm.number;

/**
 * Created by Micheal on 2020/3/30.
 */
public class TestNum {
    public static void main(String[] args) {
        System.out.println(digitAtIndex(19999));
//        int i = countOfIntegers(2);
//        System.out.println(i);
    }

    public static int digitAtIndex(int index) {
        if (index < 0) {
            return -1;
        }
        int digits = 1;
        while (true) {
            int nums = countOfIntegers(digits);
            if (index < nums * digits) {
                return digitAtIndex(index, digits);
            }
            index -= digits * nums;
            digits++;
        }
    }

    public static int digitAtIndex(int index, int digists) {
        int number = beginNumber(digists) + index / digists;
        int indexForRight = digists - index % digists;
        for (int i = 1; i < indexForRight; i++) {
            number = number / 10;
        }
        return number % 10;
    }

    public static int beginNumber(int digist) {
        if (digist == 1) {
            return 0;
        }
        return (int) Math.pow(10, digist - 1);
    }

    public static int countOfIntegers(int digist) {
        if (digist == 1) {
            return 10;
        }
        int count = (int) Math.pow(10, digist - 1);
        return 9 * count;
    }
}
