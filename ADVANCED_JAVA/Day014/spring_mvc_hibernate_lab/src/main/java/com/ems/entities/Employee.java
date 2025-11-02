package com.ems.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "emps")
@NoArgsConstructor
@Getter
@Setter
@ToString( callSuper = true)
public class Employee extends BaseEntity {

	@Column(length = 30,name="first_name")
	private String firstName;
	@Column(length = 30,name="last_name")
	private String lastName;
	@Column(length = 30, unique = true) // =>unique
	private String email;
	@Column(nullable = false) // =>NOT NULL
	private String password;	
	@Column(name="join_date")
	private LocalDate joinDate;	
	@Enumerated(EnumType.STRING) // col : varchar => enum constant name
	@Column(length = 30)
	private EmploymentType type;

	private double salary;
	

	public Employee(String firstName, String lastName, String email, String password, LocalDate joinDate, EmploymentType type,
			double salary) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.joinDate = joinDate;
		this.type = type;
		this.salary = salary;
	}

}
