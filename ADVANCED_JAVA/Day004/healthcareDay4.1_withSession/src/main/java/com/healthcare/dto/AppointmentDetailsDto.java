package com.healthcare.pojos;

import java.sql.Timestamp;

public class AppointmentDetails {

	private int appointment_id;
	private String DocName;
	private Timestamp appointMentDateTime;

	public AppointmentDetails(int appointment_id, Timestamp appointMentDateTime, String docName) {

		this.appointment_id = appointment_id;
		DocName = docName;
		this.appointMentDateTime = appointMentDateTime;
	}



	@Override
	public String toString() {
		return "AppointmentDetails [appointment_id=" + appointment_id + ", DocName=" + DocName
				+ ", appointMentDateTime=" + appointMentDateTime + "]";
	}



	public int getAppointment_id() {
		return appointment_id;
	}

	public void setAppointment_id(int appointment_id) {
		this.appointment_id = appointment_id;
	}

	public String getDocName() {
		return DocName;
	}

	public void setDocName(String docName) {
		DocName = docName;
	}

	public Timestamp getAppointMentDateTime() {
		return appointMentDateTime;
	}

	public void setAppointMentDateTime(Timestamp appointMentDateTime) {
		this.appointMentDateTime = appointMentDateTime;
	}

}
