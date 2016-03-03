package com.sapient.gmi.spring.example5.xml.lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sapient.gmi.spring.example4.xml.lifecycle.JokerThread;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("example5.xml");
		JokerThread main = appContext.getBean("jokerThread", JokerThread.class);
		main.start();
		main.join();
		((AbstractApplicationContext)appContext).registerShutdownHook();
	}

}
