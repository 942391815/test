package com.test.java.algorithm.circle;

import java.util.LinkedList;

/**
 * Created by Micheal on 2020/2/21.
 */
public class TestCircle {
    public static void main(String[] args) {
        Integer total = 7;
        Integer keyNumber = 3;
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < total; i++) {
            list.addLast(i + 1);
        }
        int index = 0;
        while (list.size() > 1) {
            for (int i = 1; i < keyNumber; i++) {
                if (index == list.size() - 1) {
                    index = 0;
                } else {
                    index++;
                }
            }
            System.out.println(list.get(index));
            list.remove(index);

            if (index > list.size() - 1) {
                index = 0;
            }
        }
        System.out.println(total + "个人围成一圈数数，数到" + keyNumber + "的被淘汰，最后剩下的是第" + list.get(0) + "个人。");
    }
//    public static void main(String[] args) {
//        int num[] = {1, 2, 3, 4, 5, 6, 7};
//        LinkedList<Integer> list = new LinkedList<>();
//        for (int i = 0; i < num.length; i++) {
//            list.add(num[i]+1);
//        }
//        System.out.println(printCircle(list, 3));
//    }

    public static int printCircle(LinkedList<Integer> list, int m) {
        int last = 0;
        int index = 0;
        while (list.size() > 1) {
            for (int i = 0; i < m; i++) {
                if (index == list.size() - 1) {
                    index = 0;
                } else {
                    index++;
                }
            }
            System.out.println(list.get(index));
            list.remove(index);
        }
        return last;
    }
}
