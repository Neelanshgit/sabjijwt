package com.sabji.model;

public class RegisterModal {

	private String mobileno;
	private String name;
   private String dateofbirth;
	private String email;

	private String password;

	private String flagOfUser;
	private String aadharNo;

	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFlagOfUser() {
		return flagOfUser;
	}

	public void setFlagOfUser(String flagOfUser) {
		this.flagOfUser = flagOfUser;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
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
