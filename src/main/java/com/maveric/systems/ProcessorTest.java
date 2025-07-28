package com.maveric.systems;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ProcessorTest {

	public static void main(String[] args) {

		String str = "Bupa is one of the leading insurance company in Saudi Arabia";
		
		Map<Character,Long> frequency=str.toLowerCase().chars().mapToObj(c->(char)c)
				                       .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting())); 		
		System.out.println(frequency);
		
	}

}
