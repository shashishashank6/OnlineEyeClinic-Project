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

//import com.cg.model.Appointment;
import com.cg.model.Patient;
import com.cg.service.IPatientService;

@RestController
@RequestMapping("patient/api/v1")
public class PatientController {
    @Autowired
	private IPatientService ps;
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/patients")
	public ResponseEntity<List<Patient>> getAllPatient(){
		List<Patient> patient= ps.getAllPatients();
		if(patient.isEmpty()) {
			return new ResponseEntity("Sorry! Patients not found!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Patient>>(patient, HttpStatus.OK);
	}
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping("/patients")
	public ResponseEntity<List<Patient>> InsertPatient(@RequestBody Patient patients){
		List<Patient> patient= ps.savePatient(patients);
		if(patient.isEmpty()) {
			return new ResponseEntity("Sorry! Patients not found!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Patient>>(patient, HttpStatus.OK);
	}
   /* @SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/appointments")
	public ResponseEntity<List<Appointment>> getAllAppointment(){
		List<Appointment> appoint= ps.getAllAppointments();
		if(appoint.isEmpty()) {
			return new ResponseEntity("Sorry! Patients not found!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Appointment>>(appoint, HttpStatus.OK);
	}*/
}
