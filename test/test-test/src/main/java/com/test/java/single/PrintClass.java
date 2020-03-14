package com.test.java.single;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Micheal on 2020/3/14.
 */
public class PrintClass {
    ReentrantLock reentrantLock = null;
    Condition condition = null;

    public PrintClass() {
        reentrantLock = new ReentrantLock();
        condition = reentrantLock.newCondition();
    }

    int currentIndex = 1;

    public void print(Integer index) {
        ReentrantLock lock = this.reentrantLock;
        try {
            lock.lock();
            while (currentIndex != index) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(index);
            currentIndex++;
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
