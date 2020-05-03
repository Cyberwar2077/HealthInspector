package com.cognizant.hi.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="appointment")
public class AppointmentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int appointmentId;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="doctorName", referencedColumnName="userid")
	private UserEntity doctorName;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="patientName", referencedColumnName="userid")
	private UserEntity patientName;
	private String appointmentStatus;
	private String seen;
	private String patientId;
	
	public int getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}
	public UserEntity getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(UserEntity doctorName) {
		this.doctorName = doctorName;
	}
	public UserEntity getPatientName() {
		return patientName;
	}
	public void setPatientName(UserEntity patientName) {
		this.patientName = patientName;
	}
	public String getAppointmentStatus() {
		return appointmentStatus;
	}
	public void setAppointmentStatus(String appointmentStatus) {
		this.appointmentStatus = appointmentStatus;
	}
	public String getSeen() {
		return seen;
	}
	public void setSeen(String seen) {
		this.seen = seen;
	}
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	
}
