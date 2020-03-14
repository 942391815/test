package com.test.java.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Micheal on 2020/3/14.
 */
public class MyBlockQueue {
    List<String> list = null;
    ReentrantLock lock = null;
    Condition putCondition = null;
    Condition getCondition = null;
    int max = 3;

    public MyBlockQueue() {
        list = new ArrayList<>();
        lock = new ReentrantLock();
        putCondition = lock.newCondition();
        getCondition = lock.newCondition();
    }

    public void put(String element) {
        try {
            lock.lock();
            while (max == list.size()) {
                putCondition.await();
            }
            list.add(element);
            getCondition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public String get() {
        try {
            lock.lock();
            while (list.size() == 0) {
                try {
                    getCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            String remove = list.remove(0);
            putCondition.signalAll();
            return remove;
        } finally {
            lock.unlock();
        }
    }
}
