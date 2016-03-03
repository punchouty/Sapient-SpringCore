package com.sapient.gmi.spring.example8.xml.properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("example8.xml");
		JokerThread main = appContext.getBean("jokerThread", JokerThread.class);
		main.start();
	}

}
