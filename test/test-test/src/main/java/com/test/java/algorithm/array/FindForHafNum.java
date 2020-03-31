package com.test.java.algorithm.array;

/**
 * Created by Micheal on 2020/3/31.
 */
public class FindForHafNum {
    public static void main(String[] args) {
        int arrray[] = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        int halfNum = findHalfNum(arrray);
        System.out.println(halfNum);
    }

    public static int findHalfNum(int array[]) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int target = array[0];
        int count = 1;
        for (int i = 1; i < array.length; i++) {
            if (target == array[i]) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                target = array[i];
                count = 1;
            }
        }
        return target;
    }
}
