package com.test.java.algorithm.stack;

import java.util.Stack;

/**
 * Created by Micheal on 2020/2/9.
 * 用栈实现队列功能
 */
public class TestStackForQueue {
    public static void main(String[] args) {
        int array[] = {1, 2, 3, 4, 5, 6, 7, 8};
        testStack(array);
    }

    public static void testStack(int array[]) {
        Stack<Integer> putStack = new Stack<>();
        Stack<Integer> popStack = new Stack<>();
        for (int i = 0; i < array.length; i++) {
            putStack.push(array[i]);
        }
        if (!popStack.isEmpty()) {
            System.out.println(popStack.pop());
        } else {
            while (!putStack.isEmpty()) {
                popStack.push(putStack.pop());
            }
        }
        while (!popStack.isEmpty()) {
            System.out.println(popStack.pop());
        }
    }
}
