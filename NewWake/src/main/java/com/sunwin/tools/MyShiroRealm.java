package com.sunwin.tools;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;


public class MyShiroRealm extends AuthorizingRealm{
	
	
	//用户
	private String username;
	
	private String password;

	
	/* 
     * 授权
     */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		 Set<String> roleNames = new HashSet<String>();  
	        Set<String> permissions = new HashSet<String>();  
	        roleNames.add("administrator");//添加角色
	        permissions.add("newPage.jhtml");  //添加权限
	        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roleNames);  
	        info.setStringPermissions(permissions);  
	        return info;
	}

	/* 
     * 登录验证
     */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken token1 =  (UsernamePasswordToken) token;
        if(token1.getUsername().equals(username)){
            return new SimpleAuthenticationInfo(username, DecriptUtil.MD5(password), getName());  
        }else{
            throw new AuthenticationException();  
        }
	}

}
