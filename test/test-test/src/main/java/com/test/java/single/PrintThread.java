package com.test.java.single;


/**
 * Created by Micheal on 2020/3/13.
 */
public class PrintThread implements Runnable {
    private Integer index;
    private PrintClass printClass;

    public PrintThread(PrintClass printClass, Integer index) {
        this.index = index;
        this.printClass = printClass;
    }

    @Override
    public void run() {
        printClass.print(index);
    }
}
