package com.sabji.model;

import javax.persistence.Column;

public class FarmerInfoDTO {
	
	private int Id;
	 
	private String phoneNumber;
	 
	  private String area;
	   	 
	 private String vegetableQuantity;
	 
	 private String transportName;
	 
	 private String distanceFromMandi;
	 
	 private int farmerVisitingCount;
	 
	 private String sellingArea;
	  
	private String nameOfMandi;
	   
	 private String varietyOfVegetables;
	 
	 private String amountOfCommision;
	 
	 private String quest1;
	  
	 private String quest2;
	 
	 private String quest3;
	   
	 private String quest4;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getVegetableQuantity() {
		return vegetableQuantity;
	}

	public void setVegetableQuantity(String vegetableQuantity) {
		this.vegetableQuantity = vegetableQuantity;
	}

	public String getTransportName() {
		return transportName;
	}

	public void setTransportName(String transportName) {
		this.transportName = transportName;
	}

	public String getDistanceFromMandi() {
		return distanceFromMandi;
	}

	public void setDistanceFromMandi(String distanceFromMandi) {
		this.distanceFromMandi = distanceFromMandi;
	}

	public int getFarmerVisitingCount() {
		return farmerVisitingCount;
	}

	public void setFarmerVisitingCount(int farmerVisitingCount) {
		this.farmerVisitingCount = farmerVisitingCount;
	}

	public String getSellingArea() {
		return sellingArea;
	}

	public void setSellingArea(String sellingArea) {
		this.sellingArea = sellingArea;
	}

	public String getNameOfMandi() {
		return nameOfMandi;
	}

	public void setNameOfMandi(String nameOfMandi) {
		this.nameOfMandi = nameOfMandi;
	}

	public String getVarietyOfVegetables() {
		return varietyOfVegetables;
	}

	public void setVarietyOfVegetables(String varietyOfVegetables) {
		this.varietyOfVegetables = varietyOfVegetables;
	}

	public String getAmountOfCommision() {
		return amountOfCommision;
	}

	public void setAmountOfCommision(String amountOfCommision) {
		this.amountOfCommision = amountOfCommision;
	}

	public String getQuest1() {
		return quest1;
	}

	public void setQuest1(String quest1) {
		this.quest1 = quest1;
	}

	public String getQuest2() {
		return quest2;
	}

	public void setQuest2(String quest2) {
		this.quest2 = quest2;
	}

	public String getQuest3() {
		return quest3;
	}

	public void setQuest3(String quest3) {
		this.quest3 = quest3;
	}

	public String getQuest4() {
		return quest4;
	}

	public void setQuest4(String quest4) {
		this.quest4 = quest4;
	}


}