package com.maveric.systems.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.maveric.systems.entity.Course;
import com.maveric.systems.service.CourseService;

@RestController
@RequestMapping("/api/v1/course")
public class CourseController {

	private static final Logger log = LoggerFactory.getLogger(CourseController.class);

	@Autowired
	private CourseService courseService;

	@PostMapping("/saveCourse")
	public ResponseEntity<?> saveCourse(@RequestBody List<Course> courses) {
		log.info("Saving course details...");
		return courseService.saveCourse(courses);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getCourseById(@PathVariable Long id) {
		log.info("Fetching course by ID: {}", id);
		return courseService.getCourseById(id);
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAllCourses() {
		log.info("Fetching all courses...");
		return courseService.getAllCourses();
	}

	@PutMapping("/update")
	public ResponseEntity<?> updateCourses(@RequestBody Course course) {
		log.info("Updating course: {}", course.getId());
		return courseService.getUpdateCourses(course);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCourse(@PathVariable Long id) {
		log.info("Deleting course ID: {}", id);
		return courseService.deleteCourse(id);
	}

}
