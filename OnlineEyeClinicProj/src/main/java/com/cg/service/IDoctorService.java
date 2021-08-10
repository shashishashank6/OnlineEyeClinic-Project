package com.cg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.model.Appointment;
import com.cg.model.Doctor;
import com.cg.model.Test;

@Service
public interface IDoctorService {
	public List<Doctor> viewAllDoctors();
	public Doctor addDoctor(Doctor doctor);
	public Doctor updateDoctor(Doctor doctor);
	public Doctor deleteDoctor(int doctorId);
	public Doctor viewDoctor(int doctorId);
	public List<Appointment> viewAllAppointmentsByDoctorId(int doctorId);
	public void createTest(Doctor doctor);
}
