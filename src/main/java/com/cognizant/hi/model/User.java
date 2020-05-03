package com.cognizant.hi.model;

import java.util.Date;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


public class User {
	
	@NotEmpty(message="NotEmpty.userLogin.userid")
	private String userid;
	@NotEmpty(message="Password is required")
	@Size(min=6,max=15,message="Size.userLogin.password")
	private String password;
	
	@NotEmpty(message="NotEmpty.user.firstName")
    private String firstName;
    @NotNull(message = "NotNull.user.dateOfBirth")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dateOfBirth;
	private String lastName;
	private String gender;
	private String contactNumber; 
	private String email;
	private String userCategory;
	
    public String getUserCategory() {
		return userCategory;
	}
	public void setUserCategory(String userCategory) {
		this.userCategory = userCategory;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getPassword() {
		return password;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	

}
