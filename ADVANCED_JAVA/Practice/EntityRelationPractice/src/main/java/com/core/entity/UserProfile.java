package com.core.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "users_profiles")
@NoArgsConstructor
@ToString(callSuper = true)
public class UserProfile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String bio;
	private String address;

	@OneToOne(mappedBy = "profile")
	private User user;

	public UserProfile(String bio, String address) {
		this.bio = bio;
		this.address = address;
	}
}
