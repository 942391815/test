package com.test.java.refreence;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * Created by Micheal on 2019/6/29.
 */
public class Test {
    private int id = 0;

    public static void main(String[] args) throws Exception {
        soft();
//        A a = new A();
//        a.name = "kutear";
//        WeakReference<A> softReference = new WeakReference<A>(a);
//        a = null;
//        int i = 0;
//
//        while (softReference.get() != null) {
//            if (i == 10) {
//                System.gc();
//                System.out.println("GC");
//            }
//            System.out.println(i);
//            i++;
//        }
//        System.out.println("Finish");
    }

    public static void soft() throws Exception {
        Object obj = new Object();
        ReferenceQueue<Object> refQueue = new ReferenceQueue<Object>();
        SoftReference<Object> softRef = new SoftReference<Object>(obj, refQueue);
        System.out.println(softRef.get()); // java.lang.Object@f9f9d8
        System.out.println(refQueue.poll());// null

        // 清除强引用,触发GC
        obj = null;
        System.gc();

        System.out.println(softRef.get());

        Thread.sleep(2200);
        System.out.println(refQueue.poll());
    }

//    public static void soft() throws Exception {
//        Test obj = new Test();
//        ReferenceQueue<Test> refQueue = new ReferenceQueue<Test>();
//        SoftReference<Test> softRef = new SoftReference<Test>(obj, refQueue);
//        System.out.println("get-->>" + softRef.get()+": refQueue :"+refQueue.poll()); // java.lang.Object@f9f9d8
//        // 清除强引用,触发GC
//        obj = null;
//        System.gc();
//
//        Thread.sleep(500);
//        Test test = softRef.get();
//        System.out.println(test);
//        System.out.println("回收后 get-->>" + softRef.get()+": refQueue :"+refQueue.poll()); // java.lang.Object@f9f9d8
//    }

}

class A {
    public String name;

    protected void finalize() throws Throwable {
        System.out.println("Finalize");
    }
}
