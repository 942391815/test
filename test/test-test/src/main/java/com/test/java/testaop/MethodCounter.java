package com.test.java.testaop;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * Created by qiaogu on 2017/1/11.
 */
public class MethodCounter implements Serializable{
    private HashMap<String,Integer> map = new HashMap<String, Integer>();
    private int allCount;

    protected  void count(Method m){
        count(m.getName());
        System.out.println(123123);
    }

    private void count(String name) {
        Integer i = map.get(name);
        i= (i!=null)?new Integer(i.intValue()+1):new Integer(1);
        map.put(name,i);
        ++allCount;
    }
    public int getCalls(String methodName){
        Integer i = map.get(methodName);
        return (i!=null?i.intValue():0);
    }
    public int getCalls(){
        return allCount;
    }

    public boolean equals(Object other){
        return (other!=null&&other.getClass()==this.getClass());
    }

    public int hashCode(){
        return getClass().hashCode();
    }
}
