package com.cms.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass
@Getter
@Setter
@ToString
public class BaseEntity {

	@Id
	private Long id;

	@CreationTimestamp // to specify creation date | time | TS
	@Column(name = "created_on")
	private LocalDate createdOn;
	@UpdateTimestamp // to specify updation date | time | TS
	@Column(name = "last_updated")
	private LocalDateTime lastUpdated;

}
