package com.sabji.contoller;

import java.io.IOException;

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
	 
	 
 
//	@PostMapping("/addVegetable")
//	public ResponseEntity<?> uploadImage(@RequestBody VegetableEntity ventity) {
//        try {
//             
//
//          itms.VegetableService(ventity);
//
//            return ResponseEntity.status(HttpStatus.OK).body("Image uploaded successfully");
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading the image");
//        }
//    }
	
	@PostMapping("/upload")
    public VegetableEntity uploadImage(@RequestParam("file") MultipartFile file, @RequestParam("vegName") String vegName,
    		@RequestParam("time") String time) throws IOException 
	{
        
            VegetableEntity image = new VegetableEntity();
             image.setPic(file.getBytes());
             image.setVegetableName(vegName);
             image.setTimeperiod(time);
            itms.VegetableService(image);
            return itms.VegetableService(image);
         
	}
	
	@PostMapping("/driverDetails")
	public FarmerInfoEntity uploadImage(@ModelAttribute FarmerInfoEntity farmarentity) {
		
		return itms.farmerService(farmarentity);
	
	}
}	 
 