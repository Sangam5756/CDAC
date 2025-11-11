package com.cms.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CourseUpdateRequest {
	private String name;
	@FutureOrPresent(message = "Start date must be today or in the future")
	private LocalDate startDate;

	@Future(message = "End date must be in the future")
	private LocalDate endDate;
	@Positive
	private Double fees;

}
