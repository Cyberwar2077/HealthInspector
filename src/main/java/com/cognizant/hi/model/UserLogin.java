package com.cognizant.hi.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserLogin {
	@NotEmpty(message="NotEmpty.userLogin.userid")
	private String userid;
	@NotEmpty(message="Password is required")
	@Size(min=6,max=15,message="Size.userLogin.password")
	private String password;
	
	
	public String getPassword() {
		return password;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
