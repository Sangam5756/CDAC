package com.lms.dto;

import com.lms.entity.Category;

import lombok.Data;

@Data
public class BookResponseDTO {
	private Long id;
	private String title;
	
	private String author;

	private Category category;

	private String publisher;

	private double price;
//	private MemberResponseDTO issuedTo; 
}
