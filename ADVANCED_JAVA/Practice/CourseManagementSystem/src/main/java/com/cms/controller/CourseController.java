package com.cms.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cms.dto.ApiResponse;
import com.cms.dto.CourseDTO;
import com.cms.dto.CourseUpdateRequest;
import com.cms.entities.Course;
import com.cms.service.CourseService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/course")
@AllArgsConstructor
public class CourseController {

	private CourseService courseService;

//	add course new course
	@PostMapping
	public ResponseEntity<?> addCourse(@RequestBody @Valid CourseDTO dto) {

//		pass this course
		Course course = courseService.addCourse(dto);

		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new ApiResponse(false, "course added successfully", course, null));

	}

	@PutMapping("/{courseId}")
	public ResponseEntity<?> updateCourse(@RequestBody @Valid CourseUpdateRequest courseUpdateRequest,
			@PathVariable Long courseId) {

		Course updatedCourse = courseService.updateCourse(courseId, courseUpdateRequest);
//		course is updated then return response to the user
		
		

		return ResponseEntity.ok(new ApiResponse(true, "CourseUpdated Successfull", updatedCourse, null));

	}

}
