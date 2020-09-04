package com.example.demo.drools.test;


public class Stu {

    private String name;

    private int age;

    private String gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Stu(String name,int age,String gender){
        this.name=name;
        this.age=age;
        this.gender=gender;
    }

}