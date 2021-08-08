package com.cg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.model.Appointment;

@Service
public interface IAppointmentService {
public List<Appointment> viewAllAppointments();
public List<Appointment> bookAppointment(Appointment appoint);
}
