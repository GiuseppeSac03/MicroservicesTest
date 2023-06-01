package com.cloud;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CloudController {
	
	@GetMapping(value="/cloud")
	public String cloud() {
		
		String url = "http://academy:8080/academy";
		
		RestTemplate restTemplate = new RestTemplate();
		
		String academy = restTemplate.getForObject(url, String.class);
		
		return "cloud " + academy;
	}

}
