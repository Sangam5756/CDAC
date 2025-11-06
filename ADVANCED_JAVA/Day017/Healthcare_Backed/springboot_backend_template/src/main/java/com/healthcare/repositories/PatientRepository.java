package com.healthcare.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.healthcare.entities.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

}
