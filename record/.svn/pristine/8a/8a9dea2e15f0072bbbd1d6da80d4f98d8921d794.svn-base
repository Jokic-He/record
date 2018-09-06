package com.sunwin.record.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sunwin.record.entity.Line;
import com.sunwin.record.entity.record;

@Component(value = "recordDao")
/**
 * 
 * <p>
 * Title: recordDao
 * </p>
 * <p>
 * Description: recordDao类
 * </p>
 * 
 * @author 何培赟
 * @date 2018年6月21日
 */
public interface recordDao {

	// 讀取錄音
	List<record> getRecord(@Param("atpdirect") String atpdirect, @Param("atpdtmf") String atpdtmf,
			@Param("atpcaller") String atpcaller, @Param("atpchnum") String atpchnum,
			@Param("atpstarttime") String atpstarttime, @Param("atpendtime") String atpendtime);

	// 讀取線路狀態
	List<Line> getLine();

	// 讀取所有錄音
	List<record> getAllRecord();

	// 讀取当日錄音
	List<record> getTodayRecord(@Param("atpstarttime") String atpstarttime, @Param("atpendtime") String atpendtime);

	// 获取虚拟路径
	String getUrl();

	// 修改虚拟路劲
	@Transactional
	void setUrl(@Param("url") String url);
}
