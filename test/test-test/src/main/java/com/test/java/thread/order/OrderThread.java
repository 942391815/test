package com.test.java.thread.order;

/**
 * Created by Micheal on 2020/9/21.
 */
public class OrderThread implements Runnable {

    private int code;
    private Order order;

    public OrderThread(int code, Order order) {
        this.code = code;
        this.order = order;
    }

    @Override
    public void run() {
        order.run(code);
    }
}
