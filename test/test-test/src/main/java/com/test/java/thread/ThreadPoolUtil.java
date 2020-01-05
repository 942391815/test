package com.test.java.thread;

/**
 * Created by qiaogu on 2019/12/30.
 */

public class ThreadPoolUtil implements Runnable {

    private Integer index;

    public ThreadPoolUtil(Integer index) {
        this.index = index;
    }

    @Override
    public void run() {
        try {
            System.out.println(index + "开始处理线程！");
            Thread.sleep(50);
//            System.out.println("线程标识是：" + this.toString());
            //System.out.println(index+"处理结束！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
