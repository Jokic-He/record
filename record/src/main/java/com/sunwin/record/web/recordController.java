package com.sunwin.record.web;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sunwin.record.entity.Line;
import com.sunwin.record.entity.tongdao;
import com.sunwin.record.entity.PageRecord;
import com.sunwin.record.entity.record;
import com.sunwin.record.service.recordService;
import com.sunwin.sys.entity.Page;
import com.sunwin.sys.utils.EmptyUtils;
import com.sunwin.sys.utils.ExcelUtil;
import com.sunwin.sys.utils.Json;

/**
 * 
 * <p>
 * Title: recordController
 * </p>
 * <p>
 * Description: 录音控制类
 * </p>
 * 
 * @author 何培赟
 * @date 2018年6月21日
 */

@Controller
@RequestMapping(value = "/record")
public class recordController {

	@Autowired
	private recordService recordService;

	@Autowired
	private tongdao tongdao;

	private List<record> records;

	@RequestMapping(value = "getRecords")
	@ResponseBody
	public Page getRecords(HttpServletResponse res, HttpServletRequest req) throws Exception {
		Page page = new Page();
		PageRecord p = new PageRecord("", (String) req.getParameter("key[atpdirect]"),
				(String) req.getParameter("key[atpdtmf]"), (String) req.getParameter("key[atpcaller]"),
				(String) req.getParameter("key[atpchnum]"), (String) req.getParameter("key[atpstarttime]"),
				(String) req.getParameter("key[atpendtime]"), "");
		List<record> list = recordService.getRecord(p);
		if (list != null) {
			for (record r : list) {
				if (r.getAtpchnum().equals(tongdao.getTongdao())) {
					r.setAtpchnum(tongdao.getFenjihao());
				}
			}
			page.setData(list);
			records = list;
			page.setSuccess(true);
			page.setMsg("获取成功");
			page.setCount(list.size());
			page.setCode(0);
			return page;
		} else {
			page.setMsg("系统异常");
			page.setSuccess(false);
			return page;
		}

	}

	@RequestMapping(value = "getLine")
	@ResponseBody
	public Page getLine() {
		Page page = new Page();
		List<Line> list = recordService.getLine();
		page.setCode(0);
		page.setCount(list.size());
		page.setData(list);
		return page;
	}

	@RequestMapping(value = "toLine")
	public ModelAndView toLine() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/record/Line");
		return mv;
	}

	@RequestMapping(value = "toRecord")
	public ModelAndView toRecord() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/record/record");
		return mv;
	}

	// 获取当日的录音时间分布
	@RequestMapping(value = "toGetDayRecord")
	@ResponseBody
	public List<String> toGetDayRecord() {
		List<String> list = new ArrayList<String>();
		list = recordService.getDayRecord();
		return list;
	}

	// 导出excel
	@ResponseBody
	@RequestMapping(value = "toExcel", produces = "application/octet-stream")
	public void downloadFile(HttpServletResponse response) throws IOException {
		HSSFWorkbook wb = ExcelUtil.toexcel(records);
		OutputStream output = response.getOutputStream();
		response.addHeader("Content-Disposition",
				"inline;filename=" + new SimpleDateFormat("yyyyMMdd_HHmmssSSS").format(new Date()) + ".xls");
		response.setContentType("application/msexcel");
		wb.write(output);
		output.close();
	}

	// 下载录音文件
	@ResponseBody
	@RequestMapping(value = "downloadrecord", produces = "application/octet-stream")
	public void downloadrecord(HttpServletResponse response, HttpServletRequest req) throws Exception {
		String path = recordService.getUrl() + req.getParameter("url");
		File file = new File(path);// path是根据日志路径和文件名拼接出来的
		String filename = file.getName();// 获取日志文件名称
		InputStream fis = new BufferedInputStream(new FileInputStream(path));
		byte[] buffer = new byte[fis.available()];
		fis.read(buffer);
		fis.close();
		response.reset();
		// 先去掉文件名称中的空格,然后转换编码格式为utf-8,保证不出现乱码,这个文件名称用于浏览器的下载框中自动显示的文件名
		response.addHeader("Content-Disposition",
				"attachment;filename=" + new String(filename.replaceAll(" ", "").getBytes("utf-8"), "iso8859-1"));
		response.addHeader("Content-Length", "" + file.length());
		OutputStream os = new BufferedOutputStream(response.getOutputStream());
		response.setContentType("application/octet-stream");
		os.write(buffer);// 输出文件
		os.flush();
		os.close();

	}

	// 更改录音读取路径
	@RequestMapping(value = "toUpdateUrl")
	@ResponseBody
	public Json toUpdateUrl(HttpServletRequest req) {
		String url = req.getParameter("url");
		Json json = new Json();
		if (EmptyUtils.checkStrNotNull(url)) {
			recordService.setUrl(url);
			json.setMsg("修改成功");
			json.setSuccess(true);
			return json;
		}
		json.setSuccess(false);
		json.setMsg("修改失败，系统异常");
		return json;
	}

}
