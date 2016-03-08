package com.test.java;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class CustomRealm extends AuthorizingRealm {
	// 用于授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		String userName = (String)principals.getPrimaryPrincipal();
		List<String> permission = new ArrayList<String>();
		permission.add("create");
		permission.add("delete");
		//....
		SimpleAuthorizationInfo authorzationInfo = new SimpleAuthorizationInfo();
		authorzationInfo.addStringPermissions(permission);
		return authorzationInfo;
	}

	// 用于认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		String userName = (String) token.getPrincipal();
		String password = "123456";
		String realm = "customRealm";
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(userName,
				password, realm);
		return info;
	}
}
