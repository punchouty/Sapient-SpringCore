package com.sapient.gmi.spring.example1.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
//		JokerThread main = new JokerThread();
//		main.start();
		ApplicationContext appContext = new ClassPathXmlApplicationContext("example1.xml");
		JokerThread main = appContext.getBean("jokerThread", JokerThread.class);
		main.start();
	}

}
