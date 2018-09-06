package com.sunwin.pageModel;

public class Role {

	private String id;

	private String roleName;

	private String description;

	// 是否可用
	private boolean available;

	// 以下是权限对应角色的字段

	// 权限名
	private String pname;

	// 权限
	private String permission;

	// 权限对应的角色id
	private String role;

	public Role(String id, String roleName, String description, boolean available, String pname, String permission,
			String role) {
		super();
		this.id = id;
		this.roleName = roleName;
		this.description = description;
		this.available = available;
		this.pname = pname;
		this.permission = permission;
		this.role = role;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Role() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

}
