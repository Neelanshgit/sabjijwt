package com.sabji.model;

public class DriverDetailDTO {

	private Long driverId;

	private String driverName;

	private String dVechileName;

	private String quantityOfVegetables;

	private String roundCount;
	
	private String timesOfRaotation;

	private String driverArea;

	private String vechileOwnerName;

	private String driverNumber;
	private String alternateNumber;
	private String userCode;
	
	

	

	public String getdVechileName() {
		return dVechileName;
	}

	public void setdVechileName(String dVechileName) {
		this.dVechileName = dVechileName;
	}

	public String getTimesOfRaotation() {
		return timesOfRaotation;
	}

	public void setTimesOfRaotation(String timesOfRaotation) {
		this.timesOfRaotation = timesOfRaotation;
	}

	public Long getDriverId() {
		return driverId;
	}

	public void setDriverId(Long driverId) {
		this.driverId = driverId;
	}

	
	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	
	public String getQuantityOfVegetables() {
		return quantityOfVegetables;
	}

	public void setQuantityOfVegetables(String quantityOfVegetables) {
		this.quantityOfVegetables = quantityOfVegetables;
	}

	public String getRoundCount() {
		return roundCount;
	}

	public void setRoundCount(String roundCount) {
		this.roundCount = roundCount;
	}

	public String getDriverArea() {
		return driverArea;
	}

	public void setDriverArea(String driverArea) {
		this.driverArea = driverArea;
	}

	public String getVechileOwnerName() {
		return vechileOwnerName;
	}

	public void setVechileOwnerName(String vechileOwnerName) {
		this.vechileOwnerName = vechileOwnerName;
	}

	public String getDriverNumber() {
		return driverNumber;
	}

	public void setDriverNumber(String driverNumber) {
		this.driverNumber = driverNumber;
	}
	
	public String getAlternateNumber() {
		return alternateNumber;
	}

	public void setAlternateNumber(String alternateNumber) {
		this.alternateNumber = alternateNumber;
	}
	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
}