package com.sunwin.pageModel;

import java.util.Date;
import java.io.Serializable;

public class Wake implements Serializable{
	
	private static final long serialVersionUID = 1L;
	//����
	private String roomNum;
	//�Ƿ�ɹ�
	private int success;
	//��ʼ����
	private String startDate;
	//��������
	private String endDate;
	//���ؼ�¼��ʱ��
	private Date setDate;
	//���ý��ѵĺ���
	private String setNum;
	//���ý��ѵ�ʱ��
	private String wakeTime;
	
	//������
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
