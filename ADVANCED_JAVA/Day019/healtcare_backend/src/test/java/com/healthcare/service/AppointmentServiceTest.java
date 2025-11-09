package com.healthcare.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.healthcare.dto.AppointmentDTO;

@SpringBootTest
class AppointmentServiceTest {
	@Autowired
	private AppointmentService service;

	@Test
	void testListUpcomingPatientAppointments() {
		List<AppointmentDTO> list = service.listUpcomingPatientAppointments(1l);
		assertEquals("Rajiv", list.get(0).getFirstName());
	}

}
