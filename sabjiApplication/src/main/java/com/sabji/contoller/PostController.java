package com.sabji.contoller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sabji.entity.DriverDetails;
import com.sabji.entity.FarmerInfoEntity;
import com.sabji.entity.VegetableEntity;
import com.sabji.model.DriverDetailDTO;
import com.sabji.model.FarmerInfoDTO;
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
@Tag(name = "For Saving Details from App")
public class PostController {

	@Autowired
	ItemService itms;

	@Autowired
	FarmerService farmerService;

	@Autowired
	VehcileService vehcileService;

	@Autowired
	VegetableServices vegetableServices;

	final String successStatus = "Success";

	@PostMapping(value = "/addVegitableDetails")
	@Operation(summary = "सब्जी से सम्बंधित जानकारी ")
	public ResponseEntity<Object> addVegetableDetails(@RequestBody VegetableDetailsDTO vegetableDetailsDTO) {

		String responseOfSave = vegetableServices.saveVegetableService(vegetableDetailsDTO);
		if (successStatus.equals(responseOfSave)) {
			return new ResponseWithObject().generateResponse("vegetable saved successfully", HttpStatus.OK, "",
					vegetableDetailsDTO);
		} else {
			return new ResponseWithObject().generateResponse("some thing went wrong", HttpStatus.INTERNAL_SERVER_ERROR,
					"", vegetableDetailsDTO);
		}
	}

	@PostMapping(value = "/addVegitableDetailsWithId")
	@Operation(summary = "सब्जी से सम्बंधित जानकारी ")
	public ResponseEntity<Object> addVegitableDetailsWithId(@RequestBody VegetableDetailsDTO vegetableDetailsDTO) {

		vegetableDetailsDTO = vegetableServices.saveVegetableServiceWithId(vegetableDetailsDTO);
		if (vegetableDetailsDTO.getVegId() != 0) {
			return new ResponseWithObject().generateResponse("vegetable saved successfully", HttpStatus.OK, "",
					vegetableDetailsDTO);
		} else {
			return new ResponseWithObject().generateResponse("some thing went wrong", HttpStatus.INTERNAL_SERVER_ERROR,
					"", vegetableDetailsDTO);
		}
	}

	@PostMapping(value = "/addVegitablePic", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@Operation(summary = "सब्जी ki photo ")
	public ResponseEntity<Object> uploadImage(@Valid @RequestParam("pic") MultipartFile pic,
			@RequestParam("userCode") String userCode, @RequestParam("vegId") String vegId) {

		String responseOfSave = vegetableServices.saveVegeatableImage(pic, userCode, vegId);
		if (successStatus.equals(responseOfSave)) {
			return new ResponseWithObject().generateResponse("vegetable saved successfully", HttpStatus.OK, "", "U");
		} else {
			return new ResponseWithObject().generateResponse("some thing went wrong", HttpStatus.INTERNAL_SERVER_ERROR,
					"", "N");
		}
	}

	@PostMapping("/addKisanData")
	@Operation(summary = "किसान से सम्बंधित जानकारी ")
	public ResponseEntity<Object> addItems(@Valid @ModelAttribute FarmerInfoDTO farmerInfoDTO) {

		String responseOfSave = farmerService.saveFarmerData(farmerInfoDTO);
		if (successStatus.equals(responseOfSave)) {
			return new ResponseWithObject().generateResponse("Farmer saved successfully", HttpStatus.OK, "",
					farmerInfoDTO);
		} else {
			return new ResponseWithObject().generateResponse("not saved", HttpStatus.OK, "", farmerInfoDTO);
		}

	}

	@PostMapping("/addDriverDetails")
	@Operation(summary = " वाहन  चालक और उससे सम्बंधित ")
	public ResponseEntity<Object> driverdetail(@Valid @ModelAttribute DriverDetailDTO driverDetailDTO) {

		String responseOfSave = vehcileService.saveDriverData(driverDetailDTO);
		if (successStatus.equals(responseOfSave)) {
			return new ResponseWithObject().generateResponse("driver saved successfully", HttpStatus.OK, "",
					driverDetailDTO);
		} else {
			return new ResponseWithObject().generateResponse("not saved", HttpStatus.OK, "", driverDetailDTO);
		}

	}

	/* neeche ki sari api theek karo narendra */

	@PostMapping("/deliveryPartnerDetails")
	@Operation(summary = "हमसे जुड़ने के लिए तैयरा ")
	public ResponseEntity<Object> uploadImage(@Valid @ModelAttribute FarmerInfoEntity farmarentity) {

		return new ResponseWithObject().generateResponse("provide", HttpStatus.OK, "", farmarentity);

	}

	@PostMapping("/addDriverDetailsBrief")
	@Operation(summary = " वाहन  चालक और उससे सम्बंधित ")
	public ResponseEntity<Object> driverdetail(@Valid @ModelAttribute DriverDetails driverdetails) {
		return new ResponseWithObject().generateResponse("provide", HttpStatus.OK, "", driverdetails);

	}

	@PostMapping(value = "/addVegetable", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@Operation(summary = "add vegatble")
	public VegetableEntity uploadImage(@Valid @RequestParam("file") MultipartFile file,
			@RequestParam("vegName") String vegName, @RequestParam("time") String time,
			@RequestParam("requirementOfStorage") String requirementOfStorage,
			@RequestParam("vegetableDurability") String vegetableDurability) throws IOException {
		VegetableEntity image = new VegetableEntity();
		image.setPic(file.getBytes());
		image.setVegetableName(vegName);
		image.setTimeperiod(time);
		image.setColdStorageRequirement(requirementOfStorage);
		image.setVegetableValidity(vegetableDurability);
		itms.VegetableService(image);
		return itms.VegetableService(image);
	}

}
