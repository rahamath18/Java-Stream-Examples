package com.test.corejava8.streams;

import java.util.Arrays;

public class StreamWithIntegerArray {

	public static void main(String[] args) {

		Integer[] iArr = {1,2,3,4,5,6,7,8,9};
		System.out.println("Given Intager Array");
		System.out.println("-------------------");
		Arrays.stream(iArr).forEach(System.out::println);
		
		System.out.println("\nFilter even number and find the sum");
		System.out.println("-------------------------------------");
		int sum = Arrays.stream(iArr).filter(i -> i % 2 == 0)
			  .peek(System.out::println)
			  .mapToInt(i -> i.intValue())
			  .sum();
		System.out.println("sum = "+sum);
			  
	}
}