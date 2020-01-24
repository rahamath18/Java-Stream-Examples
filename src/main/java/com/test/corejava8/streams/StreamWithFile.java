package com.test.corejava8.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamWithFile {

	public static void main(String[] args) {
		
		String fileName = "/java/java-stream-file-test.txt";

		System.out.println("Given Output");
		System.out.println("---------------");
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

			stream.forEach(System.out::println);

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("\n\nFiltered Output");
		System.out.println("---------------");
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
			
			List<String> list = new ArrayList<>();
			list = stream
					.filter(line -> line.startsWith("I"))      //1. filter line 3
					.map(String::toUpperCase)				   //2. convert all content to upper case
					.collect(Collectors.toList());			   //3. convert it into a List
			
			list.forEach(System.out::println);

		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}