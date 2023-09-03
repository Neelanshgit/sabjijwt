package com.sabji.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.lang.NonNull;

@Entity
public class FarmerInfoEntity {
	
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	public int id;
	
	@NonNull
	@NotNull
	private String driverName;
	
	private String transportname;
	
	private int age;
	
	private Double amountsum;
	
	private String workingarea;
	
	private String quantity;

	private String modeofConnection;
	
	private String workingHour;
	
	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getTransportname() {
		return transportname;
	}

	public void setTransportname(String transportname) {
		this.transportname = transportname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getWorkingarea() {
		return workingarea;
	}

	public void setWorkingarea(String workingarea) {
		this.workingarea = workingarea;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public Double getAmountsum() {
		return amountsum;
	}

	public void setAmountsum(Double amountsum) {
		this.amountsum = amountsum;
	}

	public String getModeofConnection() {
		return modeofConnection;
	}

	public void setModeofConnection(String modeofConnection) {
		this.modeofConnection = modeofConnection;
	}

	public String getWorkingHour() {
		return workingHour;
	}

	public void setWorkingHour(String workingHour) {
		this.workingHour = workingHour;
	}

	@Override
	public String toString() {
		return "FarmerInfoEntity [driverName=" + driverName + ", transportname=" + transportname + ", age=" + age
				+ ", amountsum=" + amountsum + ", workingarea=" + workingarea + ", quantity=" + quantity
				+ ", modeofConnection=" + modeofConnection + ", workingHour=" + workingHour + "]";
	}

	public FarmerInfoEntity(String driverName, String transportname, int age, Double amountsum, String workingarea,
			String quantity, String modeofConnection, String workingHour) {
		super();
		this.driverName = driverName;
		this.transportname = transportname;
		this.age = age;
		this.amountsum = amountsum;
		this.workingarea = workingarea;
		this.quantity = quantity;
		this.modeofConnection = modeofConnection;
		this.workingHour = workingHour;
	}

	public FarmerInfoEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}


