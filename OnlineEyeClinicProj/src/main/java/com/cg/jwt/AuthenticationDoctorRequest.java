package com.cg.jwt;

public class AuthenticationDoctorRequest {
	private String doctorUserName;
	private String doctorPassword;
	public String getDoctorUserName() {
		return doctorUserName;
	}
	public void setDoctorUserName(String doctorUserName) {
		this.doctorUserName = doctorUserName;
	}
	public String getDoctorPassword() {
		return doctorPassword;
	}
	public void setDoctorPassword(String doctorPassword) {
		this.doctorPassword = doctorPassword;
	}
	
}
