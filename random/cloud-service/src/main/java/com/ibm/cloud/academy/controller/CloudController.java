package com.ibm.cloud.academy.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import java.util.Objects;
import java.util.Random;

@RestController
public class CloudController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CloudController.class);
	private final String hostname = System.getenv().getOrDefault("HOSTNAME", "unknown");
	
	private final RestTemplate restTemplate;
	
	public CloudController(RestTemplate rest) {
		this.restTemplate = rest;
	}
	
	@HystrixCommand( fallbackMethod = "defaultService" )
	@RequestMapping(value = "/getServiceCloud")
	public String getService() {
		String url = "http://academy-service/getServiceAcademy";
		ResponseEntity<String> servicebRes = restTemplate.getForEntity(url, String.class);
		
		return Objects.requireNonNull("Cloud" + servicebRes.getBody());
	}
	
	public String defaultService() {
		return "Cloud (Fallback)Academy Marzo 2023";
	}

}
