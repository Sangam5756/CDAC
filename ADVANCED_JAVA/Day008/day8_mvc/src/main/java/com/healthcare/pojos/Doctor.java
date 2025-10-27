package com.healthcare.pojos;
/*
 * id | name              | speciality  | email                    | password  | dob
 */

import java.sql.Date;

public class Doctor {
	private int id;
	private String docName;
	private String speciality;
	private String email;
	private String password;
	private Date dob;
	//def ctor
	public Doctor() {
		// TODO Auto-generated constructor stub
	}
	//all args ctor , except pwd
	public Doctor(int id, String docName, String speciality, String email, Date dob) {
		super();
		this.id = id;
		this.docName = docName;
		this.speciality = speciality;
		this.email = email;
		this.dob = dob;
	}
	
	public Doctor(String docName, String speciality, String email, String password, Date dob) {
		super();
		this.docName = docName;
		this.speciality = speciality;
		this.email = email;
		this.password = password;
		this.dob = dob;
	}
	//getters n setters
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getDocName() {
		return docName;
	}
	public void setDocName(String docName) {
		this.docName = docName;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	@Override
	public String toString() {
		return "Doctor [id=" + id + ", docName=" + docName + ", speciality=" + speciality + ", email=" + email
				 + ", dob=" + dob + "]";
	}
	
}
