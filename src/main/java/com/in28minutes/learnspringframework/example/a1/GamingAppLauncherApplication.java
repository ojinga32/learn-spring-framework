package com.in28minutes.learnspringframework.example.a1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.in28minutes.learnspringframework.example.a1")
public class GamingAppLauncherApplication {
	
	public static void main(String[] args) {

		try(var context = 
				new AnnotationConfigApplicationContext
					(GamingAppLauncherApplication.class)) {
			
				Arrays.stream(context.getBeanDefinitionNames())
					.forEach(System.out::println);
			
		}
	}
}
