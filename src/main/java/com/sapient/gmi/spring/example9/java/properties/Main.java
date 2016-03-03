package com.sapient.gmi.spring.example9.java.properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
		JokerThread main = appContext.getBean("jokerThread", JokerThread.class);
		main.start();
		main.join();
		((AbstractApplicationContext)appContext).registerShutdownHook();
	}

}
