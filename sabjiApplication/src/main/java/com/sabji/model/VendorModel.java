package com.sabji.model;

public class VendorModel {
	private Long vendorId;
	private String userCode;
	 private String vendorName;
	 private String age;
     private String vendorType;
	 private String vendorNumber;
	 private String alternateNumber;
	 private String vendorAddress;
	 private String shopAddress;
	 private String mandiPriority;
	 private String mandiVisit;
	 private String vegetableVariety;
	 public String getUserCode() {
			return userCode;
		}
		public void setUserCode(String userCode) {
			this.userCode = userCode;
		}
	 public String getAlternateNumber() {
		return alternateNumber;
	}
	public void setAlternateNumber(String alternateNumber) {
		this.alternateNumber = alternateNumber;
	}
	
	 
	 
	
	
	public Long getVendorId() {
		return vendorId;
	}
	public void setVendorId(Long vendorId) {
		this.vendorId = vendorId;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getVendorType() {
		return vendorType;
	}
	public void setVendorType(String vendorType) {
		this.vendorType = vendorType;
	}
	public String getVendorNumber() {
		return vendorNumber;
	}
	public void setVendorNumber(String vendorNumber) {
		this.vendorNumber = vendorNumber;
	}
	public String getVendorAddress() {
		return vendorAddress;
	}
	public void setVendorAddress(String vendorAddress) {
		this.vendorAddress = vendorAddress;
	}
	public String getShopAddress() {
		return shopAddress;
	}
	public void setShopAddress(String shopAddress) {
		this.shopAddress = shopAddress;
	}
	public String getMandiPriority() {
		return mandiPriority;
	}
	public void setMandiPriority(String mandiPriority) {
		this.mandiPriority = mandiPriority;
	}
	public String getMandiVisit() {
		return mandiVisit;
	}
	public void setMandiVisit(String mandiVisit) {
		this.mandiVisit = mandiVisit;
	}
	public String getVegetableVariety() {
		return vegetableVariety;
	}
	public void setVegetableVariety(String vegetableVariety) {
		this.vegetableVariety = vegetableVariety;
	}
}
