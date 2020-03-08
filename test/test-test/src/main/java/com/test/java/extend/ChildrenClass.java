package com.test.java.extend;

/**
 * Created by Micheal on 2020/3/7.
 */
public class ChildrenClass extends SuperClass {
    private String name;
    private String address;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
