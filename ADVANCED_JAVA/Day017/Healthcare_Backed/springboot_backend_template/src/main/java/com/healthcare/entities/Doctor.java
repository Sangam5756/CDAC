package com.healthcare.entities;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * speciality ,experienceInYears , qualifications , fees
 */
@Entity
@Table(name = "doctors")
/*
 * To specify id column name as - doctor_id
 */
@AttributeOverride(name = "id", column = @Column(name = "doctor_id"))
@NoArgsConstructor
@Getter
@Setter

/*
 * Project Tip - Exclude association fields from to string (to avoid recursion)
 * - Gavin King
 */
@ToString(callSuper = true, exclude = "userDetails")
public class Doctor extends BaseEntity {
	@Column(length = 100)
	private String speciality;
	@Column(name = "experience_in_years")
	private int experienceInYears;
	private String qualifications;
	private int fees;
	// Doctor 1----->1 User(user details)
	@OneToOne(cascade = CascadeType.ALL) // mandatory - o.w Hibernate throws - MappingException
	/*
	 * To specify FK column name & to add not null constraint
	 */
	@JoinColumn(name = "user_id", nullable = false)
	private User userDetails;
	public Doctor(String speciality, int experienceInYears, String qualifications, int fees) {
		super();
		this.speciality = speciality;
		this.experienceInYears = experienceInYears;
		this.qualifications = qualifications;
		this.fees = fees;
	}
	

}
