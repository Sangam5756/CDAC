package com.healthcare.pojos;

import java.sql.Timestamp;

public class Appointment {
	/*
	 * id | int | NO | PRI | NULL | auto_increment | | doctor_id | int | NO | MUL |
	 * NULL | | | patient_id | int | NO | MUL | NULL | | | appointment_datetime |
	 * timestamp | NO | | NULL | | | status
	 */

	private int id;
	private int doctor_id;
	private int patient_id;
	private Timestamp appointMentDateTime;
	private Status status;

	public Appointment(int id, int doctor_id, int patient_id, Timestamp appointMentDateTime, Status status) {

		this.id = id;
		this.doctor_id = doctor_id;
		this.patient_id = patient_id;
		this.appointMentDateTime = appointMentDateTime;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDoctor_id() {
		return doctor_id;
	}

	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}

	public int getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}

	public Timestamp getAppointMentDateTime() {
		return appointMentDateTime;
	}

	public void setAppointMentDateTime(Timestamp appointMentDateTime) {
		this.appointMentDateTime = appointMentDateTime;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
