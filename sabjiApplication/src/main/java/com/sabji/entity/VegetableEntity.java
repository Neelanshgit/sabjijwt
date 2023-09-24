package com.sabji.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vegetable_details")
public class VegetableEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "veg_id")
	public int vegId;

	@Column(name = "vegetable_name")
	private String vegetableName;

	@Column(name = "vegetable_pic")
	private byte[] pic;

	@Column(name = "season_of_vegetable")
	private String timeperiod;

	@Column(name = "vegetable_validity")
	private String vegetableValidity;

	@Column(name = "cold_storage_required")
	private String coldStorageRequirement;

	@Column(name = "area_Cme_frm")
	private String kahaSetAtiHai;

	@Column(name = "availability")
	private String availability;

	public int getVegId() {
		return vegId;
	}

	public void setVegId(int vegId) {
		this.vegId = vegId;
	}

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
