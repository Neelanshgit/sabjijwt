package com.sabji.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="GDMS_API_USERS")

public class GdmsApiUsers {

	
	
	@GeneratedValue( strategy= GenerationType.AUTO)
	@Column(name="ID")
    private Long id; 
	@Id
	@Column(name="USERNAME")
	private String username;
	@Column(name="PASSWORD")
	private String password; 
	@Column(name="DOMAIN")
	private String domain; 
	@Column(name="FLG_OF_USER")
	private String flgOfUser;
	@Column(name="DATE_OF_USERCREATION")
	private java.sql.Date  dateOfCreation; 
	@Column(name="INTIAL_KEY")
	private String intialKey;
	@Column(name="REF_CONTENT")
	private String refContent;
	
		
	
    @OneToOne(mappedBy = "gdmsApiUsers",cascade = CascadeType.ALL)
	private DetailsOfUser detailsOfUser;


	
	
	
	
	public GdmsApiUsers(Long id, String username, String password, String domain, String flgOfUser, Date dateOfCreation,
			String intialKey, String refContent, DetailsOfUser detailsOfUser) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.domain = domain;
		this.flgOfUser = flgOfUser;
		this.dateOfCreation = dateOfCreation;
		this.intialKey = intialKey;
		this.refContent = refContent;
		this.detailsOfUser = detailsOfUser;
	}


	public GdmsApiUsers() {
		super();
		// TODO Auto-generated constructor stub
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


	public DetailsOfUser getDetailsOfUser() {
		return detailsOfUser;
	}


	public void setDetailsOfUser(DetailsOfUser detailsOfUser) {
		this.detailsOfUser = detailsOfUser;
	}
	
	
	
	
	
	
	
	
}
