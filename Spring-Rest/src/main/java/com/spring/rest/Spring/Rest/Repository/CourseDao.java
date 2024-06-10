package com.spring.rest.Spring.Rest.Repository;

import com.spring.rest.Spring.Rest.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseDao extends JpaRepository<Course, Long> {
}
