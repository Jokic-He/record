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
@Table(name="t_Role")
public class TRole implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="t_id",unique=true,length=100)
	private String id;
	
	@Column(name="t_roleName",unique=false,length=100)
	private String roleName;
	
	@Column(name="t_description",length=100)
	private String description;
	
	//是否可用
	@Column(name="t_available",nullable=false)
	private boolean available;
	
	//角色对应用户表
	@OneToMany(fetch=FetchType.LAZY,mappedBy="roleId")
	private Set<TUser> roles=new HashSet<TUser>();
	
	//角色对应RP表
	@OneToMany(fetch=FetchType.LAZY,mappedBy="roles")
	private Set<TRole_Permission> rp=new HashSet<TRole_Permission>();
	
	

	public TRole() {
		super();
	}

	public TRole(String id, String roleName, String description, boolean available) {
		super();
		this.id = id;
		this.roleName = roleName;
		this.description = description;
		this.available = available;
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
