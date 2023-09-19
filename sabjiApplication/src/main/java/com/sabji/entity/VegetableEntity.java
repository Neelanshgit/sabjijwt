package com.sabji.entity;
 
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

 
 

@Entity
@Table(name="vegetable_details")
public class VegetableEntity {
	
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	public int id;
	
	
	private String vegetableName;
	
    private byte[] pic;
	 
	private String timeperiod;


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


	@Override
	public int hashCode() {
		return Objects.hash(pic, timeperiod, vegetableName);
	}


	@Override
	public String toString() {
		return "VegetableEntity [vegetableName=" + vegetableName + ", pic=" + pic + ", timeperiod=" + timeperiod + "]";
	}


	public VegetableEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	public VegetableEntity(String vegetableName, byte[] pic, String timeperiod) {
		super();
		this.vegetableName = vegetableName;
		this.pic = pic;
		this.timeperiod = timeperiod;
	}


	 
 


	 
	
	
}
