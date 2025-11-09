package com.healthcare.dto;
/*
 * {
  "userDetails": {
    "firstName": "string",
    "lastName": "string",
    "email": "string",
    "password": "string",
    "phone": "string",
    "dob": "string",
    "regAmount": 0
  },
  "gender": "MALE",
  "bloodGroup": "A_POSITIVE",
  "familyHistory": "string"
}

 */
import com.healthcare.entities.BloodGroup;
import com.healthcare.entities.Gender;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class PatientRegDTO {
	private UserReqDTO userDetails;
	private Gender gender;
	private BloodGroup bloodGroup;
	private String familyHistory;
}
