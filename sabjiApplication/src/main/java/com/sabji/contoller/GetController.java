package com.sabji.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sabji.entity.FarmerInfoEntity;
import com.sabji.entity.Items;
import com.sabji.entity.VegetableEntity;
import com.sabji.services.ItemService;

 

@RestController
public class GetController {
	
	@Autowired
	ItemService itemService;
	
	@GetMapping("/findItems")
	public List<Items> findAllItems(){
		
		return  itemService.getallItems();
		
	}
	
	@GetMapping("/findVegatable")
	public List<VegetableEntity> findVegatableDetail(){
		
		return itemService.getallVegetableDetail();
		
	}

	
	@GetMapping("/findFarmer")
	public List<FarmerInfoEntity> findFarmerDetail(){
		
		return itemService.getallFarmardetail();
		
	}


}
