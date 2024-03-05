package com.in28minutes.learnspringframework.example.e1;

import java.util.Arrays;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value=ConfigurableBeanFactory.SCOPE_SINGLETON)
class NormalClass {
	/** 
	SINGLETONE은 하나의 인스턴스만 생성 (재사용)
	component기본 값
	대부분 사용
	모든 어플리케이션에서 사용,
	무상태 빈을 원하고 사용자 정보를 갖고 있지 않고 제네릭잉며 에플리케이션 전체에 사용 할 수 있을 때
	
	*/
}

@Component
@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PrototypeClass {
	/** 
	PROTOTYPE은 사용될때마다 각 인스턴스 생성 (뉴생성)
	component 값 지정 해줘야 함
	드물게 사용
	상태 유지 빈을 원하고 사용자 정보를 갖고 있는 빈을 생성하길 원하고 하나의 에플리케이션에서 사용하길 원하는 경우
	예를 들어, [동양생명 excel Import] 작업 각 row마다 DB에 넣어줘야 하는데 싱글톤을 사용하면 여러명에서 Import 기능을
	쓰는 순간 값이 꼬임, 이때 prototype을 쓰면 여러명이 Import 기능을 쓰더라도 각자의 인스턴스에만 값을 저장하고 사용
	*/
}

@Configuration
@ComponentScan
public class BeanScopesLauncherApplication {
	
	public static void main(String[] args) {
		
		try (var context = new AnnotationConfigApplicationContext(
				BeanScopesLauncherApplication.class)) {
			
			System.out.println(context.getBean(NormalClass.class));	// com.in28minutes.learnspringframework.example.e1.NormalClass@13df2a8c
			System.out.println(context.getBean(NormalClass.class)); // com.in28minutes.learnspringframework.example.e1.NormalClass@13df2a8c
			System.out.println(context.getBean(NormalClass.class)); // com.in28minutes.learnspringframework.example.e1.NormalClass@13df2a8c
			
			System.out.println(context.getBean(PrototypeClass.class)); // com.in28minutes.learnspringframework.example.e1.PrototypeClass@1ebea008
			System.out.println(context.getBean(PrototypeClass.class)); // com.in28minutes.learnspringframework.example.e1.PrototypeClass@72d6b3ba
			System.out.println(context.getBean(PrototypeClass.class)); // com.in28minutes.learnspringframework.example.e1.PrototypeClass@1787f2a0
		}		
	}
}
