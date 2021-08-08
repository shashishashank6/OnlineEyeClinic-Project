package com.cg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.model.Doctor;

@Service
public interface IDoctorService {
	public List<Doctor> getAllDoctors();
	public List<Doctor> saveDoctor(Doctor doctor);
}
