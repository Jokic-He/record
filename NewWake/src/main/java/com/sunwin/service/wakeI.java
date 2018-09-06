package com.sunwin.service;

import java.util.List;

import com.sunwin.model.TWake;
import com.sunwin.pageModel.Wake;
import com.sunwin.tools.DataGrid;

public interface wakeI {
	
	// 将数据存入库中，5分钟前的数据不再重复存入
		void saveDBFive(List<TWake> list);

		// 将数据存入库中，5分钟前的数据不再重复存入
		void saveDB(List<TWake> list);

		// 将数据存入库中，30分钟前的数据不再重复存入
		void saveDBHalf(List<TWake> list);

		// 将数据存入库中，60分钟前的数据不再重复存入
		void saveDBHour(List<TWake> list);

		// 查询数据并返回一个DateGrid实例
		DataGrid find(Wake pwake);

		// 查询所有的数据
		DataGrid findAll(Wake p);

//		// 删除7天前的数据
//		void deleteDBSeven(PageWake p);

		// 删除半年前的数据的数据
		void deleteDB(Wake p);

		// 导出到excel
		void ToExcel(Wake p);

}
