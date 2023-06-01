package com.academy;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class AcademyController {
	
	@GetMapping(value="/academy")
	public String academy() {
		
		String url = "http://marzo:8080/marzo";
		
		RestTemplate restTemplate = new RestTemplate();
		
		String marzo = restTemplate.getForObject(url, String.class);
		
		return "Academy " + marzo;
	}

}
