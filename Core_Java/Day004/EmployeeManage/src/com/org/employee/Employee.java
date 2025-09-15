package com.org.employee;

public class Employee {

	public int id;
	private String name;
	private Double salary;
	private int deptId;
	public static int idCounter;

	
	static {

		idCounter= 100;
	}

	public Employee(String name, Double salary, int deptId) {
		
		id = idCounter++;
		this.name = name;
		this.salary = salary;
		this.deptId = deptId;
		
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	@Override
	public String toString() {
		return id + ", name=" + name + ", salary=" + salary + ", deptId=" + deptId;
	}

}
