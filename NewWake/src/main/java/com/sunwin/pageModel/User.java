package com.sunwin.pageModel;


public class User {
	
    private String id;
	
	private String username;
	
	private String password;
	
	private String department;
	
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
	
	//角色
	private String roleId;

	
	public User() {
		super();
	}


	


	public User(String id, String username, String password, String department, String myEmailAccount,
			String myEmailPassword, String myEmailSMTPHost, String subject, String context, String sendName,
			String receiveMailAccount, String roleId) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.department = department;
		this.myEmailAccount = myEmailAccount;
		this.myEmailPassword = myEmailPassword;
		this.myEmailSMTPHost = myEmailSMTPHost;
		this.subject = subject;
		this.context = context;
		this.sendName = sendName;
		this.receiveMailAccount = receiveMailAccount;
		this.roleId = roleId;
	}





	public String getRoleId() {
		return roleId;
	}





	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}





	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

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

	public String getSendName() {
		return sendName;
	}

	public void setSendName(String sendName) {
		this.sendName = sendName;
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



	public String getReceiveMailAccount() {
		return receiveMailAccount;
	}



	public void setReceiveMailAccount(String receiveMailAccount) {
		this.receiveMailAccount = receiveMailAccount;
	}
	
	

}
