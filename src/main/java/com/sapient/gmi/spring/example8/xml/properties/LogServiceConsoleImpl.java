package com.sapient.gmi.spring.example8.xml.properties;

public class LogServiceConsoleImpl implements LogService {

	@Override
	public void log(String joke) {
		System.out.println(joke);
	}

}
