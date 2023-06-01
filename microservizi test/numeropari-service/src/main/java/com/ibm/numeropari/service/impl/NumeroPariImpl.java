package com.ibm.numeropari.service.impl;

import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ibm.numeropari.service.numeropari;

@Service
public class NumeroPariImpl implements numeropari{
	
	
	//imposta un range da 0 a n (nel file .yml) dal quale prendere il numero pari random
	
	@Value("${numeromax}")
	int numeroMax;
	
	public int getRandomEvenNumber() {
	    Random random = new Random();
	    int num;
	    do {
	        num = random.nextInt(numeroMax);
	    } while (num % 2 != 0);
	    return num;
	}
	

}
