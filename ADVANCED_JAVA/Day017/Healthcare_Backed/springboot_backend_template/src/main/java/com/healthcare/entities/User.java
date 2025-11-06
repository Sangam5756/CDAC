package com.healthcare.entities;
//users table -column - id(PK) , first name , last name, email ,password , phone , dob:date , role:enum,image :blob

import java.time.LocalDate;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity // to declare the class as Entity - so that Hibernate can manage it's life cycle
		// - mandatory annotation
@Table(name = "users") // to specify table name
@AttributeOverride(name = "id", column = @Column(name = "user_id"))

@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true,   exclude = { "password", "image" })
public class User extends BaseEntity {

	@Column(name = "first_name", length = 30) // col name , varchar size
	private String firstName;
	@Column(name = "last_name", length = 40)
	private String lastName;
	@Column(length = 50, unique = true) // col : unique constraint
	private String email;
	// not null constraint , size=300 (for hashed password)
	@Column(length = 300, nullable = false)
	private String password;
	@Column(unique = true, length = 14)

	private String phone;
//	@Transient //skip from persistence -> no col generation
//	private String confirmPassword;
	private LocalDate dob;
	@Enumerated(EnumType.STRING) // col type - varchar | enum
	private UserRole role;
	@Lob // large object , Mysql col type - longblob
	private byte[] image;
	@Column(name = "reg_amount")
	private int regAmount;

	public User(String firstName, String lastName, String email, String password, String phone, LocalDate dob,
			int amount) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.dob = dob;		
		this.regAmount = amount;
	}

	public User(String firstName, String lastName, LocalDate dob) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
	}
}
