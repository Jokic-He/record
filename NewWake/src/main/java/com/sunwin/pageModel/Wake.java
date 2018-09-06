package com.sunwin.pageModel;

import java.util.Date;
import java.io.Serializable;

public class Wake implements Serializable{
	
	private static final long serialVersionUID = 1L;
	//房号
	private String roomNum;
	//是否成功
	private int success;
	//开始日期
	private String startDate;
	//结束日期
	private String endDate;
	//返回记录的时间
	private Date setDate;
	//设置叫醒的号码
	private String setNum;
	//设置叫醒的时间
	private String wakeTime;
	
	//表单数据
	private int page;
	private int rows;
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public Date getSetDate() {
		return setDate;
	}
	public void setSetDate(Date setDate) {
		this.setDate = setDate;
	}
	public String getSetNum() {
		return setNum;
	}
	public void setSetNum(String setNum) {
		this.setNum = setNum;
	}
	public String getWakeTime() {
		return wakeTime;
	}
	public void setWakeTime(String wakeTime) {
		this.wakeTime = wakeTime;
	}
	public String getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}
	public int getSuccess() {
		return success;
	}
	public void setSuccess(int success) {
		this.success = success;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	
	

}
