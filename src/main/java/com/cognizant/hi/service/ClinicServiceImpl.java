package com.cognizant.hi.service;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.hi.dao.ClinicRepository;
import com.cognizant.hi.entity.ClinicEntity;
import com.cognizant.hi.model.Clinic;

@Service
public class ClinicServiceImpl implements ClinicService {
	@Autowired
	ClinicRepository clinicDao;
	 @Autowired
	    private ModelMapper modelMapper;


	@Override
	public boolean addClinic(Clinic clinic) {
		// TODO Auto-generated method stub
		boolean result = false;
		ClinicEntity c = modelMapper.map(clinic, ClinicEntity.class);
		ClinicEntity res=clinicDao.save(c);
		if(res!=null)
		result=true;

		return result;
	}


	@Override
	public List<ClinicEntity> fetchClinicDetails() {
		
		return clinicDao.findAll();
	}


	@Override
	@Transactional
	public List<ClinicEntity> findClinicByLocality(String Locality) {
		// TODO Auto-generated method stub
		return clinicDao.findClinicByLocality(Locality);
	}


	

}
