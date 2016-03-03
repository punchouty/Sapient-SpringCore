package com.sapient.gmi.spring.example6.autowire;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("jokerThread")
public class JokerThread extends Thread {
	
	private int numberOfJokes = 3;
	private JokeRepository jokeRepository;

	public JokerThread() {
		
	}
	
	public void run() {
		for (int i = 0; i < numberOfJokes; i++) {
			try {
				jokeRepository.fetchJoke();
				Thread.sleep(1000);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Autowired
	public void setJokeRepository(JokeRepository jokeRepository) {
		this.jokeRepository = jokeRepository;
	}

}
