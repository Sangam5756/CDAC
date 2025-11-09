package com.healthcare.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.healthcare.entities.DiagnosticTest;
import com.healthcare.entities.Patient;

public interface PatientRepository extends JpaRepository<Patient,Long> {
//Find all diagnostic tests prescribed to a patient id
@Query("select t from Patient p join p.diagnosticTests t where p.id=:pid")
Set<DiagnosticTest> getAllTestsForPatient(@Param("pid") Long patientId);

}
