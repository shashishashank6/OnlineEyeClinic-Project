package com.cg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.model.Appointment;
//import com.cg.model.Appointment;
import com.cg.model.Patient;
import com.cg.model.Report;

@Service
public interface IPatientService{
	public List<Patient> viewAllPatients();
	public List<Patient> addPatient(Patient patient);
	public Patient bookAppointmnet(Patient patient);
	public Patient deletePatient(int patientId);
	public Patient updatePatient(Patient patient);
	public Patient viewPatient(int patientId);
	public List<Appointment> viewAppointmentsByPatient(int patientId);
	public List<Report> viewReportsByPatient(int patientId);
}
