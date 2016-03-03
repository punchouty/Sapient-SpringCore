package com.sapient.gmi.spring.example4.xml.lifecycle;

import java.io.IOException;

public class JokerThread extends Thread {
	
	private int numberOfJokes;
	private JokeRepository jokeRepository;

	public JokerThread(int numberOfJokes) {
		this.numberOfJokes = numberOfJokes;
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

	public void setJokeRepository(JokeRepository jokeRepository) {
		this.jokeRepository = jokeRepository;
	}

}
