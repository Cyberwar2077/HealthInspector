package com.cognizant.hi.model;

import javax.validation.constraints.NotEmpty;

public class Clinic {
	
	@NotEmpty(message="NotEmpty.clinic.clinicName")
	private String clinicName;
	@NotEmpty(message="NotEmpty.clinic.clinicId")
	private String clinicId;
	
	private String address;
	private String facilities;
	private String contactNumber;
	private String website;
	@NotEmpty(message="NotEmpty.clinic.locality")
	private String locality;
	
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getFacilities() {
		return facilities;
	}
	public void setFacilities(String facilities) {
		this.facilities = facilities;
	}
	
	public String getClinicName() {
		return clinicName;
	}
	public void setClinicName(String clinicName) {
		this.clinicName = clinicName;
	}
	public String getClinicId() {
		return clinicId;
	}
	public void setClinicId(String clinicId) {
		this.clinicId = clinicId;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getLocality() {
		return locality;
	}
	public void setLocality(String locality) {
		this.locality = locality;
	}

	

}
