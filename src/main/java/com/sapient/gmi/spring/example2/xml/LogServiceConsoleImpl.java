package com.sapient.gmi.spring.example2.xml;

public class LogServiceConsoleImpl implements LogService {

	@Override
	public void log(String joke) {
		System.out.println(joke);
	}

}
