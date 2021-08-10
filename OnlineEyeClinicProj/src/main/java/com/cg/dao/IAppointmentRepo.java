package com.cg.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.model.Appointment;
import com.fasterxml.jackson.annotation.JsonFormat;

@Repository
public interface IAppointmentRepo extends JpaRepository<Appointment,Integer> {
	@Query("SELECT a FROM Appointment a  WHERE a.dateOfAppointment=:date") 
public List<Appointment> getByDate(@Param("date") Date date);
	@Query("from Appointment where doctor.doctorId=?1")
	public List<Appointment> findAllAppointmentByDoctorId(int doctorId);
	@Query("from Appointment where patient.patientId=?1")
	public List<Appointment> findAllAppointmentsByPatientId(int patientId);
}
