package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.IAppointmentRepo;
import com.cg.model.Appointment;

@Service
public class AppointmentServiceImpl implements IAppointmentService{

	@Autowired
	private IAppointmentRepo appointRepo;

	@Override
	public List<Appointment> viewAllAppointments() {
		// TODO Auto-generated method stub
		return appointRepo.findAll();
	}

	@Override
	public List<Appointment> bookAppointment(Appointment appoint) {
		// TODO Auto-generated method stub
		appointRepo.saveAndFlush(appoint);
		return appointRepo.findAll();
	}
}
