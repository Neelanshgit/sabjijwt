package com.sabji.contoller;

import java.io.IOException;

import javax.persistence.Column;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;

import com.sabji.entity.FarmerInfoEntity;
import com.sabji.entity.Items;
import com.sabji.entity.VegetableEntity;
import com.sabji.model.ResponseWithList;
import com.sabji.model.ResponseWithObject;
import com.sabji.services.ItemService;

import io.swagger.v3.oas.annotations.tags.Tag;
 

 

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api")
@Tag(name="For-Post-Data")
public class PostController {
	
	@Autowired
	ItemService itms;
	

	@PostMapping("/addItems")
	public ResponseEntity<?> addItems(@Valid @ModelAttribute Items itemname)
	{
	 
		itemname =	itms.itemservice(itemname);
 		  
		 return  new ResponseWithObject().generateResponse("", HttpStatus.OK, "", itemname);
		 
	}
	 
	@PostMapping("/upload")
    public VegetableEntity uploadImage(@RequestParam("file") MultipartFile file, @RequestParam("vegName") String vegName,
    		@RequestParam("time") String time, @RequestParam("requirementOfStorage") 
    		String requirementOfStorage, @RequestParam("vegetableDurability") String vegetableDurability
    		
    		) throws IOException 
	{
        
            VegetableEntity image = new VegetableEntity();
             image.setPic(file.getBytes());
             image.setVegetableName(vegName);
             image.setTimeperiod(time);
             image.setColdStorageRequirement(requirementOfStorage);
             image.setVegetableValidity(vegetableDurability);
            itms.VegetableService(image);
             
            return itms.VegetableService(image);
        
   
	}
	
	@PostMapping("/driverDetails")
	public ResponseEntity<?> uploadImage(@ModelAttribute FarmerInfoEntity farmarentity) {
		
//		return itms.farmerService(farmarentity);
		
		return new ResponseWithObject().generateResponse("provide", HttpStatus.OK, "", farmarentity) ;
	
	}
}	 
 