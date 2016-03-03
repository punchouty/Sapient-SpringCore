package com.sapient.gmi.spring.example4.xml.lifecycle;

public class LogServiceConsoleImpl implements LogService {

	@Override
	public void log(String joke) {
		System.out.println(joke);
	}

}
