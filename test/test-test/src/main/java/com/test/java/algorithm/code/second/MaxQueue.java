package com.test.java.algorithm.code.second;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by qiaogu on 2020/12/25.
 */
public class MaxQueue {
    Queue<Integer> q;
    Deque<Integer> tempQueue;

    public MaxQueue() {
        q = new LinkedList<Integer>();
        tempQueue = new LinkedList<Integer>();
    }

    public int max_value() {
        if (tempQueue.isEmpty()) {
            return -1;
        }
        return tempQueue.peekFirst();
    }

    /**
     * 加入
     *
     * @param value
     */
    public void push_back(int value) {
        while (!tempQueue.isEmpty() && tempQueue.peekLast() < value) {
            tempQueue.pollLast();
        }
        tempQueue.offerLast(value);
        q.offer(value);
    }

    /**
     * 删除
     *
     * @return
     */
    public int pop_front() {
        if (q.isEmpty()) {
            return -1;
        }
        int ans = q.poll();
        if (ans == tempQueue.peekFirst()) {
            tempQueue.pollFirst();
        }
        return ans;
    }
}
