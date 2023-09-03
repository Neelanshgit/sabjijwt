package com.sabji.contoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

 

@RestController
public class GetController {
	
	@GetMapping("/findItems")
	public String findAllItems(){
		
		return "hi hellp";
		
	}
	
	@GetMapping("/findVegatable")
	public String findVegatableDetail(){
		
		return "hi hellp";
		
	}

	
	@GetMapping("/findFarmer")
	public String findFarmerDetail(){
		
		return "hi hellp";
		
	}


}
