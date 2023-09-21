package com.sabji.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class RegisterModal {

	private String username;

	private String password;

	private String flgOfUser;

	private String confirmPassword;
	@JsonIgnoreProperties
	private java.sql.Date dateOfCreation;

	private String mobileno;

	private String email;
	@JsonIgnoreProperties
	private String userstatus;

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

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserstatus() {
		return userstatus;
	}

	public void setUserstatus(String userstatus) {
		this.userstatus = userstatus;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

}