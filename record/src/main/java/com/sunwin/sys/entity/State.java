package com.sunwin.sys.entity;


/**
 * 坐席图表实体类
 * @author as 何
 *
 */
public class State {
	
	
	
	private String name;
	
	private int num;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public State(String name, int num) {
		super();
		this.name = name;
		this.num = num;
	}

	public State() {
		super();
	}
	
	

}
