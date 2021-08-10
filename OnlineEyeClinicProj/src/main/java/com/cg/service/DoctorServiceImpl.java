package com.cg.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.IAppointmentRepo;
import com.cg.dao.IDoctorRepo;
import com.cg.dao.ITestRepo;
import com.cg.model.Appointment;
import com.cg.model.Doctor;
import com.cg.model.Test;

@Service
public class DoctorServiceImpl implements IDoctorService {

	@Autowired
	private IDoctorRepo doctorRepo;
	
	@Autowired
	private IAppointmentRepo appointRepo;
	
	@Autowired
	private ITestRepo testRepo;

	@Override
	public List<Doctor> viewAllDoctors() {
		// TODO Auto-generated method stub
		return doctorRepo.findAll();
	}

	@Override
	public Doctor addDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
	 return doctorRepo.saveAndFlush(doctor);
	}


	@Override
	public Doctor updateDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		return doctorRepo.saveAndFlush(doctor);
	}

	@Override
	public Doctor deleteDoctor(int doctorId) {
		// TODO Auto-generated method stub
		Optional<Doctor> doctor= doctorRepo.findById(doctorId);
		doctorRepo.deleteById(doctorId);
		return doctor.get();
	}

	@Override
	public Doctor viewDoctor(int doctorId) {
		// TODO Auto-generated method stub
		Optional<Doctor> doctor= doctorRepo.findById(doctorId);
		return doctor.get();
	}

	@Override
	public List<Appointment> viewAllAppointmentsByDoctorId(int doctorId) {
		// TODO Auto-generated method stub
		return appointRepo.findAllAppointmentByDoctorId(doctorId);
	}

	@Override
	public void createTest(Doctor doctor) {
		// TODO Auto-generated method stub
		List<Test> t=new ArrayList<>();
	    doctor.setTest(t);
		
	}

	
	
}
