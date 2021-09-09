package com.cg.service;

import java.util.List;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cg.Exceptions.AdminIdNotFoundException;
import com.cg.Exceptions.NameNotFoundException;
import com.cg.Exceptions.UserNameAlreadyExistException;
import com.cg.model.AdminEntity;

@Service
public interface IAdminService {
//add admin
public AdminEntity addAdmin(AdminEntity admin) throws UserNameAlreadyExistException;
//view list of admin usernames
public List<String> getAdmins();
//view all admins
public List<AdminEntity> viewAllAdmins();
//remove admin
public AdminEntity removeAdmin(int adminId) throws AdminIdNotFoundException;
//update admin
public AdminEntity updateAdmin(AdminEntity admin);
//view admin by individual id
public AdminEntity viewAdmin(int adminId) throws AdminIdNotFoundException;
//by name
public AdminEntity byUserName(String userName) throws NameNotFoundException; 
public AdminEntity checkLogin(String username,String password);
}
