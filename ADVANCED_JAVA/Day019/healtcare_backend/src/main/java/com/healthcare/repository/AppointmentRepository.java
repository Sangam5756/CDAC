package com.healthcare.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.healthcare.dto.AppointmentDTO;
import com.healthcare.entities.Appointment;
import com.healthcare.entities.Status;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
	// custom query - to get list of upcoming appointments by patient id
	@Query("""
			select new com.healthcare.dto.AppointmentDTO(a.id,a.appointmentDateTime,a.myDoctor.userDetails.firstName,a.myDoctor.userDetails.lastName) from Appointment a where a.myPatient.id=:pid and a.status=:sts order by a.appointmentDateTime asc
			""")
	List<AppointmentDTO> getPatientUpcomingAppointmentsByPatientId(@Param("pid") Long patientId,
			@Param("sts") Status status);

	// custom query - to get list of upcoming appointments by user id (more
	// realistic)
	@Query("""
			select new com.healthcare.dto.AppointmentDTO(a.id,a.appointmentDateTime,a.myDoctor.userDetails.firstName,a.myDoctor.userDetails.lastName) from Appointment a where a.myPatient.userDetails.id=:uid and a.status=:sts order by a.appointmentDateTime asc
			""")
	List<AppointmentDTO> getPatientUpcomingAppointmentsByUserId(@Param("uid") Long userId, @Param("sts") Status status);
	
	// custom query - to get list of truly upcoming appointments by user id (more
		// realistic)
		@Query("""
				select new com.healthcare.dto.AppointmentDTO(a.id,a.appointmentDateTime,a.myDoctor.userDetails.firstName,a.myDoctor.userDetails.lastName) from Appointment a where a.myPatient.userDetails.id=:uid and a.status=:sts and a.appointmentDateTime > :ts order by a.appointmentDateTime asc
				""")
		List<AppointmentDTO> getPatientUpcomingAppointmentsByUserId2(@Param("uid") Long userId, @Param("sts") Status status,@Param("ts") LocalDateTime ts);
		//add derived query - to chk doc's availabilty
		boolean existsByMyDoctorIdAndAppointmentDateTime(Long docId,LocalDateTime appTime);
}
