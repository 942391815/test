package com.test.java;

import org.apache.log4j.chainsaw.Main;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;

/**
 * ��Ȩ����
 * @author micheal
 *
 */
public class AuthorizationTest {
	public static void main(String args[]){
		IniSecurityManagerFactory factory = new IniSecurityManagerFactory("classpath:shiro-permission.ini");
		SecurityManager instance = factory.getInstance();
		SecurityUtils.setSecurityManager(instance);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken simpleToken = new UsernamePasswordToken("zhangsan", "123");
		subject.login(simpleToken);
		subject.isAuthenticated();
		//���ڽ�ɫ
		boolean hasRole = subject.hasRole("role1");
		boolean permitted = subject.isPermitted("user:create");
		System.out.println(hasRole+"---"+permitted);
		
	}
}
