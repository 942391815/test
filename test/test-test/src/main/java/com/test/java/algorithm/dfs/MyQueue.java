package com.test.java.algorithm.dfs;

/**
 * Created by Micheal on 2020/3/30.
 */
public class MyQueue {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue(3);
        queue.append(1);
        queue.append(2);
        queue.append(3);
        queue.append(4);
        queue.append(5);

        System.out.println(queue.get(0));
        System.out.println(queue.get(1));
        System.out.println(queue.get(2));
    }

    Object[] element = null;
    int size = 0;
    int write = 0;
    int head = 0;
    int minWrite = 0;

    public MyQueue(int size) {
        element = new Object[size];
        this.size = size;
    }

    public void append(int data) {
        if (write < element.length) {
            if (element[write] != null) {
                head++;
            }
            element[write] = data;
            write++;
        } else {
            write = 0;
            head++;
            element[write] = data;
            write++;
            if (head == size - 1) {
                head = 0;
            }
        }
    }

    public Object get(int index) {
        int newHead = head + index;
        if (newHead >= size) {
            newHead = newHead % size;
        }
        return element[newHead];
    }

    public void elementPrint() {
        for (int i = 0; i < element.length; i++) {
            System.out.print(element[i] + "\t");
        }
    }

    public void print(Object obj) {
        System.out.print(obj + "\t");
    }

}
