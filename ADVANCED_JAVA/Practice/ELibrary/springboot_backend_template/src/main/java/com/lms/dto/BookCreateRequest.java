package com.lms.dto;

import com.lms.entity.Category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class BookCreateRequest {

	@NotBlank(message = "book title required")
	private String title;
	
	@NotBlank(message = "Author name is required")
	private String author;

	@NotNull(message = "cateogry is required")
	private Category category;

	@NotBlank(message = "publisher name is required")
	private String publisher;

	@NotNull(message = "book price is required")
	@Positive
	private double price;

}
