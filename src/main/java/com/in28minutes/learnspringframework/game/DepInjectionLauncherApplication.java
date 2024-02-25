package com.in28minutes.learnspringframework.game;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.in28minutes.learnspringframework.game")
public class DepInjectionLauncherApplication {
	
	public static void main(String[] args) {

		try(var context = 
				new AnnotationConfigApplicationContext
					(DepInjectionLauncherApplication.class)) {
			
//			context.getBean(GamingConsole.class).up(); 
//			context.getBean(GameRunner.class).run();
			Arrays.stream(context.getBeanDefinitionNames())
			.forEach(System.out::println);
			
		}
	}
}
