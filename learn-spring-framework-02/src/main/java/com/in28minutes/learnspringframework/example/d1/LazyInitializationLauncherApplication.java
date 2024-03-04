package com.in28minutes.learnspringframework.example.d1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
class ClassA {
	
}

@Component
@Lazy
class ClassB {
	
	ClassA classA;
	
	public ClassB(ClassA classA) {
		System.out.println("Some Initialization logic");
		this.classA = classA;
	}
	
	public void doSomething() {
		System.out.println("Do something");
	}
	
}

@Configuration
@ComponentScan
public class LazyInitializationLauncherApplication {
	
	public static void main(String[] args) {
		
		try (var context = new AnnotationConfigApplicationContext(
				LazyInitializationLauncherApplication.class)) {
			
			System.out.println("Initialization of context is completed");
			
			context.getBean(ClassB.class).doSomething();
			
			
			// 1. 초기화가 완료된 후 bean 로딩
		
			// 스프링 빈의 기본 초기화는 이른 초기화 (@Lazy를 사용하지 않고 시작 시 이른 시기에 초기화)
			
			/**
			 지연 초기화보다 이른 초화 권장 - 이유는 이른 초기화로 application 실행 시 바로 에러 확인
			 but @Lazy는 빈의 초기화를 지연시켜서 후에 지연 초기화 클래스 빈을 사용할때 에러 확인
			 if @Lazy를 configuration에 사용하면 모든 configuration의 bean이 지연된다.
			**/
			
			// 복잡한 여러 초기화 로직이 주어진 경우 시작을 지연시키고 싶지 않다면 스르핑 빈의 지연 초기화를 고려
			// 지연 초기화를 사용하는 경우 중요한 것은 스프링 설정의 오류가 application 시작 시 발견되지 않는 점.
			// 이로 인해 런타인 에러 발생
			
		}		
	}
}
