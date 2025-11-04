package com.ems.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@ToString( callSuper = true,exclude = {"password","myDepartment"})
public class Employee extends BaseEntity {

	@Column(length = 30)
	private String firstName;
	@Column(length = 30)
	private String lastName;
	@Column(length = 30, unique = true) // =>unique
	private String email;
	@Column(nullable = false) // =>NOT NULL
	private String password;	
	private LocalDate joinDate;	
	@Enumerated(EnumType.STRING) // col : varchar => enum constant name
	@Column(length = 30)
	private EmploymentType type;
	private double salary;
	//Employee  *------>1 Department
	@ManyToOne
	@JoinColumn(name="dept_id",nullable = false)
	//Gavin King - exclude asso based props
	private Department myDepartment;
	

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
