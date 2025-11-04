package com.ems.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "departments")
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class Department extends BaseEntity {
	@Column(name = "dept_name", length = 40, unique = true)
	private String deptName;
	@Column(length = 30)
	private String location;	
	

	public Department(String deptName, String location) {
		super();
		this.deptName = deptName;
		this.location = location;
	}

}
