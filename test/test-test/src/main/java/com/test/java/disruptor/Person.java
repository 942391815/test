package com.test.java.disruptor;

/**
 * Created by qiaogu on 2017/11/15.
 */
public class Person {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(String name) {
        this.name = name;
    }

    private String name;

}
