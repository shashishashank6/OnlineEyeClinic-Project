package com.cg.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.cg.dao.IAppointmentRepo;
import com.cg.dao.IPatientRepo;
//import com.cg.model.Appointment;
import com.cg.model.Patient;

@Service
public class PatientServiceImpl implements IPatientService {
	@Autowired
 private IPatientRepo patientRepo;
	//@Autowired
	//private IAppointmentRepo  appointRepo;
	//@PersistenceContext
	//private EntityManager em;

	@Override
	public List<Patient> getAllPatients() {
		// TODO Auto-generated method stub
		return patientRepo.findAll();
	}

	@Override
	public List<Patient> savePatient(Patient patient) {
		// TODO Auto-generated method stub
		patientRepo.saveAndFlush(patient);
		
		return patientRepo.findAll();
	}

	/*@Override
	public List<Appointment> getAllAppointments() {
		// TODO Auto-generated method stub
		TypedQuery<Appointment> query
	      = em.createQuery(
	          "SELECT a FROM Patient p INNER JOIN p.app a", Appointment.class);
	    List<Appointment> resultList = query.getResultList();
	    return esultList;
	}*/
	
}
