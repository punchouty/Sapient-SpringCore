package com.sapient.gmi.spring.example5.xml.lifecycle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.sapient.gmi.spring.example4.xml.lifecycle.LogService;

public class LogServiceFileImpl implements LogService, BeanNameAware, BeanFactoryAware, ApplicationContextAware,
		BeanPostProcessor, DisposableBean {

	private String fileString = "joke.txt";
	private RandomAccessFile file = null;

	public LogServiceFileImpl() {
		try {
			this.file = new RandomAccessFile(fileString, "rw");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void log(String joke) {
		try {
			System.out.println("Writing joke in file : " + joke);
			file.writeUTF(joke + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void init() {
		System.out.println("Inside Init Method");
		File jokeFile = new File(fileString);
		if (jokeFile.exists()) {
			jokeFile.delete();
		}
	}

	public void close() {
		System.out.println("Inside Destroy Method");
		try {
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setBeanName(String setBeanName) {
		System.out.println("BeanNameAware : Inside setBeanName(), arg0 - " + setBeanName);

	}

	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		System.out.println("ApplicationContextAware : Inside setApplicationContext()");

	}

	@Override
	public void setBeanFactory(BeanFactory arg0) throws BeansException {
		System.out.println("BeanFactoryAware : Inside setBeanFactory()");

	}

	@Override
	public Object postProcessAfterInitialization(Object arg0, String arg1) throws BeansException {
		System.out.println(
				"BeanPostProcessor : Inside postProcessAfterInitialization(), : arg0 - " + arg0 + " , arg1 - " + arg1);
		return arg0;
	}

	@Override
	public Object postProcessBeforeInitialization(Object arg0, String arg1) throws BeansException {
		System.out.println(
				"BeanPostProcessor : Inside postProcessBeforeInitialization(), : arg0 - " + arg0 + " , arg1 - " + arg1);
		return arg0;
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("DisposableBean : Inside destroy()");
	}

}
