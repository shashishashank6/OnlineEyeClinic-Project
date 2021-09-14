package com.cg.jwt;

public class AuthenticationPatientRequest {
private String patientUserName;
private String patientPassword;

public String getPatientUserName() {
	return patientUserName;
}
public void setPatientUserName(String patientUserName) {
	this.patientUserName = patientUserName;
}
public String getPatientPassword() {
	return patientPassword;
}
public void setPatientPassword(String patientPassword) {
	this.patientPassword = patientPassword;
}
public AuthenticationPatientRequest() {
	
}
}
