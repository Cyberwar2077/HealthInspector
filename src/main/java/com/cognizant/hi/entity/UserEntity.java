package com.cognizant.hi.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "user")
public class UserEntity {

	@Id
	@Column(name = "userid", length = 30)
	private String userid;
	@Column(name = "password", length = 30)
	private String password;
	@Column(name = "first_name", length = 30)
	private String firstName;
	@Column(name = "last_name", length = 30)
	private String lastName;
	@Column(name = "gender", length = 30)
	private String gender;
	@Column(name = "contactNumber", length = 30)
	private String contactNumber;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	@Column(name = "email", length = 30)
	private String email;
	@Column(name = "user_category", length = 30)
	private String userCategory;

	@OneToMany(mappedBy = "userid", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<DoctorEntity> doctor;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "doctorName", cascade = CascadeType.ALL)
	private Set<AppointmentEntity> appointmentForDoctor;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "patientName", cascade = CascadeType.ALL)
	private Set<AppointmentEntity> appointmentForpatient;

	public Set<DoctorEntity> getDoctor() {
		return doctor;
	}

	public void setDoctor(Set<DoctorEntity> doctor) {
		this.doctor = doctor;
	}

//    @OneToOne(mappedBy = "userid", fetch = FetchType.LAZY,
//	cascade = CascadeType.ALL)
//    private DoctorEntity doctor; 
//	
//	
//	public DoctorEntity getDoctor() {
//		return doctor;
//	}
//	public void setDoctor(DoctorEntity doctor) {
//		this.doctor = doctor;
//	}
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

	public String getUserCategory() {
		return userCategory;
	}

	public void setUserCategory(String userCategory) {
		this.userCategory = userCategory;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	@Column(name = "firstname")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
