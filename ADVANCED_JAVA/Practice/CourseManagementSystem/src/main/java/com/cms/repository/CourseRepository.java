package com.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cms.entities.Course;

@Repository
public interface CourseRepository  extends JpaRepository<Course, Long>{

}
