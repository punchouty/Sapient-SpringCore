package com.sapient.gmi.spring.example0;

public class LogServiceConsoleImpl implements LogService {

	@Override
	public void log(String joke) {
		System.out.println(joke);
	}

}
