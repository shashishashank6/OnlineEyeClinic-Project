package com.cg.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.IAdminRepo;
import com.cg.model.Admin;

@Service
public class AdminServiceImpl implements IAdminService {

	@Autowired
	private IAdminRepo adminRepo;

	@Override
	public Admin addAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminRepo.saveAndFlush(admin);
	}

	@Override
	public List<String> getAdmins() {
		// TODO Auto-generated method stub
		List<String> usernameList=new ArrayList<String>();
		List<Admin> adminList=adminRepo.findAll();
		for(Admin admin:adminList)
		{
			usernameList.add(admin.getAdminUserName());
		}
		return usernameList;
	}

	@Override
	public List<Admin> viewAllAdmins() {
		// TODO Auto-generated method stub
		return adminRepo.findAll();
	}

	@Override
	public Admin removeAdmin(int adminId) {
		// TODO Auto-generated method stub
	  Optional<Admin> a=adminRepo.findById(adminId);
	  adminRepo.deleteById(adminId);
	  return a.get();
	}

	@Override
	public Admin updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminRepo.saveAndFlush(admin);
	}

	@Override
	public Admin viewAdmin(int adminId) {
		// TODO Auto-generated method stub
		Optional<Admin> a=adminRepo.findById(adminId);
		  return a.get();
	}
}
