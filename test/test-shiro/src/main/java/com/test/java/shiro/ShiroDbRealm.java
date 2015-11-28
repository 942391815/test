package com.test.java.shiro;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cas.CasRealm;
import org.apache.shiro.cas.CasToken;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;

public class ShiroDbRealm extends CasRealm {
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
//		String username = (String) principals.fromRealm(getName()).iterator()
//				.next();
//		System.out.println(username);
//		// if( username != null ){
//		// 查询用户授权信息
//		// Collection<String> pers=businessManager.queryPermissions(username);
//		// if( pers != null && !pers.isEmpty() ){
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//		// for( String each:pers )
//		// info.addStringPermissions( each );
//		info.addStringPermission("admin");
		return info;
		// }
		// }

		// return null;
	}

//	public String getCasServerUrlPrefix() {
//		return "http://192.168.17.222:9999/casserver";
//	}
//
//	public String getCasService() {
//		return "http://192.168.17.222:8282/cas-shiro/auth";
//	}

//	@Override
//	protected AuthenticationInfo doGetAuthenticationInfo(
//			AuthenticationToken token) throws AuthenticationException {
////		List principals = CollectionUtils.asList(new Object[] { userId,
////				attributes });
//		super.doGetAuthenticationInfo(token);
//
//
////		 System.out.println(casToken.getPrincipal());
//		 String ticket = (String) token.getCredentials(); 
//		List principals = null;
//		PrincipalCollection principalCollection = new SimplePrincipalCollection(
//				principals, "zhangsan");
////		// 这里可以拿到Cas的登录账号信息,加载到对应权限体系信息放到缓存中...
////
//		return new SimpleAuthenticationInfo(principalCollection, ticket);
//	}
}