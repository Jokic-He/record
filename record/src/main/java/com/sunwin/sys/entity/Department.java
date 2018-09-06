package com.sunwin.sys.entity;

import java.io.Serializable;
import java.util.List;

public class Department implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	
	private String name;
	
	private String description;
	
	//部门等级 1最高
	private String level;
	
	//父部门id
	private String parentid;
	
	//是否删除  0未删除  1已删除
	private int state;
	
	//子部门
	private List<Department> children; 
	
	

	public Department() {
		super();
	}


	public Department(String id, String name, String description, String level, String parentid, int state,
			List<Department> children) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.level = level;
		this.parentid = parentid;
		this.state = state;
		this.children = children;
	}





	public int getState() {
		return state;
	}


	public void setState(int state) {
		this.state = state;
	}


	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getLevel() {
		return level;
	}



	public void setLevel(String level) {
		this.level = level;
	}



	public String getParentid() {
		return parentid;
	}



	public void setParentid(String parentid) {
		this.parentid = parentid;
	}



	public List<Department> getChildren() {
		return children;
	}



	public void setChildren(List<Department> children) {
		this.children = children;
	}




	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	

}
