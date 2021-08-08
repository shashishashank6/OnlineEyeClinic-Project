package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.IDoctorRepo;
import com.cg.model.Doctor;

@Service
public class DoctorServiceImpl implements IDoctorService {

	@Autowired
	private IDoctorRepo doctorRepo;

	@Override
	public List<Doctor> getAllDoctors() {
		// TODO Auto-generated method stub
		return doctorRepo.findAll();
	}

	@Override
	public List<Doctor> saveDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
	 doctorRepo.saveAndFlush(doctor);
	 return doctorRepo.findAll();
	}
	
}
