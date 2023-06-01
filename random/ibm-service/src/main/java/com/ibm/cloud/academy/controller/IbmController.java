package com.ibm.cloud.academy.controller;

import java.util.Objects;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class IbmController {
	
	private static final Logger logger = LoggerFactory.getLogger( IbmController.class );
	final String hostname = System.getenv().getOrDefault("HOSTNAME", "unknown");
	
	private final RestTemplate restTemplate;
	
	public IbmController(RestTemplate rest) {
		this.restTemplate = rest;
	}

	
	@HystrixCommand( fallbackMethod = "defaultService" )
	@RequestMapping
	public String getService() {
		String url = "http://cloud-service/getServiceCloud";
		ResponseEntity<String> servicebRes = restTemplate.getForEntity(url, String.class);
		
		return Objects.requireNonNull("IBM" + servicebRes.getBody());
	}
	
	
	public String defaultService() {
		return "IBM(fallback)Cloud Academy Marzo 2023";
	}

}
