package com.sabji.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vendor_details")
public class VendorEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "vendor_id")
	private Long vendorId;
    @Column(name = "user_code")
	private String userCode;
    @Column(name = "vendor_name")
    private String vendorName;
	@Column(name="age")
	private String age;
	@Column(name = "vendor_type")
    private String vendorType;
	@Column(name="vendor_number")
    private String vendorNumber;
	@Column(name="alternate_number")
	 private String alternateNumber;
	@Column(name="vendor_address")
    private String vendorAddress;
	@Column(name="shop_address")
    private String shopAddress;
	@Column(name="mandi_priority")
    private String mandiPriority;
	@Column(name="mandi_visit")
    private String mandiVisit;
	@Column(name="vegetable_variety")
    private String vegetableVariety;
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
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
}
