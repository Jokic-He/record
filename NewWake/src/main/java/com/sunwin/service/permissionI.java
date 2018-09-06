package com.sunwin.service;

import java.util.List;
import java.util.Set;

import com.sunwin.model.TPermission;
import com.sunwin.model.TRole;
import com.sunwin.pageModel.Role;

public interface permissionI {
	//创建权限
	public void createPermission(Role role);  
	//删除权限
    public void deletePermission(String permissionId);
    //创建角色
    public void createRole(TRole role);  
    //删除角色
    public void deleteRole(String roleId);  
    
    //获取角色列表
    public List<Role> getRoles();
    
    //根据角色id查找角色
    public TRole findRoleById(String id);
    
    //赋予权限
    public void fuyuquanxian(Role role,TPermission tp);
    
    //根据角色id获取权限集合
    public Set<TPermission> getPermissions(String roleid);
    
    
}
