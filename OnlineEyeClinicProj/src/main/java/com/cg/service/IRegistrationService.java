package com.cg.service;

import org.springframework.stereotype.Service;

import com.cg.model.Admin;
import com.cg.model.Doctor;
import com.cg.model.Patient;

@Service
public interface IRegistrationService {
	public Patient registerPatient(Patient patient); 

	public Doctor registerDoctor(Doctor doctor); 

	public Admin registerAdmin(Admin admin); 
}
