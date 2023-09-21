package com.sabji.entity;

import java.util.Arrays;

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
	public int id;

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

	@Override
	public String toString() {
		return "VegetableEntity [vegetableName=" + vegetableName + ", pic=" + Arrays.toString(pic) + ", timeperiod="
				+ timeperiod + ", vegetableValidity=" + vegetableValidity + ", coldStorageRequirement="
				+ coldStorageRequirement + "]";
	}

	public VegetableEntity(String vegetableName, byte[] pic, String timeperiod, String vegetableValidity,
			String coldStorageRequirement) {
		super();
		this.vegetableName = vegetableName;
		this.pic = pic;
		this.timeperiod = timeperiod;
		this.vegetableValidity = vegetableValidity;
		this.coldStorageRequirement = coldStorageRequirement;
	}

	public VegetableEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

}
