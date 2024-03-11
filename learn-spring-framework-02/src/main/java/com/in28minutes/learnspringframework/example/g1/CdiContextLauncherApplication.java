package com.in28minutes.learnspringframework.example.g1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
class BusinessService {
	private DataService dataService;

	public DataService getDataService() {
		return dataService;
	}

	@Autowired
	public void setDataService(DataService dataService) {
		this.dataService = dataService;
	}
	
	
	
	
	
}

@Component
class DataService {

}

@Configuration
@ComponentScan
public class CdiContextLauncherApplication {
	
	public static void main(String[] args) {
		
		try (var context = new AnnotationConfigApplicationContext(
				CdiContextLauncherApplication.class)) {
			
			}		
	}
}
