package com.sunwin.tools;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.sunwin.pageModel.Mail;

public class MailSend {
	
	public void send(Mail mail){
		JavaMailSenderImpl mailSender=new JavaMailSenderImpl();
		mailSender.setHost(mail.getMyEmailSMTPHost());//指定用来发送Email的邮件服务器主机名
        mailSender.setPort(25);//默认端口，标准的SMTP端口
        mailSender.setUsername(mail.getMyEmailAccount());//用户名
        mailSender.setPassword(mail.getMyEmailPassword());//密码
        SimpleMailMessage message = new SimpleMailMessage();//消息构造器
        message.setFrom(mail.getMyEmailAccount());//发件人
        message.setTo(mail.getReceiveMailAccount());//收件人
        message.setSubject(mail.getSubject());//主题
        message.setText(mail.getContext());//正文
        mailSender.send(message);
	}

}
