package com.sabji.contoller;

import java.util.List;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sabji.model.DriverDetailDTO;
import com.sabji.model.ResponseWithList;
import com.sabji.model.ResponseWithObject;
import com.sabji.services.DriverDetailService;

import io.swagger.v3.oas.annotations.Operation;

 

@RestController
@RequestMapping("/api")
public class DriverDetailController {

	
	@Autowired
	DriverDetailService driverdetailservice ;
	@GetMapping("/getDriverByUserCode")
	@Operation(summary = "ड्राईवर कोड से ड्राईवर की जानकारी निकाले ")
	public ResponseEntity<?> getDriverDetailsByUserCode(@RequestParam("userCode") String userCode){
		
		DriverDetailDTO driverdetaildto = driverdetailservice.findByuserCode(userCode);
				return new ResponseWithObject().generateResponse("provide", HttpStatus.OK, "", driverdetaildto);
	}
	
	@GetMapping("/getDriverByMobileno")
	@Operation(summary = "ड्राईवर के मोबाइल न. से ड्राईवर की जानकारी निकाले ")
	public ResponseEntity<?> getDriverDetailsBydriverNumber(@RequestParam("driverNumber") String driverNumber){
		
		DriverDetailDTO driverdetaildto = driverdetailservice.findByDriverbydriverNumber(driverNumber);
				return new ResponseWithObject().generateResponse("provide", HttpStatus.OK, "", driverdetaildto);
	}


	@GetMapping("/getDriverByarea")
	@Operation(summary = "ड्राईवर की गाड़ी चलाने वाले क्षेत्र से ड्राईवर की जानकारी निकाले ")
	public ResponseEntity<?> getDriverDetailsByarea(@RequestParam("area") String area){
		
		DriverDetailDTO driverdetaildto = driverdetailservice.findByDriverbydriverarea(area);
				return new ResponseWithObject().generateResponse("provide", HttpStatus.OK, "", driverdetaildto);
	}
	
	 
} 


 
 
 