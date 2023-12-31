package com.sabji.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sabji.entity.GdmsApiUsers;
import com.sabji.repo.GdmsApiUserRepo;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("auth")
@Tag(name = "TESTING-API")
public class TestController {

	// @Autowired
	// GdmsApiUsers gdmsApiUsers;

	@Autowired
	GdmsApiUserRepo GdmsApiUserRepo;

	@Autowired
	BCryptPasswordEncoder encoder;

	@PostMapping("/register")
	public String registrationCheck() {

		GdmsApiUsers apiUsers = new GdmsApiUsers();
		apiUsers.setUsername("7275431268");
		apiUsers.setPassword(encoder.encode("password"));
		apiUsers.setFlgOfUser("A");
		GdmsApiUserRepo.save(apiUsers);

		return "success";

	}

	@GetMapping("/status")
	public ResponseEntity<?> test1() {

		return new ResponseEntity<>("hi everyone", HttpStatus.OK);
	}

}
