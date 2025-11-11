package com.cms.dto;

import java.time.LocalDate;

import com.cms.entities.Category;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CourseDTO {

	@NotBlank(message = "Course Name is Required")
	private String name;
	@NotNull(message = "course category is required")
	private Category category;
	@FutureOrPresent
	@NotNull(message = "Start date cannot be null")
	private LocalDate startDate;
	@NotNull(message = "End date cannot be null")
	@Future
	private LocalDate endDate;

//	@NotNull()
	private Double fees;
	private int passMarks;

}
