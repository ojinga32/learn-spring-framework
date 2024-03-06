package com.in28minutes.learnspringframework.example.e1;

import java.util.Arrays;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;


@Component
class SomeClass {
	
	private SomeDependency someDependency;
	
	@PostConstruct	// 의존성 주입이 완료되어 초기화가 수행된 후 실행되어야 하는 메소드에서 사용 가능
	public void initialize() {
		someDependency.getReady();
	}
	
	SomeClass(SomeDependency someDependency) {
		super();
		this.someDependency = someDependency;
		System.out.println("All dependencies are ready!");
	}
	
	@PreDestroy // 빈이 context에서 사라지기 가장 마지막에 호출 (예시 : DB사용하고 close)
	public void cleanUp() {
		System.out.println("CleanUp");
	}
	

	
}

@Component
class SomeDependency {

	@PostConstruct	// 의존성 주입이 완료되어 초기화가 수행된 후 실행되어야 하는 메소드에서 사용 가능
	public void getReady() {
		System.out.println("Some logic using SomeDependency");
	}

}

@Configuration
@ComponentScan
public class PrePostAnnotationsContextLauncherApplication {
	
	public static void main(String[] args) {
		
		try (var context = new AnnotationConfigApplicationContext(
				PrePostAnnotationsContextLauncherApplication.class)) {
			
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			
			}		
	}
}
