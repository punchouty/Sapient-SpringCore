package com.sapient.gmi.spring.example3.xml.autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sapient.gmi.spring.example2.xml.JokerThread;

public class MainAutowired {

	public static void main(String[] args) {
//		JokerThread main = new JokerThread();
//		main.start();
		ApplicationContext appContext = new ClassPathXmlApplicationContext("example3.xml");
		JokerThread main = appContext.getBean("jokerThread", JokerThread.class);
		main.start();
	}

}
