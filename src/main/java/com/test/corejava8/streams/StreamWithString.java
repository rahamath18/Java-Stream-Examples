package com.test.corejava8.streams;

public class StreamWithString {

	public static void main(String[] args) {

		String password = "pass1234#@";

		System.out.println("Given String");
		System.out.println("------------");
		System.out.println(password);

		System.out.println("\nPrint char by char");
		System.out.println("------------------");

		password.chars() // IntStream
				.mapToObj(x -> (char) x) // Stream<Character>
				.forEach(System.out::println);

		System.out.println("\nPrint Unicode of each char");
		System.out.println("----------------------------");
		password.chars() // IntStream
				.mapToObj(x -> (int) x)// Stream<Character>
				.forEach(System.out::println);

	}

}
