package com.test.java.file;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * Created by qiaogu on 2020/12/15.
 */
public class Test {
    public static void main(String[] args) {
        ReferenceQueue<String> referenceQueue = new ReferenceQueue<>();
        String str = new String("abc");
        WeakReference<String> softReference = new WeakReference<>(str, referenceQueue);

        str = null;
        // Notify GC
        System.gc();
        System.out.println(softReference.get()); // abc
        Reference<? extends String> reference = referenceQueue.poll();
        System.out.println(reference); //null

        System.out.println("第二次");
        System.out.println(softReference.get()); // abc
        Reference<? extends String> reference1 = referenceQueue.poll();
        System.out.println(reference1); //null

    }
}
