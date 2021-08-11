package com.cg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.model.Admin;

@Service
public interface IAdminService {
public Admin addAdmin(Admin admin);
public List<String> getAdmins();
public List<Admin> viewAllAdmins();
public Admin removeAdmin(int adminId);
public Admin updateAdmin(Admin admin);
public Admin viewAdmin(int adminId);
}
