package com.cms.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="courses")
@Getter
@Setter
@NoArgsConstructor
@AttributeOverride(name="id", column=@Column(name="c_id"))
public class Course {
	/*
	 * 1. ID (unique identifier for each Course, auto generated, starts from 1) 
	 * 2.Name (unique , Cannot be Blank, Example : Java SE,Web Programming in Java
	 * ,Spring Boot , Spring Cloud, Oracle DB , MySql DB ) 
	 * 3. Category (Enum,Example: JAVA,DBT) 
	 * 4. Start Date (Cannot be Blank) 
	 * 5. End Date (Cannot be Blank) 
	 * 6. Fees (Cannot be Blank) 
	 * 7. Marks to Pass (Cannot be Blank)
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private String name;
	
	@Enumerated(EnumType.STRING)
	private Category category;
	@Column(name="start_date")
	private LocalDate startDate;
	@Column(name="end_date")
	private LocalDate endDate;
	private Double fees;
	@Column(name="pass_marks")
	private int passMarks;
	
	@OneToMany(mappedBy = "course")
	List<Student> students =  new ArrayList<>();
	
	
	

}
