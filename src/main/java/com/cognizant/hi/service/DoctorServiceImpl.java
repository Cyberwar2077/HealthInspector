package com.cognizant.hi.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.hi.dao.ClinicRepository;
import com.cognizant.hi.dao.DoctorRepository;
import com.cognizant.hi.entity.ClinicEntity;
import com.cognizant.hi.entity.DoctorEntity;
import com.cognizant.hi.model.Doctor;



@Service
public class DoctorServiceImpl implements DoctorService {
	@Autowired
	DoctorRepository doctorDao;
	@Autowired
	ClinicRepository clinicDao;
	
	 @Autowired
	    private ModelMapper modelMapper;

@Transactional
	@Override
	public boolean addDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		boolean result = false;
        String clinicId=doctor.getClinicId();
        ClinicEntity clinic=clinicDao.getOne(clinicId);
        System.out.println(clinic.getClinicId());
		DoctorEntity c = modelMapper.map(doctor, DoctorEntity.class);
		Set<ClinicEntity> clinicSet=new HashSet<>();
		clinicSet.add(clinic);
//		c.setClinic(clinicSet);
		DoctorEntity res=doctorDao.save(c);
		if(res!=null)
		result=true;

		return result;
	}

@Override
@Transactional
public List<DoctorEntity> fetchDoctorDetails() {
	// TODO Auto-generated method stub
	return doctorDao.findAll();
}

@Override
@Transactional
public List<String> fetchSpeciality() {
	List<DoctorEntity> doctorDetails=fetchDoctorDetails();
	List<String> speciality=new ArrayList<>();
//	Set<String> speciality=new HashSet<>();
//	if(doctorDetails!=null) {
//		for(DoctorEntity doctor:doctorDetails) {
//			speciality.add(doctor.getSpeciality());
//		}
		doctorDetails.forEach(doctor->{
			if(!speciality.contains(doctor.getSpeciality()))
				speciality.add(doctor.getSpeciality());
		});
	return speciality;
}

@Override
@Transactional
public List<DoctorEntity> fetchDoctorBySpeciality(String speciality) {
	return doctorDao.fetchDoctorBySpeciality(speciality);
}

}

