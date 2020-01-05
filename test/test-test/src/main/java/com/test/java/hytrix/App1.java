package com.test.java.hytrix;

/**
 * Created by Micheal on 2019/4/18.
 * 熔断
 */
public class App1 {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 30; i++) {
            HelloCommand1 command = new HelloCommand1();
            String result = command.execute();
            System.out.println("circuit Breaker is open : " + command.isCircuitBreakerOpen());
            if (command.isCircuitBreakerOpen()) {
                Thread.currentThread().sleep(500);
            }
        }
    }
}