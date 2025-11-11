package com.cms.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.cms.custom_exception.ResourceNotFoundException;
import com.cms.dto.CourseDTO;
import com.cms.dto.CourseUpdateRequest;
import com.cms.entities.Course;
import com.cms.repository.CourseRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {

//	here we need the course dependent

	private final CourseRepository courseRepository;
	private final ModelMapper mapper;

	@Override
	public Course addCourse(CourseDTO dto) {

//		then map the course to entity
		Course course = mapper.map(dto, Course.class);
		
//		got the entity
//		add to repo
		
		
		
//		first check the validate the data
		return courseRepository.save(course);
	}

	@Override
	public Course updateCourse(Long cId,CourseUpdateRequest dto) {
		
		
//		get data map from user
//		find the course by id
		Course existingCourse = courseRepository.findById(cId).orElseThrow(()->new ResourceNotFoundException("resource not found"));
//		if found
		existingCourse.setName(dto.getName());
		existingCourse.setStartDate(dto.getStartDate());
		existingCourse.setEndDate(dto.getEndDate());
		existingCourse.setFees(dto.getFees());
		
		
		
		
		return courseRepository.save(existingCourse);
	}

	@Override
	public List<Course> fetchAllCourseByCategory(String Category) {
		// TODO Auto-generated method stub
		return null;
	}

}
