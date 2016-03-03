package com.sapient.gmi.spring.example4.xml.lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("example4.xml");
		JokerThread main = appContext.getBean("jokerThread", JokerThread.class);
		main.start();
		main.join();
		((AbstractApplicationContext)appContext).registerShutdownHook();
	}

}
