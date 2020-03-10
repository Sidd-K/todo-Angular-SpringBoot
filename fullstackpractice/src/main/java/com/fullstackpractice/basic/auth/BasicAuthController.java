package com.fullstackpractice.basic.auth;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class BasicAuthController {
	
	@GetMapping(value= "/basicAuth")
	public basicAuthBean hellobean() {
	//	throw new RuntimeException("Some Error Occurred, please contact Support at ****---******");
		return new basicAuthBean("You are validated");
	}
}
