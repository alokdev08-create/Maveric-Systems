package com.maveric.systems;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test {
	public static void main(String[] args) {
		String s = "swiss";
		Character nonRepeated = s.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.filter(entry -> entry.getValue() == 1L).map(entry -> entry.getKey()).findFirst().get();
		
		System.out.println(nonRepeated);
		
		List<Integer> intValue = Arrays.asList(2, 3, 4, 5);
		Optional<Integer> intData = intValue.stream().filter(e -> e % 2 == 0).skip(0).findFirst();
		System.out.println(intData.get());
		
		System.getProperty("propertyName");

		
		System.getProperty("os.name");         // e.g., "Windows 10"
		System.getProperty("user.home");       // e.g., "C:\\Users\\YourName"
		System.getProperty("java.version");    // e.g., "17.0.1"
		
		Properties props = System.getProperties();
		props.list(System.out);
	}
}
