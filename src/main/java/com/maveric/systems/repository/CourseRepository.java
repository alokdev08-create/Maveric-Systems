package com.maveric.systems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maveric.systems.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
