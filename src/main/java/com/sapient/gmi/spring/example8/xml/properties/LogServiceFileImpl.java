package com.sapient.gmi.spring.example8.xml.properties;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class LogServiceFileImpl implements LogService {
	
	private String fileString = "joke.txt";
	private RandomAccessFile file = null;
	
	public LogServiceFileImpl() {
		try {
			File jokeFile = new File(fileString);
			if(jokeFile.exists()) {
				jokeFile.delete();
			}
			this.file = new RandomAccessFile(fileString, "rw");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void log(String joke) {
		try {
			System.out.println("Writing joke in file : " + joke);
			file.writeUTF(joke + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
