package com.maveric.systems.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.maveric.systems.entity.Course;

public interface CourseService {
	ResponseEntity<?> saveCourse(List<Course> course);

	ResponseEntity<?> getCourseById(Long id);

	ResponseEntity<?> getAllCourses();

	ResponseEntity<?> getUpdateCourses(Course course);

	ResponseEntity<?> deleteCourse(Long id);

}
