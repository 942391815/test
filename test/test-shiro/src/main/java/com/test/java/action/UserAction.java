package com.test.java.action;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.java.service.UserService;

@Controller
public class UserAction {
	@Autowired
	private UserService userService;
	@RequestMapping(value="test")
	public void getUser(){
		List<Map> result = userService.selectAllUser();
		System.out.println(result);
	}
	@RequestMapping(value="/admin/test")
	public void adminGetUser(){
		List<Map> result = userService.selectAllUser();
		System.out.println(result);
	}
}
