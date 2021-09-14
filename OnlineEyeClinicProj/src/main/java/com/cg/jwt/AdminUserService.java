package com.cg.jwt;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cg.dao.IAdminRepo;
import com.cg.dao.IDoctorRepo;
import com.cg.dao.IPatientRepo;
import com.cg.model.AdminEntity;
import com.cg.model.Doctor;
import com.cg.model.Patient;

@Service
public class AdminUserService implements UserDetailsService {

	@Autowired
	private IAdminRepo repo;
	
	@Autowired
	private IPatientRepo patientRepo;

	@Autowired
	private IDoctorRepo doctorRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		AdminEntity admin=repo.findByAdminName(username);
		Patient patient=patientRepo.findByPatientUserName(username);
		Doctor doctor=doctorRepo.findByDoctorUserName(username);
		if(patient==null && doctor==null) {
			return new User(admin.getAdminUserName(), admin.getAdminPassword(), new ArrayList<>());
		}
		else if(admin==null && doctor==null){
		return new User(patient.getPatientUserName(), patient.getPatientPassword(), new ArrayList<>());
		}
		else {
			return new User(doctor.getDoctorUserName(), doctor.getDoctorPassword(), new ArrayList<>());
		}
		
	}

}
