package com.test.java.thread.order;

/**
 * Created by Micheal on 2020/9/21.
 */
public class TestOrder {
    public static void main(String[] args) {
        Order order = new Order();
        order.setCode(1);

        for (int i = 10; i > 0; i--) {
            new Thread(new OrderThread(i,order)).start();
        }
    }
}
