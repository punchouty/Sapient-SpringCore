package com.sapient.gmi.spring.example9.java.properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan({"com.sapient.gmi.spring.example9"})
@PropertySource("application.properties")
public class AppConfig {
	
	@Bean(name ="logService")
	public LogService getLoggerBean() {
		return new LogServiceConsoleImpl();
	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer getPropertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

}
