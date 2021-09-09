package com.cg.jwt;



public class AuthenticationResponse {

    private final String jwt;
    private final String userid;
    public AuthenticationResponse(String userId,String jwt) {
    	this.userid=userId;
        this.jwt = jwt;
       
    }
     
    public String getUserid() {
		return userid;
	}

	public String getJwt() {
        return jwt;
    }
   
    
    
}
