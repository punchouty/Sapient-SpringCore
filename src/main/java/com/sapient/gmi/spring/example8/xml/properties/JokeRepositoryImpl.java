package com.sapient.gmi.spring.example8.xml.properties;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class JokeRepositoryImpl implements JokeRepository {
	
	private String apiUrl = "http://api.icndb.com/jokes/random";
	private LogService logService;

	@Override
	public void fetchJoke() throws IOException {
		URL url = new URL(apiUrl);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");

		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
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

	public void setLogService(LogService logService) {
		this.logService = logService;
	}

}
