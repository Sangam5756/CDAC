package com.product.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Product {

	public Product(String name2, String desc, LocalDate mfd2, int qty, double price2, Category category2) {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "prod_id")
	private Long productId;
	@Column(unique = true, length = 50)
	private String name;

	@Column(name = "prod_desc", length = 300)
	private String productDesc;

	private LocalDate mfd;

	private Double price;

	private Integer quantity;
	@Enumerated(EnumType.STRING)
	private Category category;

	@Lob
	@Column(name = "product_img")
	private byte[] image;

}
