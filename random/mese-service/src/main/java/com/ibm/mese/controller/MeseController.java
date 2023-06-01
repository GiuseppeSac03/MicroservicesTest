package com.ibm.mese.controller;

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
public class MeseController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MeseController.class);
	private final String hostname = System.getenv().getOrDefault("HOSTNAME", "unknown");
	
	@RequestMapping(value = "/getServiceMese")
	public String getService() {
		return "Marzo 2023";
	}
	
}
