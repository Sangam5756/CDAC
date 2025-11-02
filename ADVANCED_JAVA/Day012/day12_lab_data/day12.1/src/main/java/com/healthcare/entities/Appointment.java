package com.healthcare.entities;

import java.time.LocalDateTime;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// Table columns - doctor id , patient id , appointment date time , status

@Entity
@Table(name = "appointments",uniqueConstraints 
=@UniqueConstraint(
		columnNames = {"appointment_date_time","doctor_id"} ) )

//PK col name - appointment_id
//@AttributeOverrides - tp override -id & creation_date
@AttributeOverride(name = "id", column = @Column(name = "appointment_id"))
//lombok annotations
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true,exclude = {"myDoctor","myPatient"})
public class Appointment extends BaseEntity {

	@Column(name = "appointment_date_time")
	private LocalDateTime appointmentDateTime;
	@Enumerated(EnumType.STRING)
	private Status status = Status.SCHEDULED;
	// Appointment *------>1 Doctor - many to one association between entities
	@ManyToOne
	// FK col name , not null
	@JoinColumn(name = "doctor_id", nullable = false)
	private Doctor myDoctor;
	// Appointment * ------> 1 Patient - many to one association between entities
	@ManyToOne
	// FK col name , not null
	@JoinColumn(name = "patient_id", nullable = false)
	private Patient myPatient;
}
