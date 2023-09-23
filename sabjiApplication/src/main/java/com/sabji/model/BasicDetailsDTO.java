package com.sabji.model;

 
public class BasicDetailsDTO {
 	public int id;
  
	private String name;

	private String mobileno;

	private String area;

	private String vegname;

	private String interestedToMandi;

	private Double visitingExpenditure;
	 
	private Double brokerCharge;
	 
	private String transportNameWithTiming;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public String getInterestedToMandi() {
		return interestedToMandi;
	}

	public void setInterestedToMandi(String interestedToMandi) {
		this.interestedToMandi = interestedToMandi;
	}

	public Double getVisitingExpenditure() {
		return visitingExpenditure;
	}

	public void setVisitingExpenditure(Double visitingExpenditure) {
		this.visitingExpenditure = visitingExpenditure;
	}

	public Double getBrokerCharge() {
		return brokerCharge;
	}

	public void setBrokerCharge(Double brokerCharge) {
		this.brokerCharge = brokerCharge;
	}

	public String getTransportNameWithTiming() {
		return transportNameWithTiming;
	}

	public void setTransportNameWithTiming(String transportNameWithTiming) {
		this.transportNameWithTiming = transportNameWithTiming;
	}
	
	

}
