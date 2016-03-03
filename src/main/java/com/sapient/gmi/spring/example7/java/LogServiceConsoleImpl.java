package com.sapient.gmi.spring.example7.java;

//@Service
public class LogServiceConsoleImpl implements LogService {

	@Override
	public void log(String joke) {
		System.out.println(joke);
	}

}
