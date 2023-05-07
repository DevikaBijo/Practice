package com.example.SamplePratice.repository;

import com.example.SamplePratice.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course, Integer> {
}
