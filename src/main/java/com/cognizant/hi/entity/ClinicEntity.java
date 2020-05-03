package com.cognizant.hi.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "clinic")
public class ClinicEntity {

	@Column(name = "clinicName", length = 40)
	private String clinicName;
	@Id
	@Column(name = "clinicId", length = 40)
	private String clinicId;
	@Column(name = "address", length = 40)
	private String address;
	@Column(name = "facilities", length = 50)
	private String facilities;
	@Override
	public String toString() {
		return "ClinicEntity [clinicName=" + clinicName + ", clinicId=" + clinicId + ", address=" + address
				+ ", facilities=" + facilities + ", contactNumber=" + contactNumber + ", website=" + website
				+ ", locality=" + locality + ", doctor=" + doctor + "]";
	}
	@Column(name = "contactNumber", length = 50)
	private String contactNumber;
	@Column(name = "website", length = 50)
	private String website;
	@Column(name = "locality", length = 50)
	private String locality;
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "clinicId",cascade = CascadeType.ALL)
	public Set<DoctorEntity> doctor;
	
	
	
	public Set<DoctorEntity> getDoctor() {
		return doctor;
	}
	public void setDoctor(Set<DoctorEntity> doctor) {
		this.doctor = doctor;
	}
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
