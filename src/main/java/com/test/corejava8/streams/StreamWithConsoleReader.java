package com.test.corejava8.streams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StreamWithConsoleReader {

	public static void main(String[] args) {
		
		List<String> allReadLines = new ArrayList<String>();

		System.out.print("Enter your stream input: ");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s;
		try {
			while ((s = in.readLine()) != null && s.length() != 0) {
			    allReadLines.add(s);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		allReadLines.stream().forEach(System.out::println);
	}

}
