package com.sabji.contoller;

import java.util.List;
import com.sabji.services.VendorService;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.sabji.entity.VendorEntity;

import com.sabji.model.ResponseWithList;
import com.sabji.model.ResponseWithObject;
import com.sabji.model.VendorModel;
import com.sabji.util.AppConstants;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
@Tag(name = "For Vendor details")

public class VendorController {
	@Autowired
	VendorService vendorService;
	
	@PostMapping("/addVendorData")
	@Operation(summary = "vendor ke data ko add karna hai")
	public ResponseEntity<Object> addVendorData(@Valid @RequestBody VendorModel vendormodel) {

		String responseOfSave = vendorService.saveVendorData(vendormodel);
		if (AppConstants.SUCCESSSTATUS.equals(responseOfSave)) {
			return new ResponseWithObject().generateResponse("Vendor saved successfully", HttpStatus.OK, "200",
					vendormodel);
		} else {
			return new ResponseWithObject().generateResponse("not saved", HttpStatus.OK, "500", vendormodel);
		}

	}
        
	@GetMapping("/getAllVendorByUserCode")
	@Operation(summary = "user ke hisab se saare vendor nikal lega ")
	public ResponseEntity<?> getAllVendorByUserCode(@RequestParam("userCode") String userCode) {
		List<VendorModel> vendormodel = vendorService.findAllvendorByUserCode(userCode);
		return new ResponseWithObject().generateResponse(AppConstants.SUCCESSSTATUS, HttpStatus.OK, "200",
				vendormodel);
	}
	
	
  
    @GetMapping("/findallvendor")
	@Operation(summary = "find all the vendor")
	public ResponseEntity<?> findvendor() {

		List<VendorEntity> vendorinformation = vendorService.getallVendorEntity();

		return new ResponseWithList().generateResponse(AppConstants.SUCCESSSTATUS, HttpStatus.OK, "200",
				vendorinformation);
	}
	
    @PutMapping("/updatevendordata")
    @Operation(summary = "update vendor details")
	public ResponseEntity<Object> updateVendorData(@Valid @RequestBody VendorModel vendormodel) {

		

		String responseOfSave = vendorService.saveVendorData(vendormodel);
		if (AppConstants.SUCCESSSTATUS.equals(responseOfSave)) {
			return new ResponseWithObject().generateResponse("Vendor saved successfully", HttpStatus.OK, "200",
					vendormodel);
		} else {
			return new ResponseWithObject().generateResponse("not saved", HttpStatus.OK, "500", vendormodel);
		}

	}
    @GetMapping("/getvendorCountByUserCode")
	@Operation(summary = "userCode ke hisab se sabji ka  vendor count nikale ")
	public ResponseEntity<?> getvendorCountByUserCode(@RequestParam("userCode") String userCode) {

		Long count = vendorService.getvendorcountByUserCode(userCode);

		return new ResponseWithObject().generateResponse(AppConstants.SUCCESSSTATUS, HttpStatus.OK, "200", count);
	}
}

