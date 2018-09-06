package com.sunwin.sys.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sunwin.sys.entity.Department;
import com.sunwin.sys.entity.Permission;
import com.sunwin.sys.entity.Role;
import com.sunwin.sys.entity.User;
import com.sunwin.sys.entity.role_permission;

/**
 * 用户数据库操作类
 * 
 * @author as 何培赟
 *
 */
@Component(value = "sysDao")
public interface sysDao {

	// 根據用戶名查找用戶
	User getUserByName(@Param("username") String username);

	// 修改用户信息
	@Transactional
	void modifyUser(@Param("id") String id, @Param("username") String username, @Param("password") String password,
			@Param("department") String department);

	// 查询所有用户信息
	@Transactional
	List<User> getUsers();

	// 根据id查询对象
	User getUserById(@Param("id") String id);

	// 注册
	@Transactional
	void signup(User user);

	// 查询所有部门
	List<Department> findAllDepartment();
	
	// 查询所有非5级部门
	List<Department> findAllDepartmentEx5();
	
	//根据id查找部门
	Department findDepartmentById(@Param("id")String id);

	// 添加部门
	@Transactional
	void addDepartment(Department d);

	// 根据用户roleid获取role_persmission
	List<role_permission> findPermissionByRoleid(@Param("roleid") String roleid);

	// 根据权限id集合获取权限
	List<Permission> findPermissionByIds(@Param("ids") List<String> ids);

	// 改变状态为未登录
	@Transactional
	void updateLogin(@Param("id") String id, @Param("state") String state, @Param("lastLoginDate") Date lastLoginDate);

	// 获取虚拟路径
	String getUrl();
	
	// 删除用户
	@Transactional
	void deleteUser(@Param("id") String id);

	// 获取在线坐席数量
	int getOnline();

	// 获取未删除用户数量
	int getUpLine();
	
	//获取用户最后登录时间
	Date getLastLogin(@Param("userid")String userid);
	
	//修改用户最后登陆时间
	@Transactional
	void updateLastLogin(@Param("userid")String userid,@Param("lastLoginDate") Date lastLoginDate);
	
	//查询所有角色
	List<Role> getRoles();
}
