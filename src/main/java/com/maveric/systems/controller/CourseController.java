package com.maveric.systems.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maveric.systems.model.Course;

@RestController
@RequestMapping("/api/v1/course")
public class CourseController {

	@PostMapping("/saveCourse")
	public ResponseEntity<?> saveCourse(@RequestBody Course course) {

		System.out.println("Rest called happen to store course details");
		return ResponseEntity.ok("Course  save successfully");
	}

	@GetMapping("/getCourse")
	public ResponseEntity<List<Course>> getCourse() {
		System.out.println("Get all course function called");

		List<Course> list = new ArrayList<>();
		list.add(new Course("Java Essentials", "Learn the fundamentals of Java programming."));
		list.add(new Course("Spring Boot Mastery", "Dive deep into building RESTful APIs with Spring Boot."));
		list.add(new Course("Concurrency in Java", "Explore multithreading, CompletableFuture, and ForkJoinPool."));
		list.add(new Course("Database Integration", "Master entity persistence and JPA strategies."));
		list.add(new Course("Performance Tuning", "Optimize backend code for scalability and speed."));
		return ResponseEntity.ok(list);
	}

}
