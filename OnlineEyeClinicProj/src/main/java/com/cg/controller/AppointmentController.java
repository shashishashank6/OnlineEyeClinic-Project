package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.model.Appointment;
import com.cg.model.Patient;
import com.cg.service.IAppointmentService;

@RestController
@RequestMapping("appointment/api/v1")
public class AppointmentController {
	@Autowired
	private IAppointmentService as;
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/appointments")
	public ResponseEntity<List<Appointment>> getAllAppointment(){
		List<Appointment> appointment= as.viewAllAppointments();
		if(appointment.isEmpty()) {
			return new ResponseEntity("Sorry! Patients not found!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Appointment>>(appointment, HttpStatus.OK);
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping("/appointments")
	public ResponseEntity<List<Appointment>> InsertPatient(@RequestBody Appointment appoint){
		List<Appointment> appointment= as.bookAppointment(appoint);
		if(appointment.isEmpty()) {
			return new ResponseEntity("Sorry! Patients not found!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Appointment>>(appointment, HttpStatus.OK);
	}
}
