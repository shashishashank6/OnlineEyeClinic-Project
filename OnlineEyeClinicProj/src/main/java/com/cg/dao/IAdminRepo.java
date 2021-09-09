package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.model.AdminEntity;

@Repository
public interface IAdminRepo extends JpaRepository<AdminEntity,Integer> {
	@Query("from AdminEntity where adminUserName=?1")
	AdminEntity findByAdminName(String userName);
	
	@Query("select a from AdminEntity a where a.adminUserName=:name and a.adminPassword=:password")
	AdminEntity checkLogin(@Param("name")String username,@Param("password")String password);
}
