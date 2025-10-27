package com.healthcare.dto;
/*Data Transfer object - meant to transfer the data between the layers DAO-> Servlet
 * Later - it will be used to transfer the data REST client & REST server
 * Then it will be used to transfer the data between different MS
 */

import java.sql.Timestamp;

public class AppointmentDTO {
	private int appointmentId;
	private Timestamp appointmentTS;
	private String docName;

	public AppointmentDTO(int appointmentId, Timestamp appointmentTS, String docName) {
		super();
		this.appointmentId = appointmentId;
		this.appointmentTS = appointmentTS;
		this.docName = docName;
	}

	// getter / setter
	public int getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

	public Timestamp getAppointmentTS() {
		return appointmentTS;
	}

	public void setAppointmentTS(Timestamp appointmentTS) {
		this.appointmentTS = appointmentTS;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	@Override
	public String toString() {
		return "AppointmentDTO [appointmentId=" + appointmentId + ", appointmentTS=" + appointmentTS + ", docName="
				+ docName + "]";
	}

}
