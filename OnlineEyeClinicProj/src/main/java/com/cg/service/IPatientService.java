package com.cg.service;

import java.util.List;

import org.springframework.stereotype.Service;

//import com.cg.model.Appointment;
import com.cg.model.Patient;

@Service
public interface IPatientService {
	public List<Patient> getAllPatients();
	public List<Patient> savePatient(Patient patient);
	//public List<Appointment> getAllAppointments();
}
