package com.test.java.es;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Micheal on 2020/3/23.
 */
public class Person implements Serializable{
    private String name;
    private String age;
    private List<Integer> addressId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public List<Integer> getAddressId() {
        return addressId;
    }

    public void setAddressId(List<Integer> addressId) {
        this.addressId = addressId;
    }
}
