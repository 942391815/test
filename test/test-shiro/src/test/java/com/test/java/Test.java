package com.test.java;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
/**
 * shiro 入门程序
 * 1.加载配置文件，环境 创建securityManager
 * 2.创建subject调用login方法提交认证  ModularRealmAuthenticator认证
 * 3.ModularRealmAuthenticator token与shiro配置文件中进行对比
 * @author micheal
 *
 */
public class Test {
	public static void main(String[] args) {
		Factory<org.apache.shiro.mgt.SecurityManager> factory = new IniSecurityManagerFactory(
				"classpath:shiro.ini");
		SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		Subject subject = SecurityUtils.getSubject();
		//准备令牌
		UsernamePasswordToken token = new UsernamePasswordToken("zhangsan", "123456");
		subject.login(token);
		boolean authenticated = subject.isAuthenticated();
		System.out.println(authenticated);
//		subject.logout();
//		authenticated = subject.isAuthenticated();
//		System.out.println(authenticated);
		
		System.out.println(subject.isPermitted("create"));
	}
}
