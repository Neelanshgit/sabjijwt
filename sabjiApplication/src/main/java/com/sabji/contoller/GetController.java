package com.sabji.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sabji.entity.DriverDetails;
import com.sabji.entity.FarmerInfo;
import com.sabji.entity.FarmerInfoEntity;
import com.sabji.entity.Items;
import com.sabji.entity.VegetableEntity;
import com.sabji.model.BasicDetailsDTO;
import com.sabji.model.ResponseWithList;
import com.sabji.services.ItemService;

import io.swagger.v3.oas.annotations.tags.Tag;

 

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api")
@Tag(name="For-Getting-Data")
public class GetController {
	
	@Autowired
	ItemService itemService;
	
	@GetMapping("/findItems")
	public ResponseEntity<?> findAllItems(){
		
		List<BasicDetailsDTO> items =	itemService.getallItems();
		
		return new ResponseWithList().generateResponse("provide", HttpStatus.OK, "", items) ;
		
	}
	
	@GetMapping("/findVegatable")
	public ResponseEntity<?> findVegatableDetail(){
		
		List<VegetableEntity> vegetableEntities	 = itemService.getallVegetableDetail();
		return new ResponseWithList().generateResponse("provide", HttpStatus.OK, "", vegetableEntities) ;
		
		
		
	}

	
//	@GetMapping("/findFarmer")
//	public ResponseEntity<?> findFarmerDetail(){
//		
//		List<FarmerInfoEntity>  farmerInfoEntities =  itemService.getallFarmardetail();
//		return new ResponseWithList().generateResponse("provide", HttpStatus.OK, "", farmerInfoEntities) ;
//		
//	}
	@GetMapping("/findDeliveryPartner")
	public ResponseEntity<?> findDeliveryPartner(){
		
		List<FarmerInfoEntity>  farmerInfoEntities =  itemService.getallFarmardetail();
		return new ResponseWithList().generateResponse("provide", HttpStatus.OK, "", farmerInfoEntities) ;
		
	}
	
	@GetMapping("/findFarmer")
	public ResponseEntity<?> findfarmer(){
		
		List<FarmerInfo> farmerinformation = itemService.getallFarmerinfo();
		
		return new ResponseWithList().generateResponse("provide", HttpStatus.OK, "", farmerinformation) ;
	}

	@GetMapping("/findDriverDetails")
	public ResponseEntity<?> findDriver(){
		
		List<DriverDetails> driverdetails =  itemService.getdriverdetailsinfo();
		
		return new ResponseWithList().generateResponse("provide", HttpStatus.OK, "", driverdetails) ;
	}

}
