package com.cg.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.model.AdminEntity;
import com.cg.model.Patient;

@Repository
public interface IPatientRepo extends JpaRepository<Patient,Integer> {
	@Query("select p from Patient p where p.patientUserName=:name and p.patientPassword=:password")
	Patient checkLogin(@Param("name")String username,@Param("password")String password);
	
	@Query("from Patient where patientUserName=?1")
	Patient findByPatientUserName(String userName);
}
