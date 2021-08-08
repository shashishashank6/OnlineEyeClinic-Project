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

import com.cg.model.Doctor;
import com.cg.model.Patient;
import com.cg.service.IDoctorService;

@RestController
@RequestMapping("doctor/api/v1")
public class DoctorController {

	@Autowired
	private IDoctorService ds;
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/doctors")
	public ResponseEntity<List<Doctor>> getAllDoctor(){
		List<Doctor> doctor= ds.getAllDoctors();
		if(doctor.isEmpty()) {
			return new ResponseEntity("Sorry! doctors not found!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Doctor>>(doctor, HttpStatus.OK);
	}
	 @SuppressWarnings({ "rawtypes", "unchecked" })
		@PostMapping("/doctors")
		public ResponseEntity<List<Doctor>> InsertDoctor(@RequestBody Doctor doctor){
			List<Doctor> doctors= ds.saveDoctor(doctor);
			if(doctors.isEmpty()) {
				return new ResponseEntity("Sorry! doctors not found!", 
						HttpStatus.NOT_FOUND);
			}
			
			return new ResponseEntity<List<Doctor>>(doctors, HttpStatus.OK);
		}
}
