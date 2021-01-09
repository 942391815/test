package com.test.java.algorithm.code.second;

import java.util.Stack;

/**
 * Created by qiaogu on 2020/12/25.
 */
public class CQueue {
    Stack<Integer> one = new Stack<Integer>();
    Stack<Integer> two = new Stack<Integer>();

    public static void main(String[] args) {
        CQueue test = new CQueue();
        test.appendTail(1);
        test.appendTail(2);
        test.appendTail(3);
        test.appendTail(4);
        test.appendTail(5);
        test.appendTail(6);

        System.out.println(test.deleteHead());
        System.out.println(test.deleteHead());
        System.out.println(test.deleteHead());
        System.out.println(test.deleteHead());
        System.out.println(test.deleteHead());
        System.out.println(test.deleteHead());
    }

    public CQueue() {

    }

    public void appendTail(int value) {
        one.add(value);
    }

    public int deleteHead() {
        if (two.isEmpty()) {
            while (!one.isEmpty()) {
                two.push(one.pop());
            }
        }
        if (!two.isEmpty()) {
            return two.pop();
        } else {
            return -1;
        }
    }
}
