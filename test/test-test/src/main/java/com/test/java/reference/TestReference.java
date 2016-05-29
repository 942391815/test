package com.test.java.reference;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

import org.junit.Test;

public class TestReference {
	public static void main(String[] args) {

	}
	/**
	 * 强引用
	 */
	@Test  
	public void strongReference() {  
	    Object referent = new Object();  
	    /** 
	     * 通过赋值创建 StrongReference  
	     */  
	    Object strongReference = referent;  
	    assertSame(referent, strongReference);  
	    referent = null;  
	    System.gc();  
	    assertNotNull(strongReference);  
	}

	/**
	 * 软引用
	 */
	@Test  
	public void softReference() {  
	    Object referent = new Object();  
	    SoftReference<Object> softRerference = new SoftReference<Object>(referent);  
	  
	    assertNotNull(softRerference.get());  
	      
	    referent = null;  
	    System.gc();  
	      
	    /** 
	     *  soft references 只有在 jvm OutOfMemory 之前才会被回收, 所以它非常适合缓存应用 
	     */  
	    assertNotNull(softRerference.get());  
	}  
	/**
	 * 弱引用
	 */
	@Test  
	public void weakReference() {  
	    Object referent = new Object();  
	    WeakReference<Object> weakRerference = new WeakReference<Object>(referent);  
	  
	    assertSame(referent, weakRerference.get());  
	      
	    referent = null;  
	    System.gc();  
	      
	    /** 
	     * 一旦没有指向 referent 的强引用, weak reference 在 GC 后会被自动回收 
	     */  
	    assertNull(weakRerference.get());
	    System.out.println(weakRerference.get());  
	}  
}
