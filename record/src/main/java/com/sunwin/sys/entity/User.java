package com.sunwin.sys.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * 用户实体类
 * @author as 何培赟
 *
 */
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;

	private String roleId;

	private String department;

	private String username;

	private String password;

	//创建日期
	private Date createDate;
    
	//最后登陆日期
	private Date lastLoginDate;

	//当前状态  1为已登录 2为未登录 3为已删除
	private int state;
	
	//是否是修改  修改为1
	private String ifEdit;
	
	//绑定的分机号
	private String phoneCode;

	

	public User() {
		super();
	}

	

	public User(String id, String roleId, String department, String username, String password, Date createDate,
			Date lastLoginDate, int state, String ifEdit, String phoneCode) {
		super();
		this.id = id;
		this.roleId = roleId;
		this.department = department;
		this.username = username;
		this.password = password;
		this.createDate = createDate;
		this.lastLoginDate = lastLoginDate;
		this.state = state;
		this.ifEdit = ifEdit;
		this.phoneCode = phoneCode;
	}



	public String getIfEdit() {
		return ifEdit;
	}



	public void setIfEdit(String ifEdit) {
		this.ifEdit = ifEdit;
	}



	public String getPhoneCode() {
		return phoneCode;
	}

	public void setPhoneCode(String phoneCode) {
		this.phoneCode = phoneCode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	

}
