package com.sunwin.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunwin.dao.baseDaoI;
import com.sunwin.model.TWake;
import com.sunwin.pageModel.Wake;
import com.sunwin.service.wakeI;
import com.sunwin.tools.DataGrid;
import com.sunwin.tools.toExcel;

@Service("wakeI")
public class wakeIm implements wakeI{
	
	@Autowired
	private baseDaoI<TWake> baseDaoI;
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Transactional
	public void saveDB(List<TWake> list) {

		for (TWake wake : list) {
			baseDaoI.save(wake);
		}

	}

	@Transactional
	public void saveDBFive(List<TWake> list) {

		for (TWake wake : list) {
			// 自动识别超过5分钟的数据不会重复存储
			if (new Date().getTime() - wake.getSetDate().getTime() < 5 * 60 * 1000L) {
				baseDaoI.save(wake);
			}
		}

	}

	@Transactional
	public void saveDBHalf(List<TWake> list) {

		for (TWake wake : list) {
			// 自动识别超过30分钟的数据不会重复存储
			if (new Date().getTime() - wake.getSetDate().getTime() < 30 * 60 * 1000L) {
				baseDaoI.save(wake);
			}
		}

	}

	@Transactional
	public void saveDBHour(List<TWake> list) {

		for (TWake wake : list) {
			// 自动识别超过1小时的数据不会重复存储
			if (new Date().getTime() - wake.getSetDate().getTime() < 60 * 60 * 1000L) {
				baseDaoI.save(wake);
			}
		}

	}

	// 寻找所有数据
	@Transactional
	public DataGrid findAll(Wake p) {
		DataGrid dg = new DataGrid();
		StringBuffer sb = new StringBuffer("from TWake t order by t.setDate DESC");
		List<TWake> list = baseDaoI.find(sb.toString(), null, p.getPage(), p.getRows());
		List<Wake> list2 = new ArrayList<Wake>();
		for (TWake t : list) {
			Wake pw = new Wake();
			BeanUtils.copyProperties(t, pw);
			list2.add(pw);
		}
		dg.setRows(list2);
		sb.insert(0, "select count(id) ");
		dg.setTotal(baseDaoI.count(sb.toString(), null));
		return dg;
	}

	// 条件查询
	@Transactional
	public DataGrid find(Wake pwake) {
		DataGrid dg = new DataGrid();
		StringBuffer sb = new StringBuffer("FROM TWake t WHERE 1=1");
		Map<String, Object> param = new HashMap<String, Object>();
		int i = pwake.getSuccess();
		if (i != 0 && i != 10) {
			try {
				if (pwake.getRoomNum() != "") {
					sb.append(" and t.roomNum = ?1 ");
					param.put("1", pwake.getRoomNum());
				}
				if (pwake.getStartDate() != "") {
					sb.append(" and t.setDate >= ?5 ");
					param.put("5", sdf.parse(pwake.getStartDate()));
				}

				if (pwake.getEndDate() != "") {
					sb.append(" and t.setDate <= ?7 ");
					param.put("7", sdf.parse(pwake.getEndDate()));
				}
				sb.append(" and t.success= ?8 ");
				param.put("8", pwake.getSuccess());
			} catch (Exception e) {
			}
		} else if (i == 10) {
			try {
				if (pwake.getRoomNum() != "") {
					sb.append(" and t.roomNum = ?1 ");
					param.put("1", pwake.getRoomNum());
				}
				if (pwake.getStartDate() != "") {
					sb.append(" and t.setDate >= ?5 ");
					param.put("5", sdf.parse(pwake.getStartDate()));
				}

				if (pwake.getEndDate() != "") {
					sb.append(" and t.setDate <= ?7 ");
					param.put("7", sdf.parse(pwake.getEndDate()));
				}
			} catch (Exception e) {
			}

		}
		sb.append(" order by t.setDate DESC");
		List<TWake> list = baseDaoI.find(sb.toString(), param, pwake.getPage(), pwake.getRows());
		List<Wake> list2 = new ArrayList<Wake>();
		for (TWake t : list) {
			Wake pw = new Wake();
			BeanUtils.copyProperties(t, pw);
			list2.add(pw);
		}
		dg.setRows(list2);
		sb.insert(0, "select count(id) ");
		dg.setTotal(baseDaoI.count(sb.toString(), param));
		return dg;
	}

	@Transactional
	public void deleteDB(Wake p) {
		StringBuffer sb = new StringBuffer("FROM TWake t WHERE t.setDate <= ?20 ");
		Map<String, Object> param = new HashMap<String, Object>();
		Date before = new Date(new Date().getTime() - 180 * 24 * 60 * 60 * 1000L);
		param.put("20", before);
		List<TWake> list = baseDaoI.find(sb.toString(), param);
		for (TWake wake : list) {
			baseDaoI.delete(wake);
		}

	}

	@Transactional
	public void ToExcel(Wake pwake) {
		StringBuffer sb = new StringBuffer("FROM TWake t WHERE 1=1 ");
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (pwake.getStartDate() != "") {
				sb.append(" and t.setDate >= ?5 ");
				param.put("5", sdf.parse(pwake.getStartDate()));
			}

			if (pwake.getEndDate() != "") {
				sb.append(" and t.setDate <= ?7 ");
				param.put("7", sdf.parse(pwake.getEndDate()));
			}
		} catch (Exception e) {

		}
		List<TWake> list = baseDaoI.find(sb.toString(), param);
		toExcel te = new toExcel();
		te.toexcel(list);
	}

}
