package com.cg.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.IAppointmentRepo;
//import com.cg.dao.IAppointmentRepo;
import com.cg.dao.IPatientRepo;
import com.cg.model.Appointment;
//import com.cg.model.Appointment;
import com.cg.model.Patient;

@Service
public class PatientServiceImpl implements IPatientService {
	@Autowired
 private IPatientRepo patientRepo;
	@Autowired
	private IAppointmentRepo  appointRepo;
	//@PersistenceContext
	//private EntityManager em;

	@Override
	public List<Patient> viewAllPatients() {
		// TODO Auto-generated method stub
		return patientRepo.findAll();
	}

	@Override
	public List<Patient> addPatient(Patient patient) {
		// TODO Auto-generated method stub
		patientRepo.saveAndFlush(patient);
		return patientRepo.findAll();
	}
	@Override
	public Patient bookAppointmnet(Patient patient) {
		// TODO Auto-generated method stub
		return patientRepo.saveAndFlush(patient);
	}

	@Override
	public Patient deletePatient(int patientId) {
		// TODO Auto-generated method stub
		Optional<Patient> p=patientRepo.findById(patientId);
	   patientRepo.deleteById(patientId);
	   return p.get();
	}

	@Override
	@Transactional
	public Patient updatePatient(Patient patient) {
		// TODO Auto-generated method stub
		return patientRepo.saveAndFlush(patient);
	
	}

	@Override
	public Patient viewPatient(int patientId) {
		// TODO Auto-generated method stub
		Optional<Patient> p=patientRepo.findById(patientId);
		return p.get();
		
	}

	@Override
	public List<Appointment> viewAppointmentsByPatient(int patientId) {
		// TODO Auto-generated method stub
		return appointRepo.findAllAppointmentsByPatientId(patientId);
	}	
}
