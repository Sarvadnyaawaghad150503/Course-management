package com.spring.rest.Spring.Rest.controller;


import com.spring.rest.Spring.Rest.entity.Course;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.spring.rest.Spring.Rest.services.CourseService;

import java.util.List;

@RestController
@RequestMapping("/courses")
@CrossOrigin(origins = "*")
public class MyController {

	@Autowired
	private CourseService courseService;


	@GetMapping
	public ResponseEntity <List<Course>> getCourses(){

//		return this.courseService.getCourses();

		try{
			return ResponseEntity.status(HttpStatus.OK).body(courseService.getCourses());
		}
		catch(Exception e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

	@GetMapping("/{courseId}")
	public ResponseEntity<?> getCourse(@PathVariable String courseId){
//		return this.courseService.getCourse(Long.parseLong(courseId));
		try{
			Course course = courseService.getCourse(Long.parseLong(courseId));
			return  ResponseEntity.ok(course);
		}catch (EntityNotFoundException e){
			return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}

	@PostMapping
		public ResponseEntity<?> addCourse(@RequestBody Course course){
//			return this.courseService.addCourse(course);
		try {
			Course createdCourse = courseService.addCourse(course);
			return ResponseEntity.status(HttpStatus.CREATED).body(createdCourse);
		}
		catch (Exception e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		}


	@PutMapping
	public ResponseEntity<?> updateCourse(@RequestBody Course course){
//			return this.courseService.addCourse(course);
		try {
			Course createdCourse = courseService.updateCourse(course);
			return ResponseEntity.status(HttpStatus.CREATED).body(createdCourse);
		}
		catch (Exception e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	//delete the course
	@DeleteMapping("/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse (@PathVariable String courseId) {
		try {
			this.courseService.deleteCourse (Long.parseLong(courseId));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus. INTERNAL_SERVER_ERROR);
		}
	}
}
