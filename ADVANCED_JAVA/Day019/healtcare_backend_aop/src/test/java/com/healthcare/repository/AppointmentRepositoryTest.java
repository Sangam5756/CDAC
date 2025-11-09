package com.healthcare.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.healthcare.dto.AppointmentDTO;
import com.healthcare.entities.Status;

@DataJpaTest //to declare  test case (class) fro DAO layer testing - Scans Repo + Entities
@AutoConfigureTestDatabase(replace = Replace.NONE)//continues to use main DB - mysql
//@Rollback(false)
class AppointmentRepositoryTest {
	//Field Level D.I
	@Autowired
	private AppointmentRepository appointmentRepository;

	@Test
	void testGetPatientUpcomingAppointmentsByUserId() {
		List<AppointmentDTO> list = appointmentRepository.getPatientUpcomingAppointmentsByUserId(3l, Status.SCHEDULED);
		assertEquals(3, list.size());
		assertEquals(1l, list.get(0).getAppointmentId());
		
	}

}
