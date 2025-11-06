package com.healthcare.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.healthcare.entities.DiagnosticTest;
import com.healthcare.entities.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
	@Query("select t from Patient p join p.diagonsticTests t p.id=:pid")
		Set<DiagnosticTest> getAllTestForPatient(@Param("pid") Long patientId);

}
