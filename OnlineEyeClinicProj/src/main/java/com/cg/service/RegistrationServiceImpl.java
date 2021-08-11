package com.cg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.model.Admin;
import com.cg.model.Doctor;
import com.cg.model.Patient;

@Service
public class RegistrationServiceImpl implements IRegistrationService {
	@Autowired
	private IPatientService patientService;
	
	@Autowired
	private IDoctorService doctorService;
	
	@Autowired
	private IAdminService adminService;

	@Override
	public Patient registerPatient(Patient patient) {
		// TODO Auto-generated method stub
		return (Patient) patientService.addPatient(patient);
	}

	@Override
	public Doctor registerDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		return doctorService.addDoctor(doctor);
	}

	@Override
	public Admin registerAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminService.addAdmin(admin);
	}
}
