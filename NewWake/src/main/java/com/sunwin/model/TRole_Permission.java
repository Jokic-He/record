package com.sunwin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_role_permission")
public class TRole_Permission {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "t_id", length = 10)
	private int id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "roles")
	private TRole roles;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "permissions")
	private TPermission permissions;

	public TRole_Permission() {
		super();
	}

	public TRole_Permission(int id, TRole roles, TPermission permissions) {
		super();
		this.id = id;
		this.roles = roles;
		this.permissions = permissions;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TRole getRoles() {
		return roles;
	}

	public void setRoles(TRole roles) {
		this.roles = roles;
	}

	public TPermission getPermissions() {
		return permissions;
	}

	public void setPermissions(TPermission permissions) {
		this.permissions = permissions;
	}

}
