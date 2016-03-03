package com.sapient.gmi.spring.example1.xml;

import java.io.IOException;

public class JokerThread extends Thread {
	
	private int numberOfJokes = 5;
	private JokeRepository jokeRepository = new JokeRepositoryImpl();
	
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

}
