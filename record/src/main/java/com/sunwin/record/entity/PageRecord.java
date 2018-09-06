package com.sunwin.record.entity;

import java.io.Serializable;

/**
 * 
 * <p>
 * Title: PageRecord
 * </p>
 * <p>
 * Description: 录音类页面模型
 * </p>
 * 
 * @author 何培赟
 * @date 2018年6月21日
 */
public class PageRecord implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;

	// 呼入方向
	private String atpdirect;

	// 呼出號碼
	private String atpdtmf;

	// 呼入號碼
	private String atpcaller;

	// 通道號
	private String atpchnum;

	// 錄音開始時間
	private String atpstarttime;

	// 錄音結束時間
	private String atpendtime;

	// 錄音地址
	private String atprecordurl;

	public PageRecord() {
		super();
	}

	public PageRecord(String id, String atpdirect, String atpdtmf, String atpcaller, String atpchnum,
			String atpstarttime, String atpendtime, String atprecordurl) {
		super();
		this.id = id;
		this.atpdirect = atpdirect;
		this.atpdtmf = atpdtmf;
		this.atpcaller = atpcaller;
		this.atpchnum = atpchnum;
		this.atpstarttime = atpstarttime;
		this.atpendtime = atpendtime;
		this.atprecordurl = atprecordurl;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAtpdirect() {
		return atpdirect;
	}

	public void setAtpdirect(String atpdirect) {
		this.atpdirect = atpdirect;
	}

	public String getAtpdtmf() {
		return atpdtmf;
	}

	public void setAtpdtmf(String atpdtmf) {
		this.atpdtmf = atpdtmf;
	}

	public String getAtpcaller() {
		return atpcaller;
	}

	public void setAtpcaller(String atpcaller) {
		this.atpcaller = atpcaller;
	}

	public String getAtpchnum() {
		return atpchnum;
	}

	public void setAtpchnum(String atpchnum) {
		this.atpchnum = atpchnum;
	}

	public String getAtpstarttime() {
		return atpstarttime;
	}

	public void setAtpstarttime(String atpstarttime) {
		this.atpstarttime = atpstarttime;
	}

	public String getAtpendtime() {
		return atpendtime;
	}

	public void setAtpendtime(String atpendtime) {
		this.atpendtime = atpendtime;
	}

	public String getAtprecordurl() {
		return atprecordurl;
	}

	public void setAtprecordurl(String atprecordurl) {
		this.atprecordurl = atprecordurl;
	}

}
