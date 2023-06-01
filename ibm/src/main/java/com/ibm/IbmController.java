package com.ibm;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class IbmController {
	
	@GetMapping(value="/ibm")
	public String ibm() {
		
		String url = "http://cloud:8080/cloud";
		
		RestTemplate restTemplate = new RestTemplate();
		
		String cloud = restTemplate.getForObject(url, String.class);
		
		return "ibm " + cloud;
	}

}
