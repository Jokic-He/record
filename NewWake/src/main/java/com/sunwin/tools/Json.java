package com.sunwin.tools;

import java.io.Serializable;

/**
 * 写出Json格式的工具类
 * @author 李正�?
 *
 */
public class Json implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private boolean success = false;// 是否成功
	
	private String msg = "";// 提示信息
	
	private Object obj = null;// 其他信息

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}
	
	public Json(boolean success, String msg) {
		this.success = success;
		this.msg = msg;
	}
	
	public Json(boolean success, Object obj) {
		this.success = success;
		this.obj = obj;
	}

	public Json(boolean success, String msg, Object obj) {
		this.success = success;
		this.msg = msg;
		this.obj = obj;
	}

	public Json() {}
	

}
