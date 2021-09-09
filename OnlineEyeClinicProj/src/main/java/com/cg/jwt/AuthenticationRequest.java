package com.cg.jwt;

public class AuthenticationRequest {
	private String adminUserName;
    private String adminPassword;

    public String getAdminUserName() {
		return adminUserName;
	}

	public void setAdminUserName(String adminUserName) {
		this.adminUserName = adminUserName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	//need default constructor for JSON Parsing
    public AuthenticationRequest()
    {

    }
}
