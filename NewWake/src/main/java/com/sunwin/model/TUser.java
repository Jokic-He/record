package com.sunwin.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "t_user")
public class TUser {

	@Id
	@Column(name = "t_id", unique = true, length = 40)
	private String id;;

	@Column(name = "t_username", unique = true, length = 40)
	private String username;

	@Column(name = "t_password", length = 200)
	private String password;

	@Column(name = "t_department", length = 40)
	private String department;

	// 创建时间
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date", nullable = false, length = 7)
	private Date createDate = new Date();

	// 邮箱名
	@Column(name = "t_myEmailAccount", length = 60)
	private String myEmailAccount;

	// 邮箱密码
	@Column(name = "t_myEmailPassword", length = 60)
	private String myEmailPassword;

	// 发件人的smpt地址
	@Column(name = "t_myEmailSMTPHost", length = 60)
	private String myEmailSMTPHost;

	// 角色是否被锁定
	@Column(name = "t_locked", length = 2)
	private boolean locked;

	// 用户的角色
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "roleId")
	private TRole roleId;

	public TUser() {
		super();
	}

	public TUser(String id, String username, String password, String department, Date createDate, String myEmailAccount,
			String myEmailPassword, String myEmailSMTPHost, boolean locked, TRole roleId) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.department = department;
		this.createDate = createDate;
		this.myEmailAccount = myEmailAccount;
		this.myEmailPassword = myEmailPassword;
		this.myEmailSMTPHost = myEmailSMTPHost;
		this.locked = locked;
		this.roleId = roleId;
	}

	public TRole getRoleId() {
		return roleId;
	}

	public void setRoleId(TRole roleId) {
		this.roleId = roleId;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getMyEmailAccount() {
		return myEmailAccount;
	}

	public void setMyEmailAccount(String myEmailAccount) {
		this.myEmailAccount = myEmailAccount;
	}

	public String getMyEmailPassword() {
		return myEmailPassword;
	}

	public void setMyEmailPassword(String myEmailPassword) {
		this.myEmailPassword = myEmailPassword;
	}

	public String getMyEmailSMTPHost() {
		return myEmailSMTPHost;
	}

	public void setMyEmailSMTPHost(String myEmailSMTPHost) {
		this.myEmailSMTPHost = myEmailSMTPHost;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
