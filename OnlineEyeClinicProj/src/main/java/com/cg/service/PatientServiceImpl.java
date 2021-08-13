package com.cg.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.Exceptions.PatientIdNotFoundException;
import com.cg.Exceptions.UserNameAlreadyExistException;
import com.cg.dao.IAppointmentRepo;
//import com.cg.dao.IAppointmentRepo;
import com.cg.dao.IPatientRepo;
import com.cg.dao.IReportRepo;
import com.cg.model.Appointment;
//import com.cg.model.Appointment;
import com.cg.model.Patient;
import com.cg.model.Report;

@Service
public class PatientServiceImpl implements IPatientService {
	@Autowired
 private IPatientRepo patientRepo;
	@Autowired
	private IAppointmentRepo  appointRepo;
	//@PersistenceContext
	//private EntityManager em;
	@Autowired
	private IReportRepo reportRepo;

	@Override
	public List<Patient> viewAllPatients() {
		// TODO Auto-generated method stub
		return patientRepo.findAll();
	}

	@Override
	public Patient addPatient(Patient patient)throws UserNameAlreadyExistException{
		// TODO Auto-generated method stub
		List<Patient> patients=this.viewAllPatients();
		for(Patient pt:patients)
		{
			if(pt.getPatientUserName().equals(patient.getPatientUserName()))
			{
				throw new UserNameAlreadyExistException("provided username is already taken....Please modify your username !");
			}
		}
		return patientRepo.saveAndFlush(patient);
		
	}
	@Override
	public Patient bookAppointmnet(Patient patient) {
		// TODO Auto-generated method stub
		return patientRepo.saveAndFlush(patient);
	}

	@Override
	public Patient deletePatient(int patientId)throws PatientIdNotFoundException{
		// TODO Auto-generated method stub
		Supplier<PatientIdNotFoundException> supplier = ()->new PatientIdNotFoundException("Patient with given id is not available");
		Optional<Patient> p=Optional.ofNullable(patientRepo.findById(patientId).orElseThrow(supplier));
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
	public Patient viewPatient(int patientId)throws PatientIdNotFoundException{
		// TODO Auto-generated method stub
		Supplier<PatientIdNotFoundException> supplier = ()->new PatientIdNotFoundException("Patient with given id is not available");
		Optional<Patient> p=Optional.ofNullable(patientRepo.findById(patientId).orElseThrow(supplier));
		return p.get();
		
	}

	@Override
	public List<Appointment> viewAppointmentsByPatient(int patientId)throws PatientIdNotFoundException {
		// TODO Auto-generated method stub
		return appointRepo.findAllAppointmentsByPatientId(patientId);
	}

	@Override
	public List<Report> viewReportsByPatient(int patientId)throws PatientIdNotFoundException{
		// TODO Auto-generated method stub
		return reportRepo.findReportByPatient(patientId); 
	}	
}
