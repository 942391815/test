package com.test.java.hytrix;

/**
 * Created by Micheal on 2019/4/18.
 */
public class App {
    public static void main(String[] args) {
        HelloCommand command = new HelloCommand();
        String result = command.execute();
        System.out.println(result);
    }
}