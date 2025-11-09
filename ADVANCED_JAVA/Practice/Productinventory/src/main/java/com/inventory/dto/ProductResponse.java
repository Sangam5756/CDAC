package com.inventory.dto;

import com.inventory.entities.Category;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ProductResponse {

	private String name;

	private String description;

	private Double price;

	private Integer stockQuantity;

	private Category category;

}
