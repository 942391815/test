package com.test.java;

import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List<Person> list = new ArrayList<>();
		for(int i=0;i<10;i++){
			list.add(new Person(i+"11111111111"));
		}
		for(Person p : list){
			p.setName("wangwu");
		}
		show(list);
	}
	public static void show(List<Person> list){
		for(Person person : list){
			System.out.println(person.getName());
		}
	}
}
class Person{
	public Person(String name){
		this.name = name;
	}
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
