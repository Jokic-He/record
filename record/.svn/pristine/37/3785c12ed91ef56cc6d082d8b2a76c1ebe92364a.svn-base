package com.sunwin.talent.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunwin.talent.dao.talentDao;
import com.sunwin.talent.entity.talent;

/**
 * 
*  
* <p>Description: 该类为简历操作方法类</p> 
* 
* @author 何培赟  
* @date 2018年7月10日
 */
@Service(value = "talentService")
public class talentService {

	@Autowired
	private talentDao talentDao;

	public void saveResume(talent t) {
		try {
			if (t != null) {
				t.setId(UUID.randomUUID().toString().replace("-", ""));
				talentDao.saveResume(t);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
