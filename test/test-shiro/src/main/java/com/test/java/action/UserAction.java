package com.test.java.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.java.service.UserService;
import com.test.java.util.ResponseResult;

@Controller
public class UserAction {
	@Autowired
	private UserService userService;
	@SuppressWarnings("unchecked")
	@ResponseBody 
	@RequestMapping(value="test", produces ="text/html;charset=UTF-8")
	public ResponseResult getUser(){
		@SuppressWarnings("rawtypes")
		List<Map> result = userService.selectAllUser();
		ResponseResult responseBody = new ResponseResult();
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("result", result);
		responseBody.setResult(map);
		return responseBody;
	}
	@RequestMapping(value="/admin/test")
	public void adminGetUser(){
		Subject subject = SecurityUtils.getSubject();
		if (subject.isAuthenticated()) {
            Object principal = subject.getPrincipal();
           System.out.println(principal);
        }
		
		List<Map> result = userService.selectAllUser();
		System.out.println(result);
	}
}
