package com.sunwin.service;

import java.util.Set;

import com.sunwin.model.TRole;
import com.sunwin.pageModel.User;

public interface sysI {
	//�û���¼
	User findUserByUsernameAndPassword(String username,String password);
	
	//通过用户名查找用户信息
	User findUserByUsername(String username);
	
	//�û�ע��
	void add(User user);
	
	//�û��޸�
	void update(User user);
	
	//�û�ɾ��
	void deleteById(int id);
	
	public void correlationRoles(String userId, String roleIds); //添加用户-角色关系  
    public void uncorrelationRoles(String userId,String roleIds);// 移除用户-角色关系
    
    public Set<String> findRoles(String username);// 根据用户名查找其角色  
    public Set<String> findPermissions(String username); //根据用户名查找其权限
    
    //根据用户id更改用户角色
    public void updateRole(String userId,TRole role);
    
    

	
	

}
