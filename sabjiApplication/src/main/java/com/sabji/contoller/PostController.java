package com.sabji.contoller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;

import com.sabji.entity.FarmerInfoEntity;
import com.sabji.entity.Items;
import com.sabji.entity.VegetableEntity;
import com.sabji.services.ItemService;
 

 

@RestController
public class PostController {
	
	@Autowired
	ItemService itms;
	

	@PostMapping("/addItems")
	public ResponseEntity<?> addItems(@Valid @RequestBody Items itemname)
	{
	try {
		if(itemname==null) {
			throw new MultipartException("some parameter is mission");
			}
		  itms.itemservice(itemname);
		return ResponseEntity.status(HttpStatus.OK).body("Items added successfully");
	}
	catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error to added the product");
    }
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
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file, @RequestParam("vegName") String vegName,
    		@RequestParam("time") String time) 
	{
        try {
            VegetableEntity image = new VegetableEntity();
             image.setPic(file.getBytes());
             image.setVegetableName(vegName);
             image.setTimeperiod(time);
            itms.VegetableService(image);
            return ResponseEntity.ok("Image uploaded successfully");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Failed to upload image: " + e.getMessage());
        }
	}
	
	@PostMapping("/driverDetails")
	public ResponseEntity<?> uploadImage(@RequestBody FarmerInfoEntity farmarentity) {
		
        try {
             itms.farmerService(farmarentity);
            return ResponseEntity.status(HttpStatus.OK).body("Data uploaded successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error to add the data");
        }
    }
	
	}
		 
 