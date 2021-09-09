package com.cg.controller;

import java.awt.PageAttributes.MediaType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.Exceptions.AdminIdNotFoundException;
import com.cg.Exceptions.UserNameAlreadyExistException;
import com.cg.jwt.AdminUserService;
import com.cg.jwt.AuthenticationRequest;
import com.cg.jwt.AuthenticationResponse;
import com.cg.jwt.JwtUtil;
import com.cg.model.AdminEntity;
//import com.cg.model.Test;
import com.cg.service.IAdminService;


@RestController
@RequestMapping("admin/api/v1")
@CrossOrigin
public class AdminController {

	@Autowired
	private IAdminService as;
	@Autowired
	private JwtUtil jwtTokenUtil;
	@Autowired
	private AdminUserService userDetailsService;
	@Autowired
	private AuthenticationManager authenticationManager;
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/get")
	public ResponseEntity<List<AdminEntity>> getAllAdmins(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		List<AdminEntity> admins= as.viewAllAdmins();
		if(admins.isEmpty()) {
			return new ResponseEntity("Sorry! admins not found!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<AdminEntity>>(admins, HttpStatus.OK);
	}
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping("/insert")
	public ResponseEntity<AdminEntity> InsertAdmin(@RequestBody AdminEntity admin) throws UserNameAlreadyExistException{
    	AdminEntity admins= as.addAdmin(admin);
		if(admins==null) {
			return new ResponseEntity("Sorry! admin not inserted!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<AdminEntity>(admins, HttpStatus.OK);
	}
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @DeleteMapping("/delete/{adminId}")
	public ResponseEntity<AdminEntity> deleteAdmin (
			@PathVariable("adminId")Integer adminId)throws  AdminIdNotFoundException{
    	AdminEntity admin=as.removeAdmin(adminId);
		if(admin==null) {
			return new ResponseEntity("Sorry! admin not found!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<AdminEntity>(admin, HttpStatus.OK);
	}
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @GetMapping("/viewAdmin/{adminId}")
	public ResponseEntity<AdminEntity> findAdmin(
			@PathVariable("adminId")Integer adminId)throws AdminIdNotFoundException{
    	AdminEntity admin=as.viewAdmin(adminId);
		if(admin==null) {
			return new ResponseEntity("Sorry! admin not found!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<AdminEntity>(admin, HttpStatus.OK);
	}
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @PutMapping("/update")
	public ResponseEntity<AdminEntity> updateAdmin(
			 @RequestBody AdminEntity admin){
    	AdminEntity admins=as.updateAdmin(admin);
		if(admins==null)
		{
			return new ResponseEntity("Sorry! admin not updated!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<AdminEntity>(admins, HttpStatus.OK);
	}
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @GetMapping("/getAdminUserNames")
	public ResponseEntity<List<String>> getAllUsernames()
	{
    	List<String> admins= as.getAdmins();
		if(admins.isEmpty()) {
			return new ResponseEntity("Sorry! tests not found!", 
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<String>>(admins,HttpStatus.OK);
	}
   @PostMapping("/authenticate")
	public ResponseEntity<?> generateToken(@RequestBody AuthenticationRequest auth)throws Exception {
	   AdminEntity admin;
	   try{ admin = as.checkLogin(auth.getAdminUserName(), auth.getAdminPassword());
		if (admin == null) {
			throw new Exception("Check the entered values for adminName and password!");
		}
		try {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(auth.getAdminUserName(), auth.getAdminPassword()));
	}catch(BadCredentialsException e) {
		throw new Exception("Incorrect username or password", e);
	}}catch(Exception e) {
		throw new Exception(e.getMessage());
	}
final UserDetails userDetails = userDetailsService.loadUserByUsername(auth.getAdminUserName());
final String jwt=jwtTokenUtil.generateToken(userDetails);
String userId=String.valueOf(admin.getAdminId());
 return ResponseEntity.ok(new AuthenticationResponse(userId,jwt));
	}
}
