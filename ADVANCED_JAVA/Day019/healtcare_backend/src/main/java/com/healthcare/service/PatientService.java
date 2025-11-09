package com.healthcare.service;

import com.healthcare.dto.ApiResponse;
import com.healthcare.dto.PatientRegDTO;

public interface PatientService {
//method to sign up
	ApiResponse registerNewPatient(PatientRegDTO reqDTO);
}
