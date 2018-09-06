package com.sunwin.pageModel;

public class Mail {
	
	private String username;
	
    private String myEmailAccount;
	
	private String myEmailPassword;
	
	//发件人的smpt地址
	private String myEmailSMTPHost;
	
	//邮件主题
	private String subject;
	
	//邮件正文
	private String context;
	
	//收件人名字
	private String sendName;
	
	//收件人邮箱
	private String receiveMailAccount;

	public String getMyEmailAccount() {
		return myEmailAccount;
	}

	public void setMyEmailAccount(String myEmailAccount) {
		this.myEmailAccount = myEmailAccount;
	}

	public String getMyEmailPassword() {
		return myEmailPassword;
	}

	public void setMyEmailPassword(String myEmailPassword) {
		this.myEmailPassword = myEmailPassword;
	}

	public String getMyEmailSMTPHost() {
		return myEmailSMTPHost;
	}

	public void setMyEmailSMTPHost(String myEmailSMTPHost) {
		this.myEmailSMTPHost = myEmailSMTPHost;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getSendName() {
		return sendName;
	}

	public void setSendName(String sendName) {
		this.sendName = sendName;
	}

	public String getReceiveMailAccount() {
		return receiveMailAccount;
	}

	public void setReceiveMailAccount(String receiveMailAccount) {
		this.receiveMailAccount = receiveMailAccount;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	

}
