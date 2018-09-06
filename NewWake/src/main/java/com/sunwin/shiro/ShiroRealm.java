package com.sunwin.shiro;

import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;

import com.sunwin.pageModel.User;
import com.sunwin.tools.Const;

public class ShiroRealm extends AuthorizingRealm{

    //授权
	@SuppressWarnings("unchecked")
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.out.println("4");
		Session session=SecurityUtils.getSubject().getSession();
		User user=(User) session.getAttribute("user");
		Set<String> permissions=(Set<String>) session.getAttribute(Const.ROLE);
		if(user!=null){
			 SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			 info.addStringPermissions(permissions);
			 System.out.println("2");
			 return info;
		}else{
			System.out.println("无权进行此操作");
		}
		return null;
	}

	//登陆
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		System.out.println("3");
		String username=(String) token.getPrincipal();
		String password=new String((char[])token.getCredentials());
		UsernamePasswordToken upt=(UsernamePasswordToken) token;
		if(upt.getUsername()!=null&password!=null){
			System.out.println("1");
			return new SimpleAuthenticationInfo(username,password,getName());
		}else{
			throw new AuthenticationException(); 
		}
	}

}
