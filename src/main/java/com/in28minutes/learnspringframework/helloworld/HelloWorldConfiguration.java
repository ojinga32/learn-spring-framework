package com.in28minutes.learnspringframework.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

record Person (String name, int age, Address address) {};

record Address (String firstLine, String city) {};

@Configuration
public class HelloWorldConfiguration {

	@Bean
	public String name() {
		return "Ranga";
	}
	
	@Bean
	public int age() {
		return 15;
	}
	
	@Bean
	public Person person() {
		return new Person("Ravi", 20, new Address("Bucheon", "Songnae"));
	}

	@Bean(name = "person2")
	public Person personSecond() {
		return new Person("Ravi", 20, new Address("Bucheon", "Songnae"));
	}
	
	@Bean
	@Qualifier("personQualifier")
	public Person personMethod() {
		return new Person(name(), age(), address());						// 메소드를 전달할때는 메소드명
	}

	@Bean
	public Person personFive(String name, int age, @Qualifier("addressQualifier")Address address) {	// 파라미터로 전달할때는 빈Name
		return new Person(name, age, address);
	}
	
	@Bean
	public Person personParameter(String name, int age, Address address2) {	// 파라미터로 전달할때는 빈Name
		return new Person(name, age, address2);
	}
	
	@Bean
	@Qualifier("addressQualifier")
	public Address address() {
		return new Address("Baker Street", "London");
	}
	
	@Bean(name = "address2")
	@Primary
	public Address addressSecond() {
		return new Address("USA", "LosAngeles");
	}
	
}










