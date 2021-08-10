package com.cg.service;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.model.Appointment;
import com.fasterxml.jackson.annotation.JsonFormat;

@Service
public interface IAppointmentService {
public List<Appointment> viewAllAppointments();
public Appointment bookAppointment(Appointment appoint);
public Appointment cancelAppointment(int AppointmentId);
public Appointment viewAppointment(int appointmentId);
public List<Appointment> viewAppointments(Date date);
public Appointment updateAppointment(Appointment appointment);
}
