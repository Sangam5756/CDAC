package com.product.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product {

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

	public Product() {
		super();
	}

	public Product(String name, String productDesc, LocalDate mfd, Integer quantity, Double price,
			Category category) {
		super();
		this.productId = productId;
		this.name = name;
		this.productDesc = productDesc;
		this.mfd = mfd;
		this.price = price;
		this.quantity = quantity;
		this.category = category;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public LocalDate getMfd() {
		return mfd;
	}

	public void setMfd(LocalDate mfd) {
		this.mfd = mfd;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", productDesc=" + productDesc + ", mfd=" + mfd
				+ ", price=" + price + ", quantity=" + quantity + ", category=" + category + "]";
	}

}
