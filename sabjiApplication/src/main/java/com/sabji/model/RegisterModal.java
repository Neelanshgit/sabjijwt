package com.sabji.model;

public class RegisterModal {

	private String mobileno;

	private String email;

	private String password;

	private String flgOfUser;
	private String aadharNo;

	

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
	}public String getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}
}
