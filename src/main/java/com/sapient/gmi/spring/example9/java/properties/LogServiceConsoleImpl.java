package com.sapient.gmi.spring.example9.java.properties;

//@Service
public class LogServiceConsoleImpl implements LogService {

	@Override
	public void log(String joke) {
		System.out.println(joke);
	}

}
