package com.healthcare.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.healthcare.custom_exceptions.ResourceAlreadyExists;
import com.healthcare.dto.ApiResponse;
import com.healthcare.dto.PatientRegDTO;
import com.healthcare.entities.Patient;
import com.healthcare.entities.UserRole;
import com.healthcare.repository.PatientRepository;
import com.healthcare.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class PatientServiceImpl implements PatientService {
	private final PatientRepository patientRepository;
	private final UserRepository userRepository;
	private final ModelMapper mapper;

	@Override
	public ApiResponse registerNewPatient(PatientRegDTO reqDTO) {
		// 1. validate for dup email
		if(userRepository.existsByEmail(reqDTO.getUserDetails().getEmail()))
			throw new ResourceAlreadyExists("Email alread Exists !!!!!");
		// 2. in case of no dup -> dto -> entity (deep copy)
		Patient entity = mapper.map(reqDTO, Patient.class);
		//2.5 assign patient role
		entity.getUserDetails().setRole(UserRole.ROLE_PATIENT);
		//3. save patient entity (highlight - JPA cascade)
		Patient persistentEntity=patientRepository.save(entity);//users : insert -> PK -> child rec -> patients : FK		
		//4. ret api resp dto
		return new ApiResponse("New Patient registered with ID="+persistentEntity.getId(), "Success");
	}

}
