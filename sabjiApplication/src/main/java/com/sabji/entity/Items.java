package com.sabji.entity;

import javax.annotation.processing.SupportedAnnotationTypes;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.lang.NonNull;

@Entity
public class Items {
	
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	public int id;
	
	@NonNull
	@NotNull
	private String name ;
	 
	 
	private String mobileno;
	 
	private String area;
	 
	private String vegname;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getVegname() {
		return vegname;
	}

	public void setVegname(String vegname) {
		this.vegname = vegname;
	}

	@Override
	public String toString() {
		return "Items [name=" + name + ", mobileno=" + mobileno + ", area=" + area + ", vegname=" + vegname + "]";
	}

	public Items(String name, String mobileno, String area, String vegname) {
		super();
		this.name = name;
		this.mobileno = mobileno;
		this.area = area;
		this.vegname = vegname;
	}

	public Items() {
		super();
		// TODO Auto-generated constructor stub
	}

	  

	 
	

}
