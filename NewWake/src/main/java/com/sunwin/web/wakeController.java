package com.sunwin.web;
/**
 * @author as he
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sunwin.pageModel.User;
import com.sunwin.pageModel.Wake;
import com.sunwin.service.wakeI;
import com.sunwin.tools.DataGrid;
import com.sunwin.tools.checkWake;

@Controller
@RequestMapping(value="/wakeup")
public class wakeController {
	
	@Autowired
	private wakeI wakeupI;
	
	// 返回一个查询好的datagrid
		@RequestMapping(value = "/toFindData")
		@ResponseBody
		public DataGrid toFindData(Wake p) throws Exception {
			DataGrid dg = wakeupI.find(p);
			return dg;
		}

		@RequestMapping(value = "/getCombobox")
		@ResponseBody
		public List<Map<String, String>> getCombobox() {
			List<Map<String, String>> list = new ArrayList<Map<String, String>>();
			Map<String, String> map = new HashMap<String, String>();
			map.put("id", "5");
			map.put("text", "失败");
			list.add(map);
			map = new HashMap<String, String>();
			map.put("id", "1");
			map.put("text", "成功");
			list.add(map);
			map = new HashMap<String, String>();
			map.put("id", "2");
			map.put("text", "设置成功");
			list.add(map);
			map = new HashMap<String, String>();
			map.put("id", "3");
			map.put("text", "修改成功");
			list.add(map);
			map = new HashMap<String, String>();
			map.put("id", "4");
			map.put("text", "删除成功");
			list.add(map);
			map = new HashMap<String, String>();
			map.put("id", "10");
			map.put("text", "所有");
			list.add(map);
			return list;
		}

		// 查询所有数据
		@RequestMapping(value = "/toFindAll")
		@ResponseBody
		public DataGrid findAll(Wake p) {
			DataGrid dg = wakeupI.findAll(p);
			return dg;
		}

		// 保存所有数据
		@RequestMapping(value = "/saveData")
		public void saveData() {
			checkWake cw = new checkWake();
			wakeupI.saveDB(cw.check());
		}

		// 保存数据5m
		@RequestMapping(value = "/saveDataFive")
		public void saveDataFive() {
			checkWake cw = new checkWake();
			wakeupI.saveDBFive(cw.check());
		}

		// 保存数据30m
		@RequestMapping(value = "/saveDataHalf")
		public void saveDataHalf() {
			checkWake cw = new checkWake();
			wakeupI.saveDBHalf(cw.check());
		}

		// 保存数据1h
		@RequestMapping(value = "/saveDataHour")
		public void saveDataHour() {
			checkWake cw = new checkWake();
			wakeupI.saveDBHour(cw.check());
		}

		@RequestMapping(value = "/wakeup")
		public ModelAndView toWake() {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("wakeup");
			return mv;
		}

//		// 删除数据7d
//		@RequestMapping(value = "/deleteDataSeven")
//		public void deleteDataSeven(PageWake wake) {
//			wakeupI.deleteDBSeven(wake);
//		}

		// 删除半年前数据
		@RequestMapping(value = "/deleteData")
		public void deleteData(Wake wake) {
			wakeupI.deleteDB(wake);
		}

		//导出成excel表格
		@RequestMapping(value = "/toExcel")
		public void toExcel(Wake wake) {
			wakeupI.ToExcel(wake);
		}
		
		//发送邮件页面
		@RequestMapping(value="/toSendMail")
	//	@RequiresPermissions("admin:sendMail")
		//@ResponseBody
		public ModelAndView toSendMail(HttpSession session){
			ModelAndView mv=new ModelAndView();
			User user=(User) session.getAttribute("user");
			mv.addObject("user",user);
			mv.setViewName("/wake/sendMail");
			return mv;
		}

}
