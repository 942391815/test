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
	 * ǿ����
	 */
	@Test  
	public void strongReference() {  
	    Object referent = new Object();  
	    /** 
	     * ͨ����ֵ���� StrongReference  
	     */  
	    Object strongReference = referent;  
	    assertSame(referent, strongReference);  
	    referent = null;  
	    System.gc();  
	    assertNotNull(strongReference);  
	}

	/**
	 * ������
	 */
	@Test  
	public void softReference() {  
	    Object referent = new Object();  
	    SoftReference<Object> softRerference = new SoftReference<Object>(referent);  
	  
	    assertNotNull(softRerference.get());  
	      
	    referent = null;  
	    System.gc();  
	      
	    /** 
	     *  soft references ֻ���� jvm OutOfMemory ֮ǰ�Żᱻ����, �������ǳ��ʺϻ���Ӧ�� 
	     */  
	    assertNotNull(softRerference.get());  
	}  
	/**
	 * ������
	 */
	@Test  
	public void weakReference() {  
	    Object referent = new Object();  
	    WeakReference<Object> weakRerference = new WeakReference<Object>(referent);  
	  
	    assertSame(referent, weakRerference.get());  
	      
	    referent = null;  
	    System.gc();  
	      
	    /** 
	     * һ��û��ָ�� referent ��ǿ����, weak reference �� GC ��ᱻ�Զ����� 
	     */  
	    assertNull(weakRerference.get());
	    System.out.println(weakRerference.get());  
	}  
}
