package com.cg.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Appointment {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="appoint_seq")
	@SequenceGenerator(name="appoint_seq",sequenceName="appoint_seq",allocationSize=1)
	@Column(name="appointment_Id")
private int appointmentId;
	@Column(name="date_Of_Appointment")
	@JsonFormat(pattern="dd-MMM-yyyy")
private Date dateOfAppointment;
	@Column(name="time_Of_Appointment")
private String timeOfAppointment;
	@Column(name="consultation_Fee")
private double consultationFee;
	public int getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}
	public Date getDateOfAppointment() {
		return dateOfAppointment;
	}
	public void setDateOfAppointment(Date dateOfAppointment) {
		this.dateOfAppointment = dateOfAppointment;
	}
	public String getTimeOfAppointment() {
		return timeOfAppointment;
	}
	public void setTimeOfAppointment(String timeOfAppointment) {
		this.timeOfAppointment = timeOfAppointment;
	}
	public double getConsultationFee() {
		return consultationFee;
	}
	public void setConsultationFee(double consultationFee) {
		this.consultationFee = consultationFee;
	}
	public Appointment(int appointmentId, Date dateOfAppointment, String timeOfAppointment, double consultationFee) {
		super();
		this.appointmentId = appointmentId;
		this.dateOfAppointment = dateOfAppointment;
		this.timeOfAppointment = timeOfAppointment;
		this.consultationFee = consultationFee;
	}
	public Appointment(){
		
	}
}
