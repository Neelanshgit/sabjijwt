package com.sabji.contoller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("auth")
@Tag(name="API-TEST-WITH-JWT")
public class AppJwtTestApi {


	@GetMapping("/hi")
	@Operation(summary = "this api is  for testing that jwt token is valid or not")
	public ResponseEntity<?> test1() {

		return new ResponseEntity<>("token seems fine ,lajawaab", HttpStatus.OK);
	}
}
