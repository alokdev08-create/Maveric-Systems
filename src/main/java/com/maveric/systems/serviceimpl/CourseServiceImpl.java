package com.maveric.systems.serviceimpl;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.maveric.systems.entity.Course;
import com.maveric.systems.repository.CourseRepository;
import com.maveric.systems.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	private static final Logger log = LoggerFactory.getLogger(CourseServiceImpl.class);

	@Autowired
	private CourseRepository courseRepository;

	@Override
	public ResponseEntity<?> saveCourse(List<Course> courseList) {
		log.info("Saving {} course(s)", courseList.size());
		List<Course> savedCourses = courseRepository.saveAll(courseList);
		return !savedCourses.isEmpty() ? ResponseEntity.ok("Courses saved successfully")
				: ResponseEntity.badRequest().body("Failed to save courses");
	}

	@Override
	public ResponseEntity<?> getCourseById(Long id) {
		log.debug("Retrieving course with ID {}", id);
		return courseRepository.findById(id).map(course -> ResponseEntity.ok(course))
				.orElse(ResponseEntity.notFound().build());
	}

	@Override
	public ResponseEntity<?> getAllCourses() {
		log.debug("Fetching all courses");
		List<Course> courses = courseRepository.findAll();
		return courses.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(courses);
	}

	@Override
	public ResponseEntity<?> getUpdateCourses(Course course) {
		log.info("Updating course ID: {}", course.getId());
		if (course.getId() == null) {
			log.warn("Course ID is null — cannot perform update");
			return ResponseEntity.badRequest().body("Course ID is required for update");
		}
		return courseRepository.findById(course.getId()).map(updated -> {
			updated.setTitle(course.getTitle());
			updated.setDescription(course.getDescription());
			Course saved = courseRepository.save(updated);
			log.info("Updated course ID {}", course.getId());
			return ResponseEntity.ok(saved);
		}).orElse(ResponseEntity.status(404).body(null));
	}

	@Override
	public ResponseEntity<?> deleteCourse(Long id) {
	    if (!courseRepository.existsById(id)) {
	        log.error("Course with ID {} does not exist", id);
	        return ResponseEntity.status(404).body("Course with ID " + id + " not found");
	    }

	    courseRepository.deleteById(id);
	    log.info("Successfully deleted course ID {}", id);
	    return ResponseEntity.ok("Course with ID " + id + " deleted successfully");
	}

}
