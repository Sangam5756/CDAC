package com.healthcare.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.healthcare.entities.DiagnosticTest;
import com.healthcare.repositories.PatientRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class PatientRepositoryTest {

	@Autowired
	private PatientRepository patientRepository;

	@Test
	void testGetAllTestPatients() {

		Set<DiagnosticTest> allTestForPatient = patientRepository.getAllTestForPatient(1L);
		assertEquals(1, allTestForPatient.size());

	}

}
