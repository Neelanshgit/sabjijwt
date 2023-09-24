package com.sabji.model;

public class VegetableDetailsDTO {

	private String vegetableName;

	private byte[] pic;

	private String timeperiod;

	private String vegetableValidity;

	private String coldStorageRequirement;

	private String kahaSetAtiHai;

	private String availability;

	public String getVegetableName() {
		return vegetableName;
	}

	public void setVegetableName(String vegetableName) {
		this.vegetableName = vegetableName;
	}

	public byte[] getPic() {
		return pic;
	}

	public void setPic(byte[] pic) {
		this.pic = pic;
	}

	public String getTimeperiod() {
		return timeperiod;
	}

	public void setTimeperiod(String timeperiod) {
		this.timeperiod = timeperiod;
	}

	public String getVegetableValidity() {
		return vegetableValidity;
	}

	public void setVegetableValidity(String vegetableValidity) {
		this.vegetableValidity = vegetableValidity;
	}

	public String getColdStorageRequirement() {
		return coldStorageRequirement;
	}

	public void setColdStorageRequirement(String coldStorageRequirement) {
		this.coldStorageRequirement = coldStorageRequirement;
	}

	public String getKahaSetAtiHai() {
		return kahaSetAtiHai;
	}

	public void setKahaSetAtiHai(String kahaSetAtiHai) {
		this.kahaSetAtiHai = kahaSetAtiHai;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

}
