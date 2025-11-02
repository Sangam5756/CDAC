package com.healthcare.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


//gender , blood group , family history
@Entity
@Table(name = "patients")
@AttributeOverride(name="id", column = @Column(name="patient_id"))
//lombok annotations
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true,exclude = {"userDetails","diagnosticTests"})
public class Patient  extends BaseEntity{
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	@Enumerated(EnumType.STRING)
	@Column(name = "blood_group")
	private BloodGroup bloodGroup;
	@Column(name = "family_history", length = 500)
	private String familyHistory;
	//user
	@OneToOne(cascade = CascadeType.ALL) //mandatory
	@JoinColumn(name="user_id",nullable = false)
	private User userDetails;
	/*
	 * Project Tip (Gavin King)
	 * 1. In configuring many-many association , use Set , instead of List
	 *  - to avoid extra ,  un necessary db queries
	 *  2. In case of ANY Collection(List | Set) 
	 *  - init it always to an empty Collection(to avoid NullPointerExc)
	 */
	//Patient *----->* DiagTest - many to -many , uni dir association
	@ManyToMany /* (fetch = FetchType.EAGER) */ //mandatory - avoids MappingExc.
	@JoinTable(name="patient_tests",joinColumns = @JoinColumn(name="patient_id"),inverseJoinColumns = @JoinColumn(name="test_id")) //optional 
	private Set<DiagnosticTest> diagnosticTests=new HashSet<>();
	public Patient(Gender gender, BloodGroup bloodGroup, String familyHistory) {
		super();
		this.gender = gender;
		this.bloodGroup = bloodGroup;
		this.familyHistory = familyHistory;		
	}
	
	
}
