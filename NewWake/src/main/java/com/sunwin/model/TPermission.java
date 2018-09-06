package com.sunwin.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "t_permission")
public class TPermission implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "t_id", length = 100, unique = true)
	private String id;

	// 权限的名称
	@Column(name = "t_pname", length = 50)
	private String pname;
	// 权限(XX:xx)
	@Column(name = "t_permission", length = 100)
	private String permission;
	// 描述
	@Column(name = "t_description", length = 100)
	private String description;
	// 是否开启权限
	@Column(name = "t_available", length = 2)
	private boolean available;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "permissions")
	private Set<TRole_Permission> rp_p = new HashSet<TRole_Permission>();

	public TPermission() {
		super();
	}

	public TPermission(String id, String pname, String permission, String description, boolean available) {
		super();
		this.id = id;
		this.pname = pname;
		this.permission = permission;
		this.description = description;
		this.available = available;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
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
