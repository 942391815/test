package com.test.java.algorithm.number;

/**
 * Created by Micheal on 2020/2/9.
 */
public class TestZeroNum {
    public static int numOfZero(int num){
        int count = 0;
        while (num>0){
            count = count+num/5;
            num = num/5;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(numOfZero(7));
        System.out.println(7 * 6 * 5 * 4 * 3 * 2 * 1);
    }

//    public static long numOfZero(long n) {
//        long count = 0;
//        while (n > 0) {
//            count = count + n / 5;
//            n = n / 5;
//        }
//        return count;
//    }
}