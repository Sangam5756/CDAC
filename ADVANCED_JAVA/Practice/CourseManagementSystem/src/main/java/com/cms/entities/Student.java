package com.cms.entities;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*
 * 
Student has the following attributes: 
1.	Student id (unique identifier for each Student , auto generated, starts from 1) - primary key
2.	student name (Cannot be Blank)
3.	Email (Cannot be Blank)
4.	Password (Cannot be Blank)
5.     Marks
6.	Course id - Foreign key*/
@Entity
@Table(name = "students")
@AttributeOverride(name = "id", column = @Column(name = "st_id"))
@Getter
@Setter
@ToString(callSuper = true, exclude = "password")
public class Student extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	
	@Column(name = "st_name")
	private String name;
	@Column(unique = true, nullable = false)
	@Email(message = "email is required")
	private String email;

	private String password;
	@Enumerated(EnumType.STRING)
	private Marks marks;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "course_id")
	private Course course;

}
