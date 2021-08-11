package com.cg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.service.ILoginService;

@RestController
@RequestMapping("login/api/v1")
public class LoginController {
	@Autowired
private ILoginService ls;
	@GetMapping("/admin/{username}/{password}")
	public ResponseEntity<String> adminLogin(@PathVariable String username,@PathVariable String password)
	{
		return new ResponseEntity<String>(ls.adminLogin(username, password),HttpStatus.OK);
	}
	@GetMapping("/doctor/{username}/{password}")
	public ResponseEntity<String> doctorLogin(@PathVariable String username,@PathVariable String password)
	{
		return new ResponseEntity<String>(ls.doctorLogin(username, password),HttpStatus.OK);
	}
	@GetMapping("/patient/{username}/{password}")
	public ResponseEntity<String> patientLogin(@PathVariable String username,@PathVariable String password)
	{
		return new ResponseEntity<String>(ls.patientLogin(username, password),HttpStatus.OK);
	}
}
