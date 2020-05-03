package com.cognizant.hi.service;

import java.util.List;
import java.util.Set;

import com.cognizant.hi.entity.ClinicEntity;
import com.cognizant.hi.model.Clinic;

public interface ClinicService 
{

	public boolean addClinic(Clinic clinic);

	public List<ClinicEntity> fetchClinicDetails();

	public List<ClinicEntity> findClinicByLocality(String Locality);

}
