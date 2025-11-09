package com.inventory.dto;

import com.inventory.entities.Category;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequest {

	@NotBlank(message = "product name required")
	private String name;

	@NotBlank(message = "description required")
	private String description;

    @NotNull(message = "Product price is required")
    @Positive(message = "Product price must be positive")

	private Double price;

    @NotNull(message = "Product quantity is required")
    @Min(value = 1, message = "Stock quantity must be at least 1")
    private Integer stockQuantity;

    @NotNull(message = "Category is required")
    private Category category;

}
