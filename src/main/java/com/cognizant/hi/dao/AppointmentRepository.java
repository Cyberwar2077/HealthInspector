package com.cognizant.hi.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.hi.entity.AppointmentEntity;
import com.cognizant.hi.entity.UserEntity;

public interface AppointmentRepository extends JpaRepository<AppointmentEntity, Integer> {

	@Query("select u from AppointmentEntity u JOIN FETCH u.patientName where u.doctorName=?1 and u.appointmentStatus='P'")
	List<AppointmentEntity> fetchPendingAppointments(UserEntity entity);

	@Transactional
	@Modifying
	@Query("update AppointmentEntity u set u.appointmentStatus=?2 where u.appointmentId=?1")
	void updateAppointment(int appointmentId, String appointmentStatus);

}
