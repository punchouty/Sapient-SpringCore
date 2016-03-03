package com.sapient.gmi.spring.example0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class JokeRepositoryImpl implements JokeRepository {
	
	private String apiUrl = "http://api.icndb.com/joke/random";
	private LogService logService = new LogServiceConsoleImpl();

	@Override
	public void fetchJoke() throws IOException {
		URL url = new URL(apiUrl);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");

		if (conn.getResponseCode() != 200) {
			System.err.println("Rajan : "+ conn.getResponseCode());
			throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
		}
		else {
			System.out.println("Rajan : 200 "+ conn.getResponseCode());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

		String output;
		StringBuffer buffer = new StringBuffer();
		while ((output = br.readLine()) != null) {
			buffer.append(output);
		}
		logService.log(buffer.toString());
		conn.disconnect();
	}

}
