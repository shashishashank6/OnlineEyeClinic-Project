package com.cg.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cg.Exceptions.AdminIdNotFoundException;
import com.cg.Exceptions.NameNotFoundException;
import com.cg.Exceptions.UserNameAlreadyExistException;
import com.cg.dao.IAdminRepo;
import com.cg.model.AdminEntity;
import com.cg.model.Doctor;

@Service
public class AdminServiceImpl implements IAdminService {

	@Autowired
	private IAdminRepo adminRepo;

	@Override
	public AdminEntity addAdmin(AdminEntity admin) throws UserNameAlreadyExistException {
		// TODO Auto-generated method stub
		List<AdminEntity> admins=this.viewAllAdmins();
		for(AdminEntity ad:admins)
		{
			if(ad.getAdminUserName().equals(admin.getAdminUserName()))
			{
				throw new UserNameAlreadyExistException("username already exist.....Please modify your username !");
			}
		}
		return adminRepo.saveAndFlush(admin);
	}

	@Override
	public List<String> getAdmins() {
		// TODO Auto-generated method stub
		List<String> usernameList=new ArrayList<String>();
		List<AdminEntity> adminList=adminRepo.findAll();
		for(AdminEntity admin:adminList)
		{
			usernameList.add(admin.getAdminUserName());
		}
		return usernameList;
	}

	@Override
	public List<AdminEntity> viewAllAdmins() {
		// TODO Auto-generated method stub
		return adminRepo.findAll();
	}

	@Override
	public AdminEntity removeAdmin(int adminId) throws AdminIdNotFoundException {
		// TODO Auto-generated method stub
		Supplier<AdminIdNotFoundException> supplier=()->new AdminIdNotFoundException("no admin found with this id");
	  Optional<AdminEntity> a=Optional.ofNullable(adminRepo.findById(adminId).orElseThrow(supplier));
	  adminRepo.deleteById(adminId);
	  return a.get();
	}

	@Override
	public AdminEntity updateAdmin(AdminEntity admin) {
		// TODO Auto-generated method stub
		return adminRepo.saveAndFlush(admin);
	}

	@Override
	public AdminEntity viewAdmin(int adminId) throws AdminIdNotFoundException {
		// TODO Auto-generated method stub
		Supplier<AdminIdNotFoundException> supplier=()->new AdminIdNotFoundException("no admin found with this id");
		Optional<AdminEntity> a=Optional.ofNullable(adminRepo.findById(adminId).orElseThrow(supplier));
		  return a.get();
	}

	@Override
	public AdminEntity byUserName(String userName) throws NameNotFoundException {
		// TODO Auto-generated method stub
		AdminEntity admin=adminRepo.findByAdminName(userName);
		if(admin==null)
		{
			throw new NameNotFoundException("no doctor is available with name : "+userName);
		}
		return admin;
	}

	@Override
	public AdminEntity checkLogin(String username, String password) {
		// TODO Auto-generated method stub
		return adminRepo.checkLogin(username, password);
	}
}
