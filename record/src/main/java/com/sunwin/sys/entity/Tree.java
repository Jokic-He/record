package com.sunwin.sys.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 树类型父类
 * @author as  何
 *
 */
public class Tree implements Serializable{
	
	/**
	 * 
	 */
	static final long serialVersionUID = 1L;

    String id;
	
	String name;
	
	//树等级 1最高
	String level;
	
	//父节点id
	String parent_id;
	
	//子节点
	List<Tree> children;

	public Tree(String id, String name, String level, String parent_id, List<Tree> children) {
		super();
		this.id = id;
		this.name = name;
		this.level = level;
		this.parent_id = parent_id;
		this.children = children;
	}

	public Tree() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getParent_id() {
		return parent_id;
	}

	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
	}

	public List<Tree> getChildren() {
		return children;
	}

	public void setChildren(List<Tree> children) {
		this.children = children;
	} 
	
	

}
