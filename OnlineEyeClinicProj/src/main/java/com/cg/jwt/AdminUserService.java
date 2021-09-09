package com.cg.jwt;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cg.dao.IAdminRepo;
import com.cg.model.AdminEntity;

@Service
public class AdminUserService implements UserDetailsService {

	@Autowired
	private IAdminRepo repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		AdminEntity admin=repo.findByAdminName(username);
		return new User(admin.getAdminUserName(), admin.getAdminPassword(), new ArrayList<>());
	}

}
