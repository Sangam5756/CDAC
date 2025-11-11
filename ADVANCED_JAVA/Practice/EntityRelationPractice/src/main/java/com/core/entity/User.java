package com.core.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "users")
@NoArgsConstructor
@ToString(callSuper = false)
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String username;
	private String email;

//	   one user one profile
	@OneToOne(cascade = CascadeType.ALL)
	private UserProfile profile;

	public User(String username, String email, UserProfile profile) {
		this.username = username;
		this.email = email;
		this.profile = profile;
	}
}
