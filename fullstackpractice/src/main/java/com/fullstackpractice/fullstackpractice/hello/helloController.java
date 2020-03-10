package com.fullstackpractice.fullstackpractice.hello;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins="http://localhost:4200")
@RestController
public class helloController {
	
	@GetMapping(value= "/hello")
	public String hello() {
		return "hello dear";
	}
	
	@GetMapping(value= "/hellobean")
	public HelloBean hellobean() {
	//	throw new RuntimeException("Some Error Occurred, please contact Support at ****---******");
		return new HelloBean("Hi there from Java bean");
	}
}
