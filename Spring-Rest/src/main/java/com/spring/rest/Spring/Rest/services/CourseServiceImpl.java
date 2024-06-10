package com.spring.rest.Spring.Rest.services;

import java.util.*;

import com.spring.rest.Spring.Rest.Repository.CourseDao;
import com.spring.rest.Spring.Rest.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService{

	
//	List<Course> list;
	@Autowired
	private CourseDao courseDao;
	
	public CourseServiceImpl() {
//		list = new ArrayList<>();
//		list.add(new Course(145, "JAVA", "basic"));
//		list.add(new Course(146, "REST", "basic"))	;
	}
	
	@Override
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
//		return list;
		return courseDao.findAll();
	}

	@Override
	public Course getCourse(long courseId) {

		Course c=null;

//		for(Course course:list){
//			if(course.getId() == courseId){
//				c =course;
//				break;
//			}
//		}
//		return c;

		return courseDao.getOne(courseId);
	}


	@Override
	public Course addCourse(Course course) {
//		 list.add(course);
		courseDao.save(course);
		return course;
	}

	@Override
	public Course updateCourse (Course course) {
//		list.forEach(e -> {
//			if (e.getId() == course.getId()) {
//				e.setTitle(course.getTitle());
//				e.setDescription(course.getDescription());
//			}
//			});

		courseDao.save(course);
			return course;
		}


		@Override
		public void deleteCourse(long parseLong) {
//			list=this.list.stream().filter(e->e.getId() !=parseLong).collect(Collectors.toList());
		 Course entity = courseDao.getOne(parseLong);
		 courseDao.delete(entity);
	}
}
