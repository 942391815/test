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
        Test obj = new Test();
        ReferenceQueue<Test> refQueue = new ReferenceQueue<Test>();
        WeakReference<Test> softRef = new WeakReference<Test>(obj, refQueue);
        System.out.println(softRef.get()); // java.lang.Object@f9f9d8
        System.out.println(refQueue.poll());// null

        // 清除强引用,触发GC
        obj = null;
        System.gc();

//        Thread.sleep(5000);
        System.out.println(softRef.get());
        Reference<? extends Test> poll = refQueue.poll();
        Test test = poll.get();
        System.out.println(poll + "---" + test);
    }

}

class A {
    public String name;

    protected void finalize() throws Throwable {
        System.out.println("Finalize");
    }
}
