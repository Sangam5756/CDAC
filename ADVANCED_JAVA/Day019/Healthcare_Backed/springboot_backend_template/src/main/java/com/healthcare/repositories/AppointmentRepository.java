package com.healthcare.repositories;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.healthcare.dto.AppointmentDTO;
import com.healthcare.entities.Appointment;
import com.healthcare.entities.Doctor;
import com.healthcare.entities.Status;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

	/*
	 * 
	 * private Long appointmentId; private LocalDateTime appointmentTS; private
	 * String firstName; private String lastName;
	 * 
	 */
//	@Query("select new com.healthcare.dto.AppointmentDto(a.id,a.appointmentId,a.appointmentTS,a.myPatient.userDetails.firstName,a.myPatient.userDetails.lastName)where a.mypatient.id=:patientId and a.Status=:status and a.appointmentTs >:currTime")
	@Query("""
			select new com.healthcare.dto.AppointmentDTO(a.id,a.appointmentDateTime,a.myDoctor.userDetails.firstName,a.myDoctor.userDetails.lastName) from Appointment a where a.myPatient.id=:patientId and a.status=:status order by a.appointmentDateTime asc
			""")
	List<AppointmentDTO> getUpcomingAppointments(Long patientId, Status status,LocalDateTime time);
	Optional<Appointment> findByMyDoctorAndAppointmentDateTime(Doctor DocId,LocalDateTime ts);

}
