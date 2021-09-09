package com.cg.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Doctor {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="doctor_seq")
	@SequenceGenerator(name="doctor_seq",sequenceName="doctor_seq",allocationSize=1)
	@Column(name="doctor_Id")
private int doctorId;
	@Column(name="doctor_Name")
private String doctorName;
	@Column(name="doctor_Consultation_Time")
private String doctorConsultationTime;
	@Column(name="doctor_Mobile")
private long doctorMobile;
	@Column(name="doctor_Email")
private String doctorEmail;
	@Column(name="doctor_User_Name")
private String doctorUserName;
	@Column(name="doctor_Password")
private String doctorPassword;
@Column(name="doctor_Address")
private String doctorAddress;
@OneToMany(targetEntity =Appointment.class)
@JoinColumn(name="doctor_Id")
private List<Appointment> appointment=new ArrayList<>();
//@OneToMany(cascade=CascadeType.ALL,mappedBy = "doctor", fetch = FetchType.EAGER)
//@OneToMany(targetEntity=Test.class)
//@OneToMany(targetEntity =Test.class,cascade=CascadeType.ALL)

//@JoinColumn(name="doctor_Id",updatable=false,insertable=true,nullable=false)
//private List<Test> test=new ArrayList<Test>();

public void setAppointment(List<Appointment> appointment) {
	this.appointment = appointment;
}
public int getDoctorId() {
	return doctorId;
}
public void setDoctorId(int doctorId) {
	this.doctorId = doctorId;
}
public String getDoctorName() {
	return doctorName;
}
public void setDoctorName(String doctorName) {
	this.doctorName = doctorName;
}
public String getDoctorConsultationTime() {
	return doctorConsultationTime;
}
public void setDoctorConsultationTime(String doctorConsultationTime) {
	this.doctorConsultationTime = doctorConsultationTime;
}
public long getDoctorMobile() {
	return doctorMobile;
}
public void setDoctorMobile(long doctorMobile) {
	this.doctorMobile = doctorMobile;
}
public String getDoctorEmail() {
	return doctorEmail;
}
public void setDoctorEmail(String doctorEmail) {
	this.doctorEmail = doctorEmail;
}
public String getDoctorUserName() {
	return doctorUserName;
}
public void setDoctorUserName(String doctorUserName) {
	this.doctorUserName = doctorUserName;
}
public String getDoctorPassword() {
	return doctorPassword;
}
public void setDoctorPassword(String doctorPassword) {
	this.doctorPassword = doctorPassword;
}
public String getDoctorAddress() {
	return doctorAddress;
}
public void setDoctorAddress(String doctorAddress) {
	this.doctorAddress = doctorAddress;
}
/*
@JsonIgnore
public List<Test> getTest() {
	return test;
}*/
@JsonIgnore
public List<Appointment> getAppointment() {
	return appointment;
}
/*public void setAppointment(List<Appointment> appointment) {
	this.appointment = appointment;
}*/

public Doctor(int doctorId, String doctorName, String doctorConsultationTime, long doctorMobile, String doctorEmail,
		String doctorUserName, String doctorPassword, String doctorAddress) {
	super();
	this.doctorId = doctorId;
	this.doctorName = doctorName;
	this.doctorConsultationTime = doctorConsultationTime;
	this.doctorMobile = doctorMobile;
	this.doctorEmail = doctorEmail;
	this.doctorUserName = doctorUserName;
	this.doctorPassword = doctorPassword;
	this.doctorAddress = doctorAddress;
}


public Doctor() {
	
}
}
