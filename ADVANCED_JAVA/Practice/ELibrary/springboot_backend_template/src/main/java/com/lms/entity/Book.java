package com.lms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "books")
@ToString
@Getter
@Setter

public class Book extends BaseEntity {

	@Column(nullable = false)
	private String title;
	@Column(nullable = false)
	private String author;

	@Enumerated(EnumType.STRING)
	private Category category;

	@Column(nullable = false)
	private String publisher;

	@Column(nullable = false)
	@Positive
	private double price;

	@ManyToOne
	@JoinColumn(name="member_id")
	private Member issuedTo;

}
