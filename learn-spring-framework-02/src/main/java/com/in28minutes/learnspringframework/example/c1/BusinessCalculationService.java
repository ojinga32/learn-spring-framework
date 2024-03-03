package com.in28minutes.learnspringframework.example.c1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.PacmanGame;

@Configuration
public class BusinessCalculationService {
	
	private DataService dataservice;
	
	public BusinessCalculationService(DataService dataservice) {
		this.dataservice = dataservice;
	}
	
	public int findMax() {
		return Arrays.stream(dataservice.retrieveData()).max().orElse(0);
	}	
}
