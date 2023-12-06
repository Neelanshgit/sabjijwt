package com.sabji.contoller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sabji.entity.DriverDetails;
import com.sabji.entity.FarmerInfoEntity;
import com.sabji.model.ResponseWithObject;
import com.sabji.model.VegetableDetailsDTO;
import com.sabji.model.VegetableDetailsDTO2;
import com.sabji.services.ItemService;
import com.sabji.services.VegetableServices;
import com.sabji.services.VehcileService;
import com.sabji.util.AppConstants;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api")
@Tag(name = "For Saving Details from App")
public class PostController {

	@Autowired
	ItemService itms;

	@Autowired
	VehcileService vehcileService;

	@Autowired
	VegetableServices vegetableServices;

	@PostMapping(value = "/addVegitableDetails")
	@Operation(summary = "सब्जी से सम्बंधित जानकारी ")
	public ResponseEntity<Object> addVegetableDetails(@RequestBody VegetableDetailsDTO vegetableDetailsDTO) {

		String responseOfSave = vegetableServices.saveVegetableService(vegetableDetailsDTO);
		if (AppConstants.SUCCESSSTATUS.equals(responseOfSave)) {
			return new ResponseWithObject().generateResponse(AppConstants.SUCCESSSTATUS, HttpStatus.OK, "200",
					vegetableDetailsDTO);
		} else {
			return new ResponseWithObject().generateResponse(AppConstants.INTERNALERROR,
					HttpStatus.INTERNAL_SERVER_ERROR, "500", vegetableDetailsDTO);
		}
	}

	@PostMapping(value = "/addVegitableDetailsWithId")
	@Operation(summary = "सब्जी से सम्बंधित जानकारी ")
	public ResponseEntity<Object> addVegitableDetailsWithId(@RequestBody VegetableDetailsDTO vegetableDetailsDTO) {

		vegetableDetailsDTO = vegetableServices.saveVegetableServiceWithId(vegetableDetailsDTO);
		if (vegetableDetailsDTO.getVegId() != 0) {
			return new ResponseWithObject().generateResponse(AppConstants.SUCCESSSTATUS, HttpStatus.OK, "200",
					vegetableDetailsDTO);
		} else {
			return new ResponseWithObject().generateResponse(AppConstants.INTERNALERROR,
					HttpStatus.INTERNAL_SERVER_ERROR, "500", vegetableDetailsDTO);
		}
	}

	@PostMapping(value = "/addVegitablePic", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@Operation(summary = "सब्जी ki photo ")
	public ResponseEntity<Object> uploadImage(@Valid @RequestParam("pic") MultipartFile pic,
			@RequestParam("userCode") String userCode, @RequestParam("vegId") String vegId) {

		String responseOfSave = vegetableServices.saveVegeatableImage(pic, userCode, vegId);
		if (AppConstants.SUCCESSSTATUS.equals(responseOfSave)) {
			return new ResponseWithObject().generateResponse(AppConstants.SUCCESSSTATUS, HttpStatus.OK, "200", "U");
		} else {
			return new ResponseWithObject().generateResponse(AppConstants.INTERNALERROR,
					HttpStatus.INTERNAL_SERVER_ERROR, "500", "N");
		}
	}

	@PostMapping("/deliveryPartnerDetails")
	@Operation(summary = "हमसे जुड़ने के लिए तैयरा ")
	public ResponseEntity<Object> uploadImage(@Valid @RequestBody FarmerInfoEntity farmarentity) {

		return new ResponseWithObject().generateResponse("provide", HttpStatus.OK, "200", farmarentity);

	}

	@PostMapping("/addDriverDetailsBrief")
	@Operation(summary = " वाहन  चालक और उससे सम्बंधित ")
	public ResponseEntity<Object> driverdetail(@Valid @RequestBody DriverDetails driverdetails) {
		return new ResponseWithObject().generateResponse("provide", HttpStatus.OK, "200", driverdetails);

	}

	@PostMapping(value = "/addVegitableWithImage")
	@Operation(summary = "with single image as byte array ")
	public ResponseEntity<Object> addVegitableWithImage(@RequestBody VegetableDetailsDTO2 vegetableDetailsDTO) {

		vegetableDetailsDTO = vegetableServices.saveVegitableWithImage(vegetableDetailsDTO);
		if (vegetableDetailsDTO.getVegId() != 0) {
			return new ResponseWithObject().generateResponse(AppConstants.SUCCESSSTATUS, HttpStatus.OK, "200",
					vegetableDetailsDTO);
		} else {
			return new ResponseWithObject().generateResponse(AppConstants.INTERNALERROR,
					HttpStatus.INTERNAL_SERVER_ERROR, "500", vegetableDetailsDTO);
		}
	}

	@PutMapping(value = "/updateVegetable")
	@Operation(summary = "updation of the vegetable ")
	public ResponseEntity<Object> updateVegetable(@RequestBody VegetableDetailsDTO vegetableDetailsDTO) {

		if (vegetableDetailsDTO.getVegId() == 0 || vegetableDetailsDTO.getVegId() == 0L) {
			return new ResponseWithObject().generateResponse("missing unique id ", HttpStatus.BAD_REQUEST, "400",
					vegetableDetailsDTO);
		}
		vegetableDetailsDTO = vegetableServices.saveVegetableServiceWithId(vegetableDetailsDTO);
		if (vegetableDetailsDTO.getVegId() != 0) {
			return new ResponseWithObject().generateResponse(AppConstants.SUCCESSSTATUS, HttpStatus.OK, "200",
					vegetableDetailsDTO);
		} else {
			return new ResponseWithObject().generateResponse(AppConstants.INTERNALERROR,
					HttpStatus.INTERNAL_SERVER_ERROR, "500", vegetableDetailsDTO);
		}
	}

}
