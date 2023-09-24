package com.sabji.model;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class VegetableDetailsDTO {

	// public int vegId;

	private String vegetableName;

	private MultipartFile Image;

	private byte[] pic;
	private String timeperiod;

	private String vegetableValidity;

	private String coldStorageRequirement;

	private String kahaSetAtiHai;

	private String availability;

	public MultipartFile getImage() {
		return Image;
	}

	public void setImage(MultipartFile image) {
		Image = image;
	}

	public void setPic(byte[] pic) {
		this.pic = pic;
	}

	public String getVegetableName() {
		return vegetableName;
	}

	public void setVegetableName(String vegetableName) {
		this.vegetableName = vegetableName;
	}

	/*
	 * public int getVegId() { return vegId; }
	 *
	 * public void setVegId(int vegId) { this.vegId = vegId; }
	 */

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
