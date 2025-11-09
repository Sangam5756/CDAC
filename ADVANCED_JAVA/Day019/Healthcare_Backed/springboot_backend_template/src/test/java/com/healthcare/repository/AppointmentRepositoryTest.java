package com.healthcare.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.healthcare.dto.AppointmentDTO;
import com.healthcare.entities.Status;
import com.healthcare.repositories.AppointmentRepository;
import com.healthcare.repositories.PatientRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class AppointmentRepositoryTest {

	@Autowired
	private AppointmentRepository appointmentRepository;
	
	
	@Test
	void testGetUpcomingAppointments() {
		List<AppointmentDTO> list = appointmentRepository.getUpcomingAppointments(1L, Status.SCHEDULED,
				LocalDateTime.now());
		assertEquals(2, list.size());
//		assertEquals(1, list.get(0).getAppointmentId());
	}
	

}
