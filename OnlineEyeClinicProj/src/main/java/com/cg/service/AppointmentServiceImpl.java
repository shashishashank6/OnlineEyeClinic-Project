package com.cg.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.IAppointmentRepo;
import com.cg.model.Appointment;
import com.fasterxml.jackson.annotation.JsonFormat;

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
	public Appointment bookAppointment(Appointment appoint) {
		// TODO Auto-generated method stub
		return appointRepo.saveAndFlush(appoint);
		
	}


	@Override
	public Appointment cancelAppointment(int appointmentId) {
		// TODO Auto-generated method stub
	     Optional<Appointment> appoint=appointRepo.findById(appointmentId);
	     appointRepo.deleteById(appointmentId);
	     return appoint.get();
	}

	@Override
	public Appointment viewAppointment(int appointmentId) {
		// TODO Auto-generated method stub
		Optional<Appointment> appoint=appointRepo.findById(appointmentId);
		return appoint.get();
	}
	
	@Override
	public List<Appointment> viewAppointments(Date date) {
		// TODO Auto-generated method stub
	return appointRepo.getByDate(date);
	}

	@Override
	public Appointment updateAppointment(Appointment appointment) {
		// TODO Auto-generated method stub
		return appointRepo.saveAndFlush(appointment);
	}
}
