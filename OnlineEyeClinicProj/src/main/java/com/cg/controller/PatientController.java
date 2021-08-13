package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.Exceptions.PatientIdNotFoundException;
import com.cg.Exceptions.UserNameAlreadyExistException;
import com.cg.model.Appointment;
import com.cg.model.Patient;
import com.cg.model.Report;
import com.cg.service.IPatientService;

@RestController
@RequestMapping("patient/api/v1")
public class PatientController {
    @Autowired
	private IPatientService ps;
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/patients")
	public ResponseEntity<List<Patient>> getAllPatient(){
		List<Patient> patient= ps.viewAllPatients();
		if(patient.isEmpty()) {
			return new ResponseEntity("Sorry! Patients not found!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Patient>>(patient, HttpStatus.OK);
	}
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping("/patients")
	public ResponseEntity<Patient> InsertPatient(@RequestBody Patient patients)throws UserNameAlreadyExistException{
		Patient patient= ps.addPatient(patients);
		if(patient==null) {
			return new ResponseEntity("Sorry! Patient not inserted!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Patient>(patient, HttpStatus.OK);
	}
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @DeleteMapping("/patients/{patientId}")
	public ResponseEntity<Patient> deletePatient(
			@PathVariable("patientId")Integer patientId)throws PatientIdNotFoundException{
		Patient patient= ps.deletePatient(patientId);
		if(patient==null) {
			return new ResponseEntity("Sorry! patient not available!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Patient>(patient, HttpStatus.OK);
	}
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping("/bookAppointment")
	public ResponseEntity<Patient> insertAppointment(@RequestBody Patient patients){
		Patient patient= ps.bookAppointmnet(patients);
		if(patient==null) {
			return new ResponseEntity("Sorry! appointment not inserted!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Patient>(patient, HttpStatus.OK);
	}
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @GetMapping("/patients/{patientId}")
	public ResponseEntity<Patient> findPatient(
			@PathVariable("patientId")Integer patientId)throws PatientIdNotFoundException{
		Patient patient= ps.viewPatient(patientId);
		if(patient==null) {
			return new ResponseEntity("Sorry! Patient not found!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Patient>(patient, HttpStatus.OK);
	}
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @PutMapping("/patients")
	public ResponseEntity<Patient> updatePatient(
			 @RequestBody Patient patient){
		Patient patients= ps.updatePatient(patient);
		if(patients==null)
		{
			return new ResponseEntity("Sorry! Patient not updated!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Patient>(patients, HttpStatus.OK);
	}
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @GetMapping("/getAppointments/{patientId}")
	public ResponseEntity<List<Appointment>> findAppointmentByPatient(
			@PathVariable("patientId")Integer patientId)throws PatientIdNotFoundException{
		List<Appointment> appoint= ps.viewAppointmentsByPatient(patientId);
		if(appoint.isEmpty()) {
			return new ResponseEntity("Sorry! appointments not found!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Appointment>>(appoint, HttpStatus.OK);
	}
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @GetMapping("/getReports/{patientId}")
	public ResponseEntity<List<Report>> findReportsByPatient(
			@PathVariable("patientId")Integer patientId)throws PatientIdNotFoundException{
		List<Report> report= ps.viewReportsByPatient(patientId);
		if(report.isEmpty()) {
			return new ResponseEntity("Sorry! reports not found!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Report>>(report, HttpStatus.OK);
	}
}
