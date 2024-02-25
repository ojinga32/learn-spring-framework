package com.in28minutes.learnspringframework.game;

import org.springframework.stereotype.Component;

/*
 @Component는 자동(앱 실행시)으로 Bean으로 등록
 @Bean은 수동(configuration에 무조건 작성)으로 Bean 등록 
 */

@Component
public class PacmanGame implements GamingConsole{

	public void up() {
		System.out.println("up");
	}
	
	public void down() {
		System.out.println("down");
	}
	
	public void left() {
		System.out.println("Go back");
	}
	
	public void right() {
		System.out.println("Accelerate");
	}

}
