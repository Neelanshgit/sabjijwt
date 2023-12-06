package com.sabji.contoller;

import java.util.List;

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

import com.sabji.entity.FarmerInfo;
import com.sabji.model.FarmerInfoDTO;
import com.sabji.model.ResponseWithList;
import com.sabji.model.ResponseWithObject;
import com.sabji.services.FarmerService;
import com.sabji.util.AppConstants;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api")
@Tag(name = "Kisan API")
public class FarmerController {

	@Autowired
	FarmerService farmerService;

	@PostMapping("/addKisanData")
	@Operation(summary = "किसान से सम्बंधित जानकारी ")
	public ResponseEntity<Object> addItems(@Valid @RequestBody FarmerInfoDTO farmerInfoDTO) {

		String responseOfSave = farmerService.saveFarmerData(farmerInfoDTO);
		if (AppConstants.SUCCESSSTATUS.equals(responseOfSave)) {
			return new ResponseWithObject().generateResponse("Farmer saved successfully", HttpStatus.OK, "200",
					farmerInfoDTO);
		} else {
			return new ResponseWithObject().generateResponse("not saved", HttpStatus.OK, "500", farmerInfoDTO);
		}

	}

	@GetMapping("/findAllKisan")
	@Operation(summary = "find all the kisan")
	public ResponseEntity<?> findfarmer() {

		List<FarmerInfo> farmerinformation = farmerService.getallFarmerinfo();

		return new ResponseWithList().generateResponse(AppConstants.SUCCESSSTATUS, HttpStatus.OK, "200",
				farmerinformation);
	}

	@GetMapping("/getfarmerCountByUserCode")
	@Operation(summary = "userCode ke hisab se sabji ka count nikale ")
	public ResponseEntity<?> getfarmerCountByUserCode(@RequestParam("userCode") String userCode) {

		Long count = farmerService.getfarmerCountByUserCode(userCode);

		return new ResponseWithObject().generateResponse(AppConstants.SUCCESSSTATUS, HttpStatus.OK, "200", count);
	}

	@GetMapping("/getAllKisanByUserCode")
	@Operation(summary = "userCode ke hisab se sare farmer ")
	public ResponseEntity<?> getfarmerByUserCode(@RequestParam("userCode") String userCode) {

		List<FarmerInfoDTO> farmerInfoDTOs = farmerService.getfarmerByUserCode(userCode);
		if (farmerInfoDTOs.isEmpty()) {
			return new ResponseWithObject().generateResponse(AppConstants.SUCCESSSTATUS, HttpStatus.NOT_FOUND, "404",
					farmerInfoDTOs);
		} else {
			return new ResponseWithObject().generateResponse(AppConstants.SUCCESSSTATUS, HttpStatus.OK, "200",
					farmerInfoDTOs);
		}

	}

	@PutMapping("/updateKisanData")
	@Operation(summary = "update kisan details")
	public ResponseEntity<Object> updateKisanData(@Valid @RequestBody FarmerInfoDTO farmerInfoDTO) {

		if (farmerInfoDTO.getFarmerId() == 0) {
			return new ResponseWithObject().generateResponse("farmer id missing", HttpStatus.OK, "400", farmerInfoDTO);
		}

		String responseOfSave = farmerService.saveFarmerData(farmerInfoDTO);
		if (AppConstants.SUCCESSSTATUS.equals(responseOfSave)) {
			return new ResponseWithObject().generateResponse("Farmer saved successfully", HttpStatus.OK, "200",
					farmerInfoDTO);
		} else {
			return new ResponseWithObject().generateResponse("not saved", HttpStatus.OK, "500", farmerInfoDTO);
		}

	}

}
