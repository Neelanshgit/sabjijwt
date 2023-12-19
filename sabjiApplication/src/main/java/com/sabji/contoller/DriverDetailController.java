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

import com.sabji.model.DriverDetailDTO;
import com.sabji.model.ResponseWithObject;
import com.sabji.services.DriverDetailService;
import com.sabji.services.VehcileService;
import com.sabji.util.AppConstants;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
@Tag(name = "For Driver details")
public class DriverDetailController {

	@Autowired
	DriverDetailService driverdetailservice;
	@Autowired
	VehcileService vehcileService;

	@PostMapping("/addDriverDetails")
	@Operation(summary = " वाहन  चालक और उससे सम्बंधित ")
	public ResponseEntity<Object> driverdetail(@Valid @RequestBody DriverDetailDTO driverDetailDTO) {

		String responseOfSave = vehcileService.saveDriverData(driverDetailDTO);
		if (AppConstants.SUCCESSSTATUS.equals(responseOfSave)) {
			return new ResponseWithObject().generateResponse("driver saved successfully", HttpStatus.OK, "200",
					driverDetailDTO);
		} else {
			return new ResponseWithObject().generateResponse("not saved", HttpStatus.OK, "500", driverDetailDTO);
		}

	}

	@GetMapping("/getDriverByUserCode")
	@Operation(summary = "ड्राईवर कोड से ड्राईवर की जानकारी निकाले ")
	public ResponseEntity<?> getDriverDetailsByUserCode(@RequestParam("userCode") String userCode) {
		List<DriverDetailDTO> driverDetailDTOs = driverdetailservice.findDriverDetailsByuserCode(userCode);
		return new ResponseWithObject().generateResponse(AppConstants.SUCCESSSTATUS, HttpStatus.OK, "",
				driverDetailDTOs);
	}

	@GetMapping("/getDriverByMobileno")
	@Operation(summary = "ड्राईवर के मोबाइल न. से ड्राईवर की जानकारी निकाले ")
	public ResponseEntity<?> getDriverDetailsBydriverNumber(@RequestParam("driverNumber") String driverNumber) {

		DriverDetailDTO driverdetaildto = driverdetailservice.findByDriverbydriverNumber(driverNumber);
		return new ResponseWithObject().generateResponse(AppConstants.SUCCESSSTATUS, HttpStatus.OK, "",
				driverdetaildto);
	}

	@GetMapping("/getDriverByarea")
	@Operation(summary = "ड्राईवर की गाड़ी चलाने वाले क्षेत्र से ड्राईवर की जानकारी निकाले ")
	public ResponseEntity<?> getDriverDetailsByarea(@RequestParam("area") String area) {

		DriverDetailDTO driverdetaildto = driverdetailservice.findByDriverbydriverarea(area);
		return new ResponseWithObject().generateResponse(AppConstants.SUCCESSSTATUS, HttpStatus.OK, "",
				driverdetaildto);
	}

	@GetMapping("/getDriverCountByUserCode")
	@Operation(summary = "userCode ke hisab se driver ka count nikale ")
	public ResponseEntity<?> getDriverCountByUserCode(@RequestParam("userCode") String userCode) {

		Long count = driverdetailservice.findVegetableCount(userCode);

		return new ResponseWithObject().generateResponse(AppConstants.SUCCESSSTATUS, HttpStatus.OK, "200", count);
	}

	@PutMapping("/updateDriverDetails")
	@Operation(summary = " वाहन  चालक और उससे सम्बंधित ")
	public ResponseEntity<Object> updateDriverDetails(@Valid @RequestBody DriverDetailDTO driverDetailDTO) {

		if (driverDetailDTO.getDriverId() == 0L || driverDetailDTO.getDriverId() == 0) {
			return new ResponseWithObject().generateResponse("id not found ", HttpStatus.BAD_REQUEST, "400",
					driverDetailDTO);
		}

		String responseOfSave = vehcileService.saveDriverData(driverDetailDTO);
		if (AppConstants.SUCCESSSTATUS.equals(responseOfSave)) {
			return new ResponseWithObject().generateResponse("driver saved successfully", HttpStatus.OK, "200",
					driverDetailDTO);
		} else {
			return new ResponseWithObject().generateResponse("not saved", HttpStatus.OK, "500", driverDetailDTO);
		}

	}
	@GetMapping("/getAllDriverByUserCode")
	@Operation(summary = "saare driver ki details nikal user code ke through Gorank")
	public ResponseEntity<?> getAllDriverDetailsByUserCode(@RequestParam("userCode") String userCode) {
		List<DriverDetailDTO> driverDetailDTOs = driverdetailservice.findAllDriverDetailsByUserCode(userCode);
		return new ResponseWithObject().generateResponse(AppConstants.SUCCESSSTATUS, HttpStatus.OK, "200",
				driverDetailDTOs);
	}
}
