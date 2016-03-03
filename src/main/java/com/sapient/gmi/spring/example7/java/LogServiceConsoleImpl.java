package com.sapient.gmi.spring.example7.java;

import org.springframework.stereotype.Service;

@Service
public class LogServiceConsoleImpl implements LogService {

	@Override
	public void log(String joke) {
		System.out.println(joke);
	}

}
