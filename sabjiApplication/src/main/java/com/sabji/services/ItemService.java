package com.sabji.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sabji.entity.FarmerInfoEntity;
import com.sabji.entity.Items;
import com.sabji.entity.VegetableEntity;

 

 @Service
public interface ItemService {
	
	public Items itemservice(Items items); 
	
	public FarmerInfoEntity farmerService(FarmerInfoEntity farmerentity);
	
	public VegetableEntity VegetableService(VegetableEntity vegetablentity);

}
