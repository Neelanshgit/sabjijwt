package com.sabji.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sabji.entity.DriverDetails;
import com.sabji.entity.FarmerInfo;
import com.sabji.entity.FarmerInfoEntity;
import com.sabji.entity.VegetableEntity;
import com.sabji.model.BasicDetailsDTO;
import com.sabji.model.ResponseWithList;
import com.sabji.model.ResponseWithObject;
import com.sabji.model.VegetableDetailsDTO;
import com.sabji.services.FarmerService;
import com.sabji.services.ItemService;
import com.sabji.services.VegetableServices;
import com.sabji.services.VehcileService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api")
@Tag(name = "For fetching the Data")
public class GetController {

	@Autowired
	ItemService itemService;

	@Autowired
	FarmerService farmerService;

	@Autowired
	VehcileService vehcileService;

	@Autowired
	VegetableServices vegetableServices;

	@GetMapping("/findItems")
	public ResponseEntity<Object> findAllItems() {

		List<BasicDetailsDTO> items = itemService.getallItems();

		return new ResponseWithList().generateResponse("provided", HttpStatus.OK, "", items);

	}

	@GetMapping("/findVegatable")
	public ResponseEntity<?> findVegatableDetail() {

		List<VegetableEntity> vegetableEntities = itemService.getallVegetableDetail();
		return new ResponseWithList().generateResponse("provide", HttpStatus.OK, "", vegetableEntities);

	}

	@GetMapping("/findDeliveryPartner")
	public ResponseEntity<?> findDeliveryPartner() {

		List<FarmerInfoEntity> farmerInfoEntities = itemService.getallFarmardetail();
		return new ResponseWithList().generateResponse("provide", HttpStatus.OK, "", farmerInfoEntities);

	}

	@GetMapping("/findFarmer")
	public ResponseEntity<?> findfarmer() {

		List<FarmerInfo> farmerinformation = itemService.getallFarmerinfo();

		return new ResponseWithList().generateResponse("provide", HttpStatus.OK, "", farmerinformation);
	}

	@GetMapping("/findDriverDetails")
	public ResponseEntity<?> findDriver() {

		List<DriverDetails> driverdetails = itemService.getdriverdetailsinfo();

		return new ResponseWithList().generateResponse("provide", HttpStatus.OK, "", driverdetails);
	}

	@GetMapping("/getVegById")
	@Operation(summary = "sabji khoje sabji ki id dwara")
	public ResponseEntity<?> getVegById(@RequestParam("vegId") String vegId) {

		VegetableDetailsDTO vegetableDetailsDTOs = vegetableServices.findVegetable(Long.parseLong(vegId));

		return new ResponseWithObject().generateResponse("provide", HttpStatus.OK, "", vegetableDetailsDTOs);
	}

	@GetMapping("/getVegUserCode")
	@Operation(summary = "sabji khoje userCode ke dwara")
	public ResponseEntity<?> getVegUserCode(@RequestParam("userCode") String userCode) {

		List<VegetableDetailsDTO> vegetableDetailsDTOs = vegetableServices.findVegetableByUserCode(userCode);

		return new ResponseWithList().generateResponse("provide", HttpStatus.OK, "", vegetableDetailsDTOs);
	}

	@GetMapping("/getVegByName")
	@Operation(summary = "sabji khoje nam se jitni bhi like me  ajae ")
	public ResponseEntity<?> getVegByName(@RequestParam("vegName") String vegName) {

		List<VegetableDetailsDTO> vegetableDetailsDTOs = vegetableServices.findVegetablebyName(vegName);

		return new ResponseWithList().generateResponse("provide", HttpStatus.OK, "", vegetableDetailsDTOs);
	}

	@GetMapping("/getVegCountByUserCode")
	@Operation(summary = "userCode ke hisab se sabji ka count nikale ")
	public ResponseEntity<?> getVegCountByUserCode(@RequestParam("userCode") String userCode) {

		Long count = vegetableServices.findVegetableCount(userCode);

		return new ResponseWithObject().generateResponse("provide", HttpStatus.OK, "", count);
	}

}
