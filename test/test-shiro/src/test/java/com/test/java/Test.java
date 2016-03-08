package com.test.java;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
/**
 * shiro ���ų���
 * 1.���������ļ������� ����securityManager
 * 2.����subject����login�����ύ��֤  ModularRealmAuthenticator��֤
 * 3.ModularRealmAuthenticator token��shiro�����ļ��н��жԱ�
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
		//׼������
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
