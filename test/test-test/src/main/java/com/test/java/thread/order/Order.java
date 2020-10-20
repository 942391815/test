package com.test.java.thread.order;

import java.util.Objects;

/**
 * Created by Micheal on 2020/9/21.
 */
public class Order {
    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public synchronized void run(Integer eachCode) {
        if (!Objects.equals(eachCode, code)) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("执行order code" + code);
            code = code + 1;
            this.notifyAll();
        }
    }
}
