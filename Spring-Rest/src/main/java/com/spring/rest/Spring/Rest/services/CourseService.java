package com.spring.rest.Spring.Rest.services;

import java.util.List;

import com.spring.rest.Spring.Rest.entity.Course;
import org.springframework.web.bind.annotation.RequestBody;

public interface CourseService {
	
	public List<Course> getCourses();

	public Course getCourse(long courseId);

	public Course addCourse(@RequestBody Course course);

	public Course updateCourse(Course course);

	public void deleteCourse(long parseLong);
}
