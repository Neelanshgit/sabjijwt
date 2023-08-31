package com.sabji.entity;

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
@Table(name="GDMS_DETAILS_OF_USERS")
public class DetailsOfUser {

	
	@GeneratedValue( strategy= GenerationType.AUTO)
	@Column(name="ID")
	private Long id; 
	@Column(name="DOMAIN")
	private String domain;
	@Column(name="MODULE")
	private String module; 
	@Column(name="REFRENCE")
	private String referenceKey;
	@Id
	private String username;
	
	
	@OneToOne
	@JoinColumn(name = "GDMS_API_USERS_USERNAME")
	private GdmsApiUsers gdmsApiUsers;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getReferenceKey() {
		return referenceKey;
	}

	public void setReferenceKey(String referenceKey) {
		this.referenceKey = referenceKey;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public GdmsApiUsers getGdmsApiUsers() {
		return gdmsApiUsers;
	}

	public void setGdmsApiUsers(GdmsApiUsers gdmsApiUsers) {
		this.gdmsApiUsers = gdmsApiUsers;
	}
	
	
	
	
	
	
}
