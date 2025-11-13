package com.lms.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="members")
@ToString
@Getter
@Setter
public class Member extends BaseEntity {

	@Column(nullable = false)
	private String name;
	@Column(unique = true, nullable = false)
	private String email;

	@Column(nullable = false)
	private String password;

	
	public Member() {
		this.mebershipType = MemberShipType.REGULAR;
	}

	@Column(name = "membership_type")
	@Enumerated(EnumType.STRING)
	private MemberShipType mebershipType;
	
	@OneToMany(mappedBy = "issuedTo")
	 private List<Book> books;
	
}
