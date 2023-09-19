package com.sabji.model;



public class RegisterModal {

	private Long id;


	private String username;

	private String password;
	private String domain;
	private String flgOfUser;
	private java.sql.Date  dateOfCreation;
	private String intialKey;
	private String refContent;
	private String confirmPassword;


	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getFlgOfUser() {
		return flgOfUser;
	}
	public void setFlgOfUser(String flgOfUser) {
		this.flgOfUser = flgOfUser;
	}
	public java.sql.Date getDateOfCreation() {
		return dateOfCreation;
	}
	public void setDateOfCreation(java.sql.Date dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}
	public String getIntialKey() {
		return intialKey;
	}
	public void setIntialKey(String intialKey) {
		this.intialKey = intialKey;
	}
	public String getRefContent() {
		return refContent;
	}
	public void setRefContent(String refContent) {
		this.refContent = refContent;
	}


}
