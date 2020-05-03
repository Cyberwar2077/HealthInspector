package com.cognizant.hi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.hi.dao.AppointmentRepository;
import com.cognizant.hi.entity.AppointmentEntity;
import com.cognizant.hi.entity.UserEntity;


@Service
public class AppointmentServiceImpl implements AppointmentService {

	
	@Autowired
	AppointmentRepository appointmentDao;
	
	
	@Override
	public boolean bookAppointment(AppointmentEntity appointment) {
		// TODO Auto-generated method stub
		boolean result = false;
		AppointmentEntity res=appointmentDao.save(appointment);
		if(res!=null)
			result=true;

			return result;
	}


	@Override
	public List<AppointmentEntity> fetchPendingAppointments(String userid) {
		// TODO Auto-generated method stub
		UserEntity entity=new UserEntity();
		entity.setUserid(userid);
		return appointmentDao.fetchPendingAppointments(entity);
	}


	@Override
	public void updateAppointment(int appointmentId, String appointmentStatus) {
		// TODO Auto-generated method stub
		appointmentDao.updateAppointment(appointmentId,appointmentStatus);
	}

}
