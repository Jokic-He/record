package com.sunwin.tools;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("rawtypes")
public class DataGrid implements Serializable {
	private static final long serialVersionUID = 1L;


	private Long total;// �ܼ�¼��
	

	private List rows;// ÿ�м�¼;

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List getRows() {
		return rows;
	}

	public void setRows(List rows) {
		this.rows = rows;
	}
	
	

}