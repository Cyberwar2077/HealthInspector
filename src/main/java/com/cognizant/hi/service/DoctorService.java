package com.cognizant.hi.service;

import java.util.List;

import com.cognizant.hi.entity.DoctorEntity;
import com.cognizant.hi.model.Doctor;

public interface DoctorService {
	public boolean addDoctor(Doctor doctor);

	public List<DoctorEntity> fetchDoctorDetails();
	
	public List<String> fetchSpeciality();

	public List<DoctorEntity> fetchDoctorBySpeciality(String speciality);
}
