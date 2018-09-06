package com.sunwin.record.entity;

import java.io.Serializable;

/**
 * 線路狀態
 * 
 * @author as 何培赟
 *
 */
public class Line implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;

	// 線路狀態
	private String atpworkstate;

	// 線路方式
	private String atpconstate;

	// dtmf
	private String atpdtmf;

	// 呼入號碼
	private String atpcallerid;

	// 通道號
	private String atpchn;

	public Line() {
		super();
	}

	public Line(String id, String atpworkstate, String atpconstate, String atpdtmf, String atpcallerid, String atpchn) {
		super();
		this.id = id;
		this.atpworkstate = atpworkstate;
		this.atpconstate = atpconstate;
		this.atpdtmf = atpdtmf;
		this.atpcallerid = atpcallerid;
		this.atpchn = atpchn;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAtpworkstate() {
		return atpworkstate;
	}

	public void setAtpworkstate(String atpworkstate) {
		this.atpworkstate = atpworkstate;
	}

	public String getAtpconstate() {
		return atpconstate;
	}

	public void setAtpconstate(String atpconstate) {
		this.atpconstate = atpconstate;
	}

	public String getAtpdtmf() {
		return atpdtmf;
	}

	public void setAtpdtmf(String atpdtmf) {
		this.atpdtmf = atpdtmf;
	}

	public String getAtpcallerid() {
		return atpcallerid;
	}

	public void setAtpcallerid(String atpcallerid) {
		this.atpcallerid = atpcallerid;
	}

	public String getAtpchn() {
		return atpchn;
	}

	public void setAtpchn(String atpchn) {
		this.atpchn = atpchn;
	}

}
