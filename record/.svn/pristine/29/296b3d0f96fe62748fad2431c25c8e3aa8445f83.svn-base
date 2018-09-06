package com.sunwin.record.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sunwin.record.dao.recordDao;
import com.sunwin.record.entity.Line;
import com.sunwin.record.entity.PageRecord;
import com.sunwin.record.entity.record;
import com.sunwin.sys.utils.DateUtil;

/**
 * 
 * <p>
 * Title: recordService
 * </p>
 * <p>
 * Description: 录音操作方法类
 * </p>
 * 
 * @author 何培赟
 * @date 2018年6月21日
 */

@Service(value = "recordService")
public class recordService {

	@Autowired
	private recordDao recordDao;

	// 獲取錄音集合
	public List<record> getRecord(PageRecord p) {
		record r = new record();
		r.setAtpcaller(p.getAtpcaller());
		r.setAtpchnum(p.getAtpchnum());
		if ("2".equals(p.getAtpdirect())) {
			r.setAtpdirect("");
		} else {

			r.setAtpdirect(p.getAtpdirect());
		}
		r.setAtpdtmf(p.getAtpdtmf());
		String startdate = "";
		String enddate = "";
		if (p.getAtpstarttime() != null && p.getAtpstarttime() != "") {
			startdate = p.getAtpstarttime().replace("-", "/");

		}
		if (p.getAtpendtime() != null && p.getAtpendtime() != "") {
			enddate = p.getAtpendtime().replace("-", "/");
		}
		List<record> list = recordDao.getRecord(r.getAtpdirect(), r.getAtpdtmf(), r.getAtpcaller(), r.getAtpchnum(),
				startdate, enddate);
		for (record re : list) {
			if (re.getAtpdirect().equals("1")) {
				re.setAtpdirect("呼出");
			}
			if (re.getAtpdirect().equals("0")) {
				re.setAtpdirect("呼入");
			}
		}
		return list;

	}

	public List<record> getAllRecord() {
		List<record> list = recordDao.getAllRecord();
		return list;
	}

	// 獲取線路狀態
	public List<Line> getLine() {
		try {
			List<Line> list = recordDao.getLine();
			return list;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	// 获取当日的录音记录做成图表
	public List<String> getDayRecord() {
		Date date = new Date();
		Date start = DateUtil.getDayBeginTime(date);
		Date end = DateUtil.getDayEndTime(date);
		List<record> listr = recordDao.getTodayRecord(DateUtil.parseDateToStr(start, "yyyy/MM/dd HH:mm:ss"),
				DateUtil.parseDateToStr(end, "yyyy/MM/dd HH:mm:ss"));
		List<String> list = new ArrayList<String>();
		int i1 = 0;
		int i2 = 0;
		int i3 = 0;
		int i4 = 0;
		int i5 = 0;
		int i6 = 0;
		int i7 = 0;
		int i8 = 0;
		int i9 = 0;
		int i10 = 0;
		int i11 = 0;
		int i12 = 0;
		for (record r : listr) {
			String s = DateUtil.parseDateToStr(r.getAtpstarttime(), "yyyy/MM/dd HH:mm:ss");
			s = s.split(" ")[1];
			s = s.split(":")[0];
			int i = Integer.parseInt(s);
			if (i < 2) {
				i1 += 1;
			}
			if (2 <= i && i < 4) {
				i2 += 1;
			}
			if (4 <= i && i < 6) {
				i3 += 1;
			}
			if (6 <= i && i < 8) {
				i4 += 1;
			}
			if (8 <= i && i < 10) {
				i5 += 1;
			}
			if (10 <= i && i < 12) {
				i6 += 1;
			}
			if (12 <= i && i < 14) {
				i7 += 1;
			}
			if (14 <= i && i < 16) {
				i8 += 1;
			}
			if (16 <= i && i < 18) {
				i9 += 1;
			}
			if (18 <= i && i < 20) {
				i10 += 1;
			}
			if (20 <= i && i < 22) {
				i11 += 1;
			}
			if (22 <= i && i <= 23) {
				i12 += 1;
			}
		}
		list.add(i1 + "");
		list.add(i2 + "");
		list.add(i3 + "");
		list.add(i4 + "");
		list.add(i5 + "");
		list.add(i6 + "");
		list.add(i7 + "");
		list.add(i8 + "");
		list.add(i9 + "");
		list.add(i10 + "");
		list.add(i11 + "");
		list.add(i12 + "");
		return list;
	}

	// 获取录音url
	public String getUrl() throws Exception {
		return recordDao.getUrl();
	}
	
	//设置录音url
	public void setUrl(String url){
		try{
			recordDao.setUrl(url);
			
		}catch(Exception e){
			System.out.println(e);
		}
	}
	

}
