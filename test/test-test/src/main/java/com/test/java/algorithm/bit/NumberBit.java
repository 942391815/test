package com.test.java.algorithm.bit;

/**
 * Created by Micheal on 2020/4/7.
 * 数组中唯一出现一次的数字
 */
public class NumberBit {
    public static void main(String[] args) {
        int numbers[] = {1, 2, 4, 3, 1, 2, 3, 1, 2, 3};
        System.out.println(findNumberApperaingOnce(numbers));
        System.out.println(findOnceAppear(numbers));
    }
    public static int findOnceAppear(int num[]) {
        if (num == null || num.length == 0) {
            return -1;
        }
        int temp[] = new int[32];
        for (int i = 0; i < num.length; i++) {
            int mask = 1;
            for (int j = 31; j >= 0; j--) {
                if ((num[i] & mask) != 0) {
                    temp[j] = temp[j] + 1;
                }
                mask = mask << 1;
            }
        }
        int result = 0;
        for (int i = 0; i < temp.length; i++) {
            result = result << 1;
            result = result + temp[i] % 3;
        }
        return result;
    }
    public static int findNumberApperaingOnce(int numbers[]) {
        if (numbers == null || numbers.length == 0) {
            return -1;
        }
        int length = numbers.length;
        int bitSum[] = new int[32];
        for (int i = 0; i < length; i++) {
            int bitMask = 1;
            for (int j = 31; j >= 0; j--) {
                int bit = numbers[i] & bitMask;
                if (bit != 0) {
                    bitSum[j] += 1;
                }
                bitMask = bitMask << 1;
            }
        }
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = result << 1;
            result = result + bitSum[i] % 3;
        }
        return result;
    }
}
