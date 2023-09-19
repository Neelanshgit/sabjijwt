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

import com.sabji.model.RegisterModal;
import com.sabji.model.Response2;
import com.sabji.services.RegistrationService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("auth")
@Tag(name="Registration-API")
public class RegistrationController {


	@Autowired
	RegistrationService registrationService;

	@PostMapping(value = "/registerToApp")
	public ResponseEntity<?> registration(@Valid @RequestBody RegisterModal userMstr) {
		System.out.println("testing of the register with model api ");
		if (!userMstr.getPassword().equals(userMstr.getConfirmPassword())) {
			return Response2.generateResponse("Password Should match confirm password ", HttpStatus.BAD_REQUEST, "400");
		} else {
			String regResponse = registrationService.registerByMobileApplication(userMstr);
			if (regResponse.equalsIgnoreCase("existing")) {
				return Response2.generateResponse("User already exist ", HttpStatus.FOUND, "302");
			} else {
				return Response2.generateResponse("Successfully register", HttpStatus.OK, "200");
			}

		}

	}
}
