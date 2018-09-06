package com.sunwin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.sunwin.dao.baseDaoI;
import com.sunwin.model.TMail;
import com.sunwin.pageModel.Mail;
import com.sunwin.service.mailI;

public class mailIm implements mailI{
	
	@SuppressWarnings("unused")
	@Autowired
	private baseDaoI<TMail> tmail;

	public void send(Mail mail) {
		// TODO Auto-generated method stub
		
	}

	public void save(Mail mail) {
		// TODO Auto-generated method stub
		
	}

}
