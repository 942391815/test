package com.test.java.algorithm.offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Micheal on 2020/10/31.
 * 两个队列实现一个栈
 */
public class Offer09 {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.put(1);
        myStack.put(2);
        System.out.println(myStack.pop());
        myStack.put(3);
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
    }
}

class MyStack {
    Queue<Integer> one = new LinkedList<Integer>();
    Queue<Integer> two = new LinkedList<Integer>();

    public void put(int num) {
        if (!one.isEmpty()) {
            one.add(num);
        } else {
            two.add(num);
        }
    }

    public int pop() {
        if (one.isEmpty() && two.isEmpty()) {
            return 0;
        }
        if (!one.isEmpty()) {
            while (one.size() != 1) {
                two.add(one.poll());
            }
            return one.poll();
        } else {
            while (two.size() != 1) {
                one.add(two.poll());
            }
            return two.poll();
        }
    }
}
