package com.sunwin.talent.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sunwin.talent.entity.talent;

@Component(value = "talentDao")
public interface talentDao {

	// 保存简历
	@Transactional
	void saveResume(talent t);

	// 根据openid查找是否存在数据
	String findByOpenid(@Param("openid") String openid);

	// 修改简历
	@Transactional
	void updateResume(talent t);

}
