package com.in28minutes.learnspringframework.example.examples.c1;

import java.util.Arrays;

import org.springframework.stereotype.Component;

@Component
public class BusinessCalculationSerivce {
	
	private DataService dataService;
	
	
	
	public BusinessCalculationSerivce(DataService dataService) {
		super();
		this.dataService = dataService;
	}



	public int findMax() {
		return Arrays.stream(dataService.retrieveData())
				.max().orElse(0);
	}
}
