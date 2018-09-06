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
	
	//���ؼ�¼��ʱ��
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="t_setDate", length=40)
	private Date setDate;
	
	//���ý��ѵĺ���
	@Column(name="t_setNum", length=20)
	private String setNum;
	
	//���ý��ѵ�ʱ��
	@Column(name="t_wakeTime", length=40)
	private String wakeTime;
	
	//Ŀ�귿��
	@Column(name="t_roomNum", length=20)
	private String roomNum;
	
	
	//�Ƿ�ɹ�(�ɹ�Ϊ1��ʧ��Ϊ5�����óɹ�Ϊ2���޸ĳɹ�Ϊ3,ɾ���ɹ�Ϊ4)
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
