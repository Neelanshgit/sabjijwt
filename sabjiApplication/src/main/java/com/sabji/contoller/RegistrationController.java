package com.sabji.contoller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sabji.model.ProfileModel;
import com.sabji.model.RegisterModal;
import com.sabji.model.Response2;
import com.sabji.model.ResponseWithObject;
import com.sabji.services.RegistrationService;
import com.sabji.util.AppConstants;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("auth")
@Tag(name = "Registration-API")
public class RegistrationController {

	@Autowired
	RegistrationService registrationService;

	private org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(RegistrationController.class);

	@PostMapping(value = "/registerToApp")
	public ResponseEntity<?> registration(@Valid @RequestBody RegisterModal userMstr) {

		String mobileStatus = registrationService.findByMobile(userMstr);
		if ("A".equals(mobileStatus)) {
			return Response2.generateResponse("Mobile Number already available", HttpStatus.OK, "201");
		} else {
			String regResponse = registrationService.registerByMobileApplication(userMstr);
			log.info("Registration status of the user {} ", regResponse);
			if (regResponse.equalsIgnoreCase("existing")) {
				return Response2.generateResponse("User already exist ", HttpStatus.FOUND, "302");
			} else if (regResponse.equalsIgnoreCase("Error")) {
				return Response2.generateResponse("Something wnet wrong", HttpStatus.OK, "200");
			} else {
				return Response2.generateResponse("Successfully register", HttpStatus.OK, "200");
			}
		}

	}

	@PostMapping(value = "/profileData")
	public ResponseEntity<?> profileData(String userCode) {

		ProfileModel profile = registrationService.getProfileData(userCode);
		if (profile != null) {
			return new ResponseWithObject().generateResponse(AppConstants.SUCCESSSTATUS, HttpStatus.OK, "200", profile);
		} else {
			return new ResponseWithObject().generateResponse("NA", HttpStatus.NOT_FOUND, "200", profile);
		}

	}

}
