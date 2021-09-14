package com.cg.dao;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

//import com.cg.model.Appointment;
import com.cg.model.Doctor;

@Repository
public interface IDoctorRepo extends JpaRepository<Doctor, Integer> {
	@Query("select d from Doctor d where d.doctorUserName=:name and d.doctorPassword=:password")
	Doctor checkLogin(@Param("name")String username,@Param("password")String password);
	
	@Query("from Doctor where doctorUserName=?1")
	Doctor findByDoctorUserName(String userName);
}
