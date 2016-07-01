package com.test.java.spring.beaninit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
	@Autowired(required=false)
	private CommonService commonService;
	
	public void getAge(){
		System.out.println("getAge()");
		System.out.println(commonService.getAge());
	}
	
}
