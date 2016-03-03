package com.sapient.gmi.spring.example7.java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.sapient.gmi.spring.example7.java"})
public class AppConfig {
	
	@Bean(name ="logService")
	public LogService getLoggerBean() {
		return new LogServiceConsoleImpl();
	}

}
