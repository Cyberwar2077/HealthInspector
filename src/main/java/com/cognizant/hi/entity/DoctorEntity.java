package com.cognizant.hi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "doctor")
public class DoctorEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="doctorId")
	private int doctorId;

	@Column(name="speciality", length=30)
	private String speciality;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "clinicId", nullable = false)
	private ClinicEntity clinicId;
	@Column(name="days", length=30)
    private String days;
	@Column(name="time", length=30)
	private String time;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "userid", nullable = false)
	private UserEntity userid;


//	@OneToOne(fetch = FetchType.LAZY, optional = false)
//	@JoinColumn(name = "userid", nullable = false)
//	private UserEntity userid;

	
//	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@JoinTable(name = "doclinic", joinColumns = { 
//			@JoinColumn(name = "doctorId", nullable = false, updatable = false) }, 
//			inverseJoinColumns = { @JoinColumn(name = "clinicId", 
//					nullable = false, updatable = false) })
//	public Set<ClinicEntity> clinic;
	
	
	
	

//	public Set<ClinicEntity> getClinic() {
//		return clinic;
//	}
//
//	public void setClinic(Set<ClinicEntity> clinic) {
//		this.clinic = clinic;
//	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

//	public String getClinicName() {
//		return clinicName;
//	}
//
//	public void setClinicName(String clinicName) {
//		this.clinicName = clinicName;
//	}

	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	public ClinicEntity getClinicId() {
		return clinicId;
	}
	
	public void setClinicId(ClinicEntity clinicId) {
		this.clinicId = clinicId;
	}

	public UserEntity getUserid() {
		return userid;
	}

	public void setUserid(UserEntity userid) {
		this.userid = userid;
	}

	

	
}
