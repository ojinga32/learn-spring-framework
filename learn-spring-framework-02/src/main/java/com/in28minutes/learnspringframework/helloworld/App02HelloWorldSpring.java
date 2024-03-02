package com.in28minutes.learnspringframework.helloworld;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {
	
	public static void main(String[] args) {
		
		// 1: Launch a Spring Context - 
		try(var context =
				new AnnotationConfigApplicationContext
					(HelloWorldConfiguration.class)) {
			
			// 2: Configure the things that we want Spring to manage -
			// HelloWorldConfiguration - @Configuration
			// name - @Bean
			
			// 3: Retrieving Beans managed by Spring
//			Arrays.stream(context.getBeanDefinitionNames())
//				.forEach(System.out::println);
			
			System.out.println(context.getBean("personFive"));
			System.out.println(context.getBean("age"));
			System.out.println(context.getBean("person"));
		}
	
		

		
		
	}


}
