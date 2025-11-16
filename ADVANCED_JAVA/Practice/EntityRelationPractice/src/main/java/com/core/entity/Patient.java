package com.core.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="patients")
public class Patient {

	/*
	 * id (auto-generated)
	 * 
	 * name — cannot be blank
	 * 
	 * email — cannot be blank
	 * 
	 * problemDescription — cannot be blank
	 * 
	 * appointmentDate — future or today
	 * 
	 * doctor — Many-to-One (who the patient is assigned to)
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String email;
	private String description;
	private LocalDate appointmentDate;

	@ManyToOne
	@JoinColumn(name = "doctor_id")
	private Doctor doctor;

}
