package com.healthcare.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.dto.ApiResponse;
import com.healthcare.dto.BookAppointment;
import com.healthcare.dto.PatientRegDTO;
import com.healthcare.service.AppointmentService;
import com.healthcare.service.PatientService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/patients")
@AllArgsConstructor
public class PatientController {
	//depcy
	private final AppointmentService appointmentService;
	private PatientService patientService;
	/*
	 * Desc - List patient's upcoming appointments
End Point design
URL - http://host:port/patients/{patientId}/appointments/upcoming
Method- GET
resource id - path var.
Resp - List<AppointmentDTO>
Main highlight - custom query - JPQL 
i/p - user id.
	 */
	@GetMapping("/{patientId}/appointments/upcoming")	
	public  ResponseEntity<?> listUpcomingAppointments(@PathVariable Long patientId )
	{
		System.out.println("in patient list appointments "+patientId);
		//invoker service layer method
		try {
			return ResponseEntity.ok(appointmentService.listUpcomingPatientAppointments(patientId));
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND) //SC 404
					.body(new ApiResponse(e.getMessage(), "failed"));
		}
	}
	/*
	 * URL - http://host:port/patients/{pid}/appointments
Request Payload -   
{
 
  "doctorId": 5,
  "appointmentDateTime": "2025-11-05T10:30:00",
 }

Controller  - PatientController
Method - POST
Response - AppointmentResp DTO

Resp SC 201
{
  "appointmentId": 101,
  "doctorName": "Dr. Priya Sharma",
  "appointmentDateTime": "2025-11-05T10:30:00",
  "status": "SCHEDULED",
  "message": "Appointment booked successfully"
}

Error Resp SC 400 | 404 | 409
Api Response - with error message.

	 */
	@PostMapping("/{pid}/appointments")
	public ResponseEntity<?> bookAppointment(@PathVariable Long pid,@RequestBody BookAppointment dto)
	{
		System.out.println("in book appointment "+pid +" "+dto);
		try {
			//invoke service layer method
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(appointmentService.bookAppointment(pid,dto));
		} catch (RuntimeException e) {
			System.out.println("err "+e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ApiResponse(e.getMessage(), "Failed"));
		}
	}
	/*
	 * Desc - Patient Registration
	 * URL - http://host:port/patients/signup
	 * Method - POST
	 * Payload - req dto 
	 * Success resp - api resp + SC 201
	 * Failed -  api resp +  SC 400
	 */
	@PostMapping("/signup")
	public ResponseEntity<?> registerPatient(@RequestBody PatientRegDTO dto) {
		System.out.println("in patient reg "+dto);
		try {
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(patientService.registerNewPatient(dto));
		} catch (RuntimeException e) {
			System.out.println("err "+e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ApiResponse(e.getMessage(), "Failed"));
		}
	}
	

}
