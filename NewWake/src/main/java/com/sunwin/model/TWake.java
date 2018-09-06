package com.sunwin.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="t_wake")
public class TWake {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	//返回记录的时间
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="t_setDate", length=40)
	private Date setDate;
	
	//设置叫醒的号码
	@Column(name="t_setNum", length=20)
	private String setNum;
	
	//设置叫醒的时间
	@Column(name="t_wakeTime", length=40)
	private String wakeTime;
	
	//目标房号
	@Column(name="t_roomNum", length=20)
	private String roomNum;
	
	
	//是否成功(成功为1，失败为5，设置成功为2，修改成功为3,删除成功为4)
	@Column(name="t_success", length=40)
	private int success;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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

}
