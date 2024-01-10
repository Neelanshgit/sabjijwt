package com.sabji.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "API_USERS")

public class GdmsApiUsers {
   
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;


	@Column(name = "USERNAME")
	private String username;
	@Column(name="date_of_birth")
	private String dateofbirth;
	
	@Column(name="full_name")
	private String name;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "FLG_OF_USER")
	private String flagofUser;
	@Column(name = "DATE_OF_USERCREATION")
	private LocalDate dateOfCreation;
	@Id
	@Column(name = "mobile_no")
	private String mobileNo;// mobile no
	@Column(name = "email")
	private String email;
	@Column(name="aadhar_no")  // aadharno
	private String aadharNo;

	@Column(name = "user_status")
	private String userstatus;// email

	

	

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

	public String getFlagofUser() {
		return flagofUser;
	}

	public void setFlagofUser(String flagofUser) {
		this.flagofUser = flagofUser;
	}

	public LocalDate getDateOfCreation() {
		return dateOfCreation;
	}

	public void setDateOfCreation(LocalDate dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}
	public String getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}

	public String getUserstatus() {
		return userstatus;
	}

	public void setUserstatus(String userstatus) {
		this.userstatus = userstatus;
	}

}
