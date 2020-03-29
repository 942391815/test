package com.test.java.algorithm.find.num;

/**
 * Created by Micheal on 2020/3/24.
 */
public class Nums {
    public static void main(String[] args) {
        int array[] = {1, 1, 2, 3, 3, 4, 4, 5, 5, 10};
        int temp = array[0];
        for (int i = 1; i < array.length; i++) {
            temp = temp ^ array[i];
        }
        int one = 0;
        int two = 0;
        int flag = temp & -temp;
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & flag) == 0) {
                one = one ^ array[i];
            } else {
                two = two ^ array[i];
            }
        }
        System.out.println(one+"------"+two);

//        System.out.println(3&-3);
//        System.out.println(2&-2);
//        System.out.println(1&-1);
    }
//    public
}
