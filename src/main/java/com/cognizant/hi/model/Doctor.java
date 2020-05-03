package com.cognizant.hi.model;

public class Doctor {
    
	private int doctorId;

	private String userid;
	private String speciality;
	private String clinicId;
	private String days;
    private String time;

	public String getSpeciality() {
		return speciality;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	

	public String getClinicId() {
		return clinicId;
	}

	public void setClinicId(String clinicId) {
		this.clinicId = clinicId;
	}

	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	
}
