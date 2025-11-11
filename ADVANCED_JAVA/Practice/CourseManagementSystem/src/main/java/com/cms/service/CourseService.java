package com.cms.service;

import java.util.List;

import com.cms.dto.CourseDTO;
import com.cms.dto.CourseUpdateRequest;
import com.cms.entities.Course;

public interface CourseService {

//	1.	Add new Course
	Course addCourse(CourseDTO dto);

//	3.	Update Course Details
	Course updateCourse(Long cId,CourseUpdateRequest dto);

//	4.	Fetch all courses by given Category
	List<Course> fetchAllCourseByCategory(String Category);

}
