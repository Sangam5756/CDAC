package com.healthcare.pojos;
// id | doctor_id | patient_id | appointment_datetime | status

import java.sql.Timestamp;

public class Appointment {
	private int id;
	private int doctorId;
	private int pateintId;
	private Timestamp appointmentDateTime;
	private String status = "SCHEDULED";
	//def ctor 
	public Appointment() {
		// TODO Auto-generated constructor stub
	}
	//getters n setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public int getPateintId() {
		return pateintId;
	}
	public void setPateintId(int pateintId) {
		this.pateintId = pateintId;
	}
	public Timestamp getAppointmentDateTime() {
		return appointmentDateTime;
	}
	public void setAppointmentDateTime(Timestamp appointmentDateTime) {
		this.appointmentDateTime = appointmentDateTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Appointment [id=" + id + ", doctorId=" + doctorId + ", pateintId=" + pateintId
				+ ", appointmentDateTime=" + appointmentDateTime + ", status=" + status + "]";
	}
	
}
