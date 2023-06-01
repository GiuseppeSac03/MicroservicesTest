package com.ibm.numeropari.controller;

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

import com.ibm.numeropari.service.impl.NumeroPariImpl;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class NumeroPariController {
	
	private static final Logger logger = LoggerFactory.getLogger( NumeroPariController.class );
	final String hostname = System.getenv().getOrDefault("HOSTNAME", "unknown");
	
	private final RestTemplate restTemplate;
	private final NumeroPariImpl numeropari;

    @Autowired
    public NumeroPariController(RestTemplate restTemplate, NumeroPariImpl numeropari) {
        this.restTemplate = restTemplate;
        this.numeropari = numeropari;
    }

	
	
	@RequestMapping
	public int getService() {
		return numeropari.getRandomEvenNumber();
	}
	

}
