package com.core.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name="doctors")
public class Doctor {
/*
 * id (auto-generated)

name — cannot be blank

email — cannot be blank, unique

specialization — Enum (CARDIO, ORTHO, DERMATO, GENERAL)

experienceYears — must be positive

patients — list of Patient (One-to-Many)

*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private SpecialSkill specialSkill;
	private Double experienceYears;
	
	@OneToMany(mappedBy = "doctor")
	private List<Patient> patient;
	
}
