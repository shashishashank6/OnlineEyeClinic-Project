package com.cg.service;

import org.springframework.stereotype.Service;

@Service
public interface ILoginService {
	public String adminLogin(String username,String password);
	public String patientLogin(String username,String password);
	public String doctorLogin(String username,String password);
}
